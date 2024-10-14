package com.hhplus.hhplus3week.app.user.controller;

import com.hhplus.hhplus3week.app.user.dto.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Tag(name = "유저 api")
public class UserController {

    /**
     * 아이디에 따른 유저 정보를 불러온다
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
        UserDTO user = new UserDTO();
        return ResponseEntity.ok(user);
    }
}
