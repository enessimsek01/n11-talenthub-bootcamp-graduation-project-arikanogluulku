package com.n11.loanapplication.user.model;

import com.n11.loanapplication.gen.model.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
public class User implements BaseEntity {

    @Id
    @SequenceGenerator(name = "seq_user" , allocationSize = 1 , initialValue = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator ="seq_user" )
    private Long id;

    private String name;

    private String surname;

    private LocalDate dateOfBirthday;

    private String identificationNumber;

    private String phone;

    private BigDecimal salary;

    private BigDecimal guarantee;
}
