package com.n11.loanapplication.credit.repository;

import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@EnableJpaRepositories
public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query(
            "select " + " new  com.n11.loanapplication.credit.dto.CreditDetailResponseDto( " +
                    "user.name ," +
                    "user.surname, " +
                    "user.dateOfBirthday, " +
                    "user.identificationNumber, " +
                    "user.phone, " +
                    "user.salary, " +
                    "credit.creditResultType, " +
                    "credit.creditLimit " +
                    ") " +
                    "from User user " +
                    "left join Credit credit " +
                    "on credit.user.id = user.id " +
                    "where " +
                    "user.dateOfBirthday = :dateOfBirthday and  " +
                    "user.identificationNumber = :identificationNumber ")

    CreditDetailResponseDto getCreditApplicationDetailByIdentifitacionNumberAndBirthday(@Param("identificationNumber") String identificationNumber ,
                                                                                        @Param("dateOfBirthday") LocalDate dateOfBirthday);
}
