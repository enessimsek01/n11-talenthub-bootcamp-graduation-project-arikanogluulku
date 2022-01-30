package com.n11.loanapplication.credit.dto.converter;

import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface CreditMapper {

    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    @Mapping(target = "user.id" , source = "userId")
    Credit convertToCredit(CreditSaveRequestDto creditSaveRequestDto);

    CreditResponseDto convertToCreditResponseDto(Credit credit);

    @Mapping(target = "userId" , source = "user.id")
    CreditSaveRequestDto convertToCreditSaveRequestDto(Credit credit);
}
