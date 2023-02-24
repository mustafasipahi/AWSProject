package com.service;

import com.advice.exception.UserNotActiveException;
import com.advice.exception.UserNotFoundException;
import com.converter.UserConverter;
import com.dto.user.UserCreateDto;
import com.dto.user.UserDto;
import com.dto.user.UserUpdateDto;
import com.model.User;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserDto create(UserCreateDto userCreateDto) {
        final User user = UserConverter.convertToUser(userCreateDto);
        return UserConverter.convertToUserDto(userRepository.save(user));
    }

    @Transactional
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

    @Transactional
    public void updateStatus(Long userId, boolean active) {
        final User user = findById(userId);
        user.setActive(active);
        userRepository.save(user);
    }

    @Transactional
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

    protected User findById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(UserNotFoundException::new);
    }
}
