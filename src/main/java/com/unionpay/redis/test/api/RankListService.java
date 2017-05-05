package com.unionpay.redis.test.api;

import com.unionpay.redis.test.domain.RankList;

/**
 * date: 2017/05/05 14:51.
 * author: Yueqi Shi
 */
public interface RankListService {
    RankList getRanklist(int pageNum, int pageSize);

    String getTestKey();

    Long getExpiredTime(String key);

    Boolean hasKey(String key);

    Integer keysCount();
}
