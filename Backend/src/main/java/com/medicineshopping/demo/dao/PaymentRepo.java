package com.medicineshopping.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicineshopping.demo.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}