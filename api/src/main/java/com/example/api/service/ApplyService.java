package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.producer.CouponCreateProducer;
import com.example.api.repository.ApplidUserRepository;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final int MAX_COUPON_COUNT = 100;
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;
    private final ApplidUserRepository applidUserRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer, ApplidUserRepository applidUserRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
        this.applidUserRepository = applidUserRepository;
    }

    public void apply(Long userId) {
        // before
        // Long count = couponRepository.count();

        // after
        Long apply = applidUserRepository.add(userId);
        if (apply == 0) {
            return; // user already coupon applied
        }

        Long count = couponCountRepository.increment();

        if (count > MAX_COUPON_COUNT) {
            return; // Do nothing
        }

        couponCreateProducer.create(userId);
    }

}
