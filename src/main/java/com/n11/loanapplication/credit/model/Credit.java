package com.n11.loanapplication.credit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.n11.loanapplication.credit.enums.CreditResultType;
import com.n11.loanapplication.gen.model.BaseEntity;
import com.n11.loanapplication.user.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "credit")
public class Credit implements BaseEntity {
    @Id
    @SequenceGenerator(name = "seq_credit", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_credit")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    private CreditResultType creditResultType;

    private BigDecimal creditLimit;
}
