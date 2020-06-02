package com.nimish.hexagonalbanking.infrastructure.request;

import com.nimish.hexagonalbanking.domain.CreateAccountCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateAccountRequest {
    private String name;
    private Date dob;

    public CreateAccountCommand toCommand(){
        return new CreateAccountCommand(this.name,this.dob);
    }

}
