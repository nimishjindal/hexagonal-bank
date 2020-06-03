package com.nimish.hexagonalbanking.domain.entity;

import com.nimish.hexagonalbanking.domain.utils.TxnType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
public class Txn {

    @Id
    @GeneratedValue
    private Long txnId;

    @ManyToOne
    @JoinColumn(name="id")
    private Account accountId;

    private Long amount;

    @Enumerated(EnumType.STRING)
    private TxnType txnType;

    public Txn(Account accountId, Long amount, TxnType txnType) {
        this.accountId = accountId;
        this.amount = amount;
        this.txnType = txnType;
    }
}
