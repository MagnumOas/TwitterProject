package za.ac.tut.rs;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import za.ac.tut.dataO.DataO;
import za.ac.tut.entities.EntitiesEdit;
import za.ac.tut.serv.TwitterService;

@Path("twitter")
public class TwitterResource {
	
	@Inject
	TwitterService twitterService;
	
	@POST
	@Path("/createTweet")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTweet(DataO twitterDto) {
		EntitiesEdit dta = twitterService.saveTweet(twitterData);
		return Response.ok(dta).build();
	}
	
	@GET
	@Path("/findAllTweet")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DataO> findAllTweet() {
		return twitterService.getAllTweetsByID();
	}
}
