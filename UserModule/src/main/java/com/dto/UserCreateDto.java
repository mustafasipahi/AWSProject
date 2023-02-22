package com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    private String firstName;
    private String lastName;
    private String email;
}
