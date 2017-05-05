package com.unionpay.redis.test;

import com.unionpay.redis.test.api.RankListService;
import com.unionpay.redis.test.domain.RankList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;

/**
 * date: 2017/05/05 14:33.
 * author: Yueqi Shi
 */
public class RedisMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        RankListService rankListService = (RankListService) applicationContext.getBean("rankListService");
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");

        int pageNum = 1;
        int pageSize = 10;
        String testKey = "test_key";
        RankList rankList = rankListService.getRanklist(pageNum, pageSize);


        System.out.println(rankList.toString());

        System.out.println(rankListService.getTestKey());

        System.out.println(rankListService.getExpiredTime(testKey));

        System.out.println(rankListService.hasKey(testKey));

        System.out.println(rankListService.keysCount());

        try {
            byte[] key = new String("test_key2").getBytes("utf-8");
            redisTemplate.opsForValue().set(key, (new String("test_value2")).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println((String) redisTemplate.opsForValue().get("test_key2"));
    }

}
