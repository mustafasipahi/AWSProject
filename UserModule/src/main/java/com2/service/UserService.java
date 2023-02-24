package com2.service;

import com2.advice.exception.UserNotActiveException;
import com2.advice.exception.UserNotFoundException;
import com2.converter.UserConverter;
import com2.dto.UserCreateDto;
import com2.dto.UserDto;
import com2.dto.UserUpdateDto;
import com2.model.User;
import com2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto create(UserCreateDto userCreateDto) {
        final User user = UserConverter.convertToUser(userCreateDto);
        return UserConverter.convertToUserDto(userRepository.save(user));
    }

    public UserDto update(UserUpdateDto userUpdateDto) {
        final User user = findByEmail(userUpdateDto.getEmail());

        if (!user.isActive()) {
            throw new UserNotActiveException();
        }

        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setEmail(userUpdateDto.getEmail());
        return UserConverter.convertToUserDto(userRepository.save(user));
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
        return UserConverter.convertToUserDto(user);
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
