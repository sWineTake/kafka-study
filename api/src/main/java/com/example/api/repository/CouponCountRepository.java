package com.example.api.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CouponCountRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public CouponCountRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long increment() {
        // do you want more info? -> TODO) 해당 코드가 어떻게 동작하는지 설명해주세요.
        return redisTemplate.opsForValue().increment("coupon_count");
    }

}
