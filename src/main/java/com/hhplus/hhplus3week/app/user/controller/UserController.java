package com.hhplus.hhplus3week.app.user.controller;

import com.hhplus.hhplus3week.app.user.dto.UserSaveDTO;
import com.hhplus.hhplus3week.app.user.models.User;
import com.hhplus.hhplus3week.app.user.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "유저 api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 아이디에 따른 유저 정보를 불러온다
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    /**
     * 유저 정보를 저장한다
     * @param userSaveDTO
     * @return
     */

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(UserSaveDTO userSaveDTO){
        User user = userService.saveUser(userSaveDTO);
        return ResponseEntity.ok(user);
    }

    /**
     * 유저의 예약 정보를 가져온다
     * @param userId
     * @return
     */
    @GetMapping("/bookings/{userId}")
    public ResponseEntity<User> getUserByIdWithBookingList(@PathVariable("userId") Long userId){
        User user = userService.getUserByIdWithBookingList(userId);
        return ResponseEntity.ok(user);
    }

}
