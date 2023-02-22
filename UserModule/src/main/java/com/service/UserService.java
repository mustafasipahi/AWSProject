package com.service;

import com.advice.exception.UserNotActiveException;
import com.advice.exception.UserNotFoundException;
import com.converter.UserConverter;
import com.dto.UserCreateDto;
import com.dto.UserDto;
import com.dto.UserUpdateDto;
import com.model.User;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.converter.UserConverter.convertToUser;
import static com.converter.UserConverter.convertToUserDto;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto create(UserCreateDto userCreateDto) {
        final User user = convertToUser(userCreateDto);
        return convertToUserDto(userRepository.save(user));
    }

    public UserDto update(UserUpdateDto userUpdateDto) {
        final User user = findByEmail(userUpdateDto.getEmail());

        if (!user.isActive()) {
            throw new UserNotActiveException();
        }

        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setEmail(userUpdateDto.getEmail());
        return convertToUserDto(userRepository.save(user));
    }

    public void updateStatus(Long userId, boolean active) {
        final User user = findById(userId);
        user.setActive(active);
        userRepository.save(user);
    }

    public void delete(Long userId) {
        final User user = findById(userId);
        userRepository.delete(user);
    }

    public UserDto detail(Long userId) {
        final User user = findById(userId);
        return convertToUserDto(user);
    }

    public List<UserDto> list() {
        return userRepository.findAll().stream()
            .map(UserConverter::convertToUserDto)
            .collect(Collectors.toList());
    }

    private User findById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(UserNotFoundException::new);
    }
}
