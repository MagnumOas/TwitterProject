package za.ac.tut.interfaces;

import java.util.List;

import twitter4j.TwitterException;
import za.ac.tut.dataO.DataO;
import za.ac.tut.entities.EntitiesEdit;

public interface ITwitter {
	
	List<DataO> getAllTweetsByID();
	EntitiesEdit saveTweet(DataO twitterData);
	void postTweet(String message) throws TwitterException;
	
}
