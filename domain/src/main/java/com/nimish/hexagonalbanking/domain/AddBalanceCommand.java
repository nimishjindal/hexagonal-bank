package com.nimish.hexagonalbanking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddBalanceCommand {
    private Long id;
    private Double amount;
}
