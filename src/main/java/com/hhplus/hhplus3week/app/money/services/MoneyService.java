package com.hhplus.hhplus3week.app.money.services;

import com.hhplus.hhplus3week.app.money.dto.MoneyDTO;
import com.hhplus.hhplus3week.app.money.models.Money;
import com.hhplus.hhplus3week.app.money.models.MoneyHistory;
import com.hhplus.hhplus3week.app.money.repositories.MoneyHistoryRepository;
import com.hhplus.hhplus3week.app.money.repositories.MoneyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MoneyService {

    private final MoneyRepository moneyRepository;

    private final MoneyHistoryRepository moneyHistoryRepository;

    @Transactional
    public Money chargeMoney(MoneyDTO moneyDTO) {
        Money findMoney = getMoneyByUserId(moneyDTO.getUserId());
        int amount = findMoney != null? findMoney.getCurrentAmount() + moneyDTO.getChargeAmount() : moneyDTO.getChargeAmount();

        Money updateMoney = Money.builder()
                .id(findMoney != null? findMoney.getId() : null)
                .currentAmount(amount)
                .userId(moneyDTO.getUserId())
                .build();

        MoneyHistory moneyHistory = MoneyHistory.builder()
                .type("charge")
                .amountRecord(moneyDTO.getChargeAmount())
                .userId(moneyDTO.getUserId())
                .build();
        moneyHistoryRepository.save(moneyHistory);

        return moneyRepository.save(updateMoney);
    }

    @Transactional
    public Money useMoney(MoneyDTO moneyDTO) {
        Money findMoney = getMoneyByUserId(moneyDTO.getUserId());
        Money updatedMoney = findMoney.toBuilder()
                .currentAmount(findMoney.getCurrentAmount() - moneyDTO.getUseAmount())
                .build();

        MoneyHistory moneyHistory = MoneyHistory.builder()
                .type("use")
                .amountRecord(moneyDTO.getUseAmount())
                .userId(moneyDTO.getUserId())
                .build();
        moneyHistoryRepository.save(moneyHistory);

        return moneyRepository.save(updatedMoney);
    }

    public Money getMoneyByUserId(Long userId){
        return moneyRepository.findByUserId(userId);
    }
}
