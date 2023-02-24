package com.converter;

import com.dto.UserCreateDto;
import com.dto.UserDto;
import com.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .build();
    }

    public static User convertToUser(UserCreateDto userCreateDto) {
        return User.builder()
            .firstName(userCreateDto.getFirstName())
            .lastName(userCreateDto.getLastName())
            .email(userCreateDto.getEmail())
            .build();
    }
}
