class Twitter {
    private static int timeStamp = 0;

    private class User {
        int user_id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int user_id) {
            this.user_id = user_id;
            this.followed = new HashSet<>();
            follow(user_id);
            this.tweetHead = null;
        }

        public void follow(int user_id) {
            followed.add(user_id);
        }

        public void unfollow(int user_id) {
            if (user_id != this.user_id) {
                followed.remove(user_id);
            }
        }

        public void post(int tweet_id) {
            Tweet newTweet = new Tweet(tweet_id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }

    }

    private class Tweet {
        int tweet_id;
        int tweet_time;
        Tweet next;

        public Tweet(int tweet_id) {
            this.tweet_id = tweet_id;
            tweet_time = timeStamp++;
            next = null;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User newuser = new User(userId);
            userMap.put(userId, newuser);
        }

        userMap.get(userId).post(tweetId);

    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if (!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetPriorityQueue = new PriorityQueue<>(followedUsers.size(), (a, b) -> b.tweet_time - a.tweet_time);

        for (int user : followedUsers) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null) {
                tweetPriorityQueue.add(tweet);
            }
        }

        int count = 0;
        while (!tweetPriorityQueue.isEmpty() && count < 10) {
            Tweet tweet = tweetPriorityQueue.poll();
            newsFeed.add((tweet.tweet_id));
            count++;

            if (tweet.next != null) {
                tweetPriorityQueue.add(tweet.next);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }

        if (!userMap.containsKey(followeeId)) {
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
