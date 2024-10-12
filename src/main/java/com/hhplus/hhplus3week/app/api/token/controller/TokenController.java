package com.hhplus.hhplus3week.app.api.token.controller;

import com.hhplus.hhplus3week.app.api.token.dto.TokenDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "토큰 api")
@RequestMapping("/api/token")
public class TokenController {

    @PostMapping("/request")
    public ResponseEntity<TokenDTO> requestToken(TokenDTO tokenDTO){
        return ResponseEntity.ok(tokenDTO);
    }
}
