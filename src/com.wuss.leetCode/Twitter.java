package com.wuss.leetCode;
import java.util.*;

class Twitter {
    static int talkedId = 0;
    Map<Integer, List<Talk>> dbMap = new HashMap<>();
    Map<Integer, Set<Integer>> friendMap = new HashMap<>();

    class Talk {
        int tweetId;
        int talkId = 0;

        public Talk(int tweetId) {
            this.tweetId = tweetId;
            this.talkId = ++talkedId;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Talk> list = dbMap.get(userId);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new Talk(tweetId));
        dbMap.put(userId, list);

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        int maxSize = 10;
        List<Talk> list1 = dbMap.get(userId);
        List<Talk> list = new ArrayList<>();
        if (list1 == null) {
            list1 = new ArrayList<>();
        }
        list.addAll(list1);
        Set<Integer> friedList = friendMap.get(userId);
        if (friedList != null) {
            for (Integer i : friedList) {
                List<Talk> talk1 = dbMap.get(i);
                if (talk1 == null) {
                    continue;
                }
                list.addAll(talk1);
            }
        }

        Collections.sort(list, new Comparator<Talk>() {
            @Override
            public int compare(Talk o1, Talk o2) {
                return o2.talkId - o1.talkId;
            }
        });
        maxSize = Math.min(maxSize, list.size());
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            resultList.add(list.get(i).tweetId);
        }
        return resultList;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> friendList = friendMap.get(followerId);
        if (friendList == null) {
            friendList = new HashSet<>();
        }
        friendList.add(followeeId);
        friendMap.put(followerId, friendList);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> friendList = friendMap.get(followerId);
        if (friendList == null) {
            return;
        }
        friendList.remove(Integer.valueOf(followeeId));
        friendMap.put(followerId, friendList);
    }
}

    

