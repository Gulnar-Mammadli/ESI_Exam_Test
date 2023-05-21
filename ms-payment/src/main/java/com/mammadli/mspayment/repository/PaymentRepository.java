package com.mammadli.mspayment.repository;

import com.mammadli.mspayment.model.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<UserBalance,Long> {
}
