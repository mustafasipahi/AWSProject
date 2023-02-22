package com.controller;

import com.dto.UserCreateDto;
import com.dto.UserDto;
import com.dto.UserUpdateDto;
import com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.create(userCreateDto));
    }

    @PutMapping("/update}")
    public ResponseEntity<UserDto> update(@RequestBody UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.update(userUpdateDto));
    }

    @PatchMapping("/update-status/{id}/{active}}")
    public void updateStatus(@PathVariable Long id, @PathVariable boolean active) {
        userService.updateStatus(id, active);
    }

    @DeleteMapping("/delete/{id}}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}}")
    public ResponseEntity<UserDto> detail(@PathVariable Long id) {
        return ResponseEntity.ok(userService.detail(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> list() {
        return ResponseEntity.ok(userService.list());
    }
}
