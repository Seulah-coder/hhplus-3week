package com.hhplus.hhplus3week.app.money.services;

import com.hhplus.hhplus3week.app.money.dto.MoneyDTO;
import com.hhplus.hhplus3week.app.money.models.Money;
import com.hhplus.hhplus3week.app.money.repositories.MoneyHistoryRepository;
import com.hhplus.hhplus3week.app.money.repositories.MoneyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MoneyServiceTest {

    @InjectMocks
    private MoneyService moneyService;

    @Mock
    private MoneyRepository moneyRepository;


    @Test
    void chargeMoney() {

        Money money = Money.builder()
                .currentAmount(3000)
                .userId(1L)
                .build();

        when(moneyRepository.save(money)).thenReturn(money);

        MoneyDTO moneyDTO = new MoneyDTO();
        moneyDTO.setChargeAmount(3000);
        moneyDTO.setUserId(1L);
        Money result = moneyService.chargeMoney(moneyDTO);

        assertNotNull(result);
        assertEquals(money.getCurrentAmount(), result.getCurrentAmount());
    }

    @Test
    void useMoney() {

        Money money = Money.builder()
                .currentAmount(3000)
                .userId(1L)
                .build();

        when(moneyRepository.save(money)).thenReturn(money);

        MoneyDTO moneyDTO = new MoneyDTO();
        moneyDTO.setUseAmount(2000);
        moneyDTO.setUserId(1L);
        Money result = moneyService.useMoney(moneyDTO);

        assertNotNull(result);
        assertEquals(money.getCurrentAmount(), result.getCurrentAmount());
    }

    @Test
    void getMoneyByUserId() {
    }
}