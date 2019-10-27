package za.ac.tut.model;

import java.io.Serializable;
import java.util.Date;

public class DataO implements Serializable {

	private static final long serialVersionUID = -6758296956091695650L;

	private Integer ID;
	private Date timeStamp;
	private String tweet;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String gettweet() {
		return tweet;
	}

	public void settweet(String tweet) {
		this.tweet = tweet;
	}

	@Override
	public String toString() {
		return "TwitterDTO [ID=" + ID + ", timeStamp=" + timeStamp + ", tweet=" + tweet + "]";
	}

}
