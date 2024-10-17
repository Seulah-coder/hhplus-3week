package com.hhplus.hhplus3week.app.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtProviderTest {

    @Mock
    private JwtProvider jwtProvider;

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