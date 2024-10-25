package com.hhplus.hhplus3week.app.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JwtProviderTest {

    @InjectMocks
    JwtProvider jwtProvider;

    @Test
    void createAccessToken() {
        Long userId = 1L;
        String test = jwtProvider.createAccessToken(userId);
        System.out.println("test = " + test);
    }

    @Test
    void getUserIdFromToken() {
    }

    @Test
    void validateToken() {
    }
}