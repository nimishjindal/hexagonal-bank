package com.nimish.hexagonalbanking.infrastructure.request;

import com.nimish.hexagonalbanking.domain.AddBalanceCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddBalanceRequest {
    private Long id;
    private Double amount;

    public AddBalanceCommand toCommand(){
        return new AddBalanceCommand(this.id, this.amount);
    }

}
