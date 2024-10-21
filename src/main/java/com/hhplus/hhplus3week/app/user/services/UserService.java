package com.hhplus.hhplus3week.app.user.services;

import com.hhplus.hhplus3week.app.user.dto.UserSaveDTO;
import com.hhplus.hhplus3week.app.user.models.User;
import com.hhplus.hhplus3week.app.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public User saveUser(UserSaveDTO userSaveDTO) {
        User user = User.builder()
                .name(userSaveDTO.getName())
                .mobile(userSaveDTO.getMobile())
                .name(userSaveDTO.getName())
                .build();

        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 유저가 없습니다."));
    }

    public User getUserByIdWithBookingList(Long userId){
        return userRepository.findUserByIdWithBookingList(userId);
    }
}
