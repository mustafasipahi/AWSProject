package com2.converter;

import com2.dto.UserCreateDto;
import com2.dto.UserDto;
import com2.model.User;
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
