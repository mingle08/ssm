package com.ssmstudy.redis;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedissonDemo {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedissonClient redisson;

    public String deductStock() {
        String lockKey = "jcjtLockKey";
        RLock rLock = redisson.getLock(lockKey);
        try {
            rLock.tryLock(30, TimeUnit.SECONDS);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("商品扣减成功，剩余库存" + realStock + "");
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
        return "ok";
    }
}
