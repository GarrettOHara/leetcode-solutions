import java.util.*;

class Solution {
  public static void main(String[] args){
    String[] arguments = {"Twitter","postTweet","getNewsFeed","follow","postTweet",
      "getNewsFeed","unfollow","getNewsFeed"};

  }
}
class Twitter {
    
    Map<Integer,List<Integer>> users_tweets;
    Map<Integer,List<Integer>> users_follows;
    
    public Twitter() {
        users_tweets = new HashMap<>();
        users_follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(users_tweets.containsKey(userId))
            users_tweets.get(userId).add(tweetId);
        else 
            users_tweets.put(userId,new ArrayList<Integer>(Arrays.asList(tweetId)));       
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(users_follows.containsKey(userId)){
            
            // GET USER FOLLOWERS
            List<Integer> user_media = users_follows.get(userId);
            
            // ORDER TWEETS IN DESCENDING ID
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            // ADD USERS TWEETS TO PQ
            for(int i : user_media){
                if(users_tweets.containsKey(i)){
                    List<Integer>tmp = users_tweets.get(i);
                    for(int j : tmp)
                        pq.offer(j);
                }
            }
            
            // CLEAR LIST FOR REUSING
            user_media.clear();
            
            // POLL 10 DESCEINDING TWEETS FROM PQ
            for(int i = 0; i < 10; i++){
                user_media.add(pq.poll());
            }
            return user_media;
        } else 
            return new ArrayList<Integer>();
    }
    
    public void follow(int followerId, int followeeId) {
        if(users_follows.containsKey(followerId))
            users_follows.get(followerId).add(followeeId);
        else
            users_follows.put(followerId,new ArrayList<Integer>(Arrays.asList(followeeId)));
    }
    
    public void unfollow(int followerId, int followeeId) {
        users_follows.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
