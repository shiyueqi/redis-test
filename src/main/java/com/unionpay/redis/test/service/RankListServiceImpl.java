package com.unionpay.redis.test.service;

import com.unionpay.redis.test.api.RankListService;
import com.unionpay.redis.test.domain.RankList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * date: 2017/05/05 14:36.
 * author: Yueqi Shi
 */
@Service("rankListService")
public class RankListServiceImpl implements RankListService {

    private static final String RANK_LIST_KEY = "test_rank_list_key";

    private static final String TEST_KEY = "test_key";

    @Autowired
    private RedisTemplate redisTemplate;

    public RankList getRanklist(int pageNum, int pageSize) {
        int startNum = (pageNum - 1) * pageSize;
        int endNum = pageNum * pageSize;
        int rank = startNum;
        List<RankList.RankListItem> rankListItems = new ArrayList<RankList.RankListItem>();

        Set<ZSetOperations.TypedTuple<Integer>> resSet = redisTemplate.opsForZSet().rangeWithScores(RANK_LIST_KEY, startNum, endNum);
        Iterator<ZSetOperations.TypedTuple<Integer>> it = resSet.iterator();
        while(it.hasNext()) {
            long score = Long.valueOf(String.valueOf(it.next().getScore()));
            int value = it.next().getValue();
            RankList.RankListItem rankListItem = new RankList.RankListItem(++rank, score, value);
            rankListItems.add(rankListItem);
        }

        return new RankList(rankListItems);
    }

    public String getTestKey() {
        String res = (String)redisTemplate.opsForValue().get(TEST_KEY);
        return res;
    }

    public Long getExpiredTime(String key) {
        return redisTemplate.getExpire(key);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public Integer keysCount() {
        String keysPattern = "*";
        Set set = redisTemplate.keys(keysPattern);
        return set == null ? 0 : set.size();
    }

}
