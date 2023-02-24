package com.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {

    private String firstName;
    private String lastName;
    private String email;
}
