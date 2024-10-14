package com.hhplus.hhplus3week.app.token.controller;

import com.hhplus.hhplus3week.app.token.dto.TokenDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "토큰 api")
@RequestMapping("/api/token")
public class TokenController {

    @PostMapping("/save")
    public ResponseEntity<TokenDTO> saveToken(TokenDTO tokenDTO){
        return ResponseEntity.ok(tokenDTO);
    }
}
