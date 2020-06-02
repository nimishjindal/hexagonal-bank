package com.nimish.hexagonalbanking.infrastructure.request;

import com.nimish.hexagonalbanking.domain.GetOneAccountQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetOneAccountRequest {
    private Long id;

    public GetOneAccountQuery toQuery(){
        return new GetOneAccountQuery(this.id);
    }

}
