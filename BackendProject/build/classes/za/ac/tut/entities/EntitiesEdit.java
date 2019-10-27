package za.ac.tut.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the twitter_data database table.
 * 
 */
@Entity
@Table(name="twitter_data")
@NamedQueries({
	@NamedQuery(name="twitterData.findAll", query="SELECT t FROM twitterData t"),
	@NamedQuery(name="twitterData.findAllById", query="SELECT t FROM twitterData t where t.ID = :ID")
})
public class EntitiesEdit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tweet_ID")
	private Integer ID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_stamp")
	private Date timeStamp;

	@Column(name="tweet_detail")
	private String tweet;

	public EntitiesEdit() {
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.tweetID = ID;
	}



	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTweet() {
		return this.tweet;
	}

	public void setTweet(String tweet) {
		this.tweetBody = tweet;
	}

}