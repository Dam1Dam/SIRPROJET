package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import Service.ParticipantDao;
import jpaModel.Participant;

@Path("/participants")
public class SampleWebService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participant> getParticipants() {
		ParticipantDao pdao = new ParticipantDao();
		return pdao.findAll();
	}
	
	
 	
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Participant  getParticipantByName(@PathParam("id") Long id) {
			ParticipantDao pdao = new ParticipantDao();
			return pdao.findById(id);
		}
		
		@GET
		@Path("/query")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Participant> getParticipantsWithName(@Context UriInfo info){
			String firstname = info.getQueryParameters().getFirst("firstname");
			ParticipantDao pdao = new ParticipantDao();
			return pdao.findByFirstName(firstname);
			
		}
		
		
		


}
