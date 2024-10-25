
package com.hhplus.hhplus3week.app.money.dto;

import lombok.Data;

@Data
public class MoneyDTO {

    private Long id;
    private Long userId;
    private int useAmount;
    private int chargeAmount;
    private String type;
}
