package com.controller;

import com.dto.userdetail.UserDetailCreateDto;
import com.dto.userdetail.UserDetailDto;
import com.dto.userdetail.UserDetailUpdateDto;
import com.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user-detail")
@RequiredArgsConstructor
public class UserDetailController {

    private final UserDetailService userDetailService;

    @PostMapping("/create")
    public ResponseEntity<UserDetailDto> create(@RequestBody UserDetailCreateDto userDetailCreateDto) {
        return ResponseEntity.ok(userDetailService.create(userDetailCreateDto));
    }

    @PutMapping("/update/{id}}")
    public ResponseEntity<UserDetailDto> update(@PathVariable Long id, @RequestBody UserDetailUpdateDto userDetailUpdateDto) {
        return ResponseEntity.ok(userDetailService.update(id, userDetailUpdateDto));
    }

    @DeleteMapping("/delete/{id}}")
    public void delete(@PathVariable Long id) {
        userDetailService.delete(id);
    }
}
