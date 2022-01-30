package com.n11.loanapplication.user.repository;

import com.n11.loanapplication.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdentificationNumber(String identificationNumber);
}
