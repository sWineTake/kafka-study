package com.example.consumer.config.repository;

import com.example.consumer.config.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {



}
