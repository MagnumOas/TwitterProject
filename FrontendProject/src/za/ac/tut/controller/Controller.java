package za.ac.tut.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

import za.ac.tut.actions.ActionsToDo;
import za.ac.tut.model.DataO;

@ManagedBean(name = "Controller")
@SessionScoped
public class Controller {

	Client client = ClientBuilder.newClient();
	private List<DataO> ListOfTweet;
	private String tweet;

	public void getAllTweets() {
		this.tweetsList = client.target(ActionsToDo.URL + ActionsToDo.GET_ALL_TWEETS).request()
				.get(new GenericType<List<DataO>>() {
				});
	}

	public void saveTweet() {
		String status = client.target(ActionsToDo.URL+ActionsToDo.CREATE_TWEET).request().post(Entity.json(twitterBody()),String.class);
		if(status != null) {
		
		}
	}

	public void clearTweets() {
		if (this.ListOfTweet != null) {
			ListOfTweet.clear();
		}
	}

	private DataO twitterBody() {
		DataO dta = new DataO();
		dta.setTweet(tweet);
		return dto;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public List<DataO> getListOfTweet() {
		return ListOfTweet;
	}

	public void setListOfTweet(List<DataO> ListOfTweet) {
		this.ListOfTweet = ListOfTweet;
	}

}
