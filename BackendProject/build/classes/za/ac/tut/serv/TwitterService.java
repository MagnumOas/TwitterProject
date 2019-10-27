package za.ac.tut.serv;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import za.ac.tut.dataO.DataO;
import za.ac.tut.entities.EntitiesEdit;
import za.ac.tut.interfaces.ITwitter;

@Stateless
@LocalBean
public class TwitterService implements ITwitter {

	@PersistenceContext
	EntityManager em;

	
	TwitterFactory twitterFactory = new TwitterFactory();

	Twitter twitter = twitterFactory.getInstance();

	@SuppressWarnings("unchecked")
	@Override
	public List<DataO> getAllTweetsByID() {
		Query query = em.createNamedQuery("TwitterDetail.findAll");
		return (List<DataO>) query.getResultList();
	}

	@Override
	public EntitiesEdit saveTweet(DataO twitterDTO) {
		String recipiantName = "@sdfdfdfsdf";
		EntitiesEdit twitterDetails = new EntitiesEdit();
		if (twitterDTO != null) {
			twitterDetails.setTweetBody( twitterDTO.getTweetBody());
			twitterDetails.setTimeStamp(new Date());
			em.persist(twitterDetails);
			try {
				postTweet(recipiantName + " " +twitterDetails.getTweetBody());
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}
		return twitterDetails;
	}

	@Override
	public void postTweet(String tweetBody) throws TwitterException {

		StatusUpdate statusUpdate = new StatusUpdate(tweetBody);

		getInstance().updateStatus(statusUpdate);

	}

	private Twitter getInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("dddddddddddddddddddddddddddddddd")
		  .setOAuthConsumerSecret("dddddddddddddddddddddddddddddddddddddddddd")
		  .setOAuthAccessToken("ddfffffffffffffffffffffffffffffffffffffffffff")
		  .setOAuthAccessTokenSecret("dffffffffffffffffffffffffffffffffffffffffff");
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}
}
