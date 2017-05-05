package com.unionpay.redis.test.domain;

import java.util.List;

/**
 * date: 2017/05/05 14:35.
 * author: Yueqi Shi
 */
public class RankList {

    private List<RankListItem> rankListItems;

    public RankList() {
    }

    public RankList(List<RankListItem> rankListItems) {
        this.rankListItems = rankListItems;
    }

    public List<RankListItem> getRankListItems() {
        return rankListItems;
    }

    public void setRankListItems(List<RankListItem> rankListItems) {
        this.rankListItems = rankListItems;
    }

    @Override
    public String toString() {
        return "RankList{" +
                "rankListItems=" + rankListItems +
                '}';
    }

    public static class RankListItem {
        private int rank;

        private long score;

        private int id;

        public RankListItem() {
        }

        public RankListItem(int rank, long score, int id) {
            this.rank = rank;
            this.score = score;
            this.id = id;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "RankListItem{" +
                    "rank=" + rank +
                    ", score=" + score +
                    ", id=" + id +
                    '}';
        }
    }
}


