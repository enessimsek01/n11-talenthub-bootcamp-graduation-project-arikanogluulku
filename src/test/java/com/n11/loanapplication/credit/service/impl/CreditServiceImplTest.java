package com.n11.loanapplication.credit.service.impl;

import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.model.Credit;
import com.n11.loanapplication.credit.repository.CreditRepository;
import com.n11.loanapplication.gen.exception.CreditNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.n11.loanapplication.credit.service.impl.CreditDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class CreditServiceImplTest {

    @InjectMocks
    CreditServiceImpl creditService;

    @Mock
    CreditRepository creditRepository;


    @Test
    void shouldSaveCredit(){
        Credit credit = getCredit();
        CreditSaveRequestDto creditSaveRequestDto= getCreditSaveRequestDto();
        CreditResponseDto creditResponseDto = getCreditResponseDto();

        when(creditRepository.save(ArgumentMatchers.any(Credit.class))).thenReturn(credit);

        CreditResponseDto result = creditService.saveCredit(creditSaveRequestDto);

        assertEquals(result , creditResponseDto);

    }
    @Test
    void shouldInquiryCreditApplication(){
        CreditDetailResponseDto creditDetailResponseDto = getCreditDetailResponseDto();

        when(creditRepository.getCreditApplicationDetailByIdentifitacionNumberAndBirthday("11111111111", LocalDate.now())).thenReturn(creditDetailResponseDto);

        CreditDetailResponseDto result = creditService.inquiryCreditApplication("11111111111", LocalDate.now());

        assertEquals(result,creditDetailResponseDto);
    }

    @Test
    void shouldNotInquiryCreditApplicationWhenCreditNotExist(){
        when(creditRepository.getCreditApplicationDetailByIdentifitacionNumberAndBirthday("00000000000",LocalDate.now()))
                .thenThrow(new CreditNotFound("Credit Not Found"));

        assertThrows(RuntimeException.class , () -> creditService.inquiryCreditApplication("00000000000", LocalDate.now()));

        verify(creditRepository).getCreditApplicationDetailByIdentifitacionNumberAndBirthday("00000000000",LocalDate.now());

    }


}