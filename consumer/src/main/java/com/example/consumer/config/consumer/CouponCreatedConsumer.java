package com.example.consumer.config.consumer;

import com.example.consumer.config.domain.Coupon;
import com.example.consumer.config.repository.CouponRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CouponCreatedConsumer {

	private final CouponRepository couponRepository;

	public CouponCreatedConsumer(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;
	}

	@KafkaListener(topics = "coupon_create", groupId = "group_1")
	public void listener(Long userId) {
		couponRepository.save(new Coupon(userId));



	}


}
