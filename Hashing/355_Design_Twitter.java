import java.util.*;

class Twitter {
    
    TreeMap<Integer, Integer> tweets;       // map tweet time to tweet id
    Map<Integer, Set<Integer>> users;       // keep set of all user tweets
    Map<Integer, Set<Integer>> followers;   // keep set of followers each user has
    Map<Integer, Set<Integer>> tweet_map;   // tweet id to set of followers
    int tweet_time;                         // virtual tweet time

    public Twitter() {
        
        /**
        DATA STRUCTURES
        
        tweets
        treemap key:    tweet time
                value:  pointer to tweet
        
        users
        map     key:    user
                value:  set of tweets
        
        followers
        map     key:    user
                value:  set of followers
        
        tweet_map
        map     key:    tweetId
                value: set of all followers
        
        FUNCTIONS
        getNewsFeed: 
            - iterate treemap, check if our ID is contained in treemap value set
                if so, increment counter
                break and return when counter is 10
            
        follow user: 
            - get users list of tweets in treemap and add your id to the hashset
        
        un-follow user:
            0 get users list of tweets in treemap and remove your id from the hashset
                
        **/
        
        tweets = new TreeMap<>( (a,b) -> b-a );
        users  = new HashMap<>();
        followers = new HashMap();
        tweet_map = new HashMap();
        tweet_time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if(!followers.containsKey(userId))
            followers.put(userId,new HashSet<>());  // create new set if empty
        
        followers.get(userId).add(userId);          // user follows themself
        
        Set<Integer> references = followers.get(userId);
               
        tweets.put(tweet_time,tweetId);
        tweet_map.put(tweetId,references);          // who follows this tweet
        
        if(!users.containsKey(userId))
            users.put(userId,new HashSet<>());      // create new set if empty
        
        users.get(userId).add(tweetId);             // update users tweets
        tweet_time++;                               // increment virtual time
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry : tweets.entrySet()){
            
            if(news.size() >= 10)                           // news feed full
                break;
            
            Set<Integer> followers = tweet_map.get(entry.getValue());
            if(followers.contains(userId))                  // check if user follows this tweet
                news.add(tweets.get(entry.getKey()));       // add tweetId to news feed
        }
        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        
        if(!followers.containsKey(followeeId))
            followers.put(followeeId,new HashSet<>());      // create empty followers set if null
        followers.get(followeeId).add(followerId);          // add follower to set
       
        Set<Integer> user_tweets = users.get(followeeId);   // grab followee's tweets to udpate
        if(user_tweets != null){
            
            for(int id : user_tweets)
                tweet_map.get(id).add(followerId);          // update tweet with new follower
            
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followers.containsKey(followeeId) || followerId == followeeId)
            return;
        
        followers.get(followeeId).remove(followerId);
        
        Set<Integer> user_tweets = users.get(followerId);
        if(user_tweets!=null){
            for(int id : user_tweets){
                if(id == followeeId)                        // don't affect the other's followers when overlap
                    tweet_map.get(id).remove(followeeId);
            }    
        }
        
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
