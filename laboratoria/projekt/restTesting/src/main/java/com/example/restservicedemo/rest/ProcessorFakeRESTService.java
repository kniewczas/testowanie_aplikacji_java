package com.example.restservicedemo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import com.example.restservicedemo.domain.Processor;
import com.example.restservicedemo.service.ProcessorManager;

@Path("processor")
public class ProcessorFakeRESTService {	
	
	private ProcessorManager pm = new ProcessorManager();
	
	//SELECT
	@GET
	@Path("/{processorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Processor getProcessor(@PathParam("processorId") Long id){
		
		Processor p = pm.getProcessor(id);
		//result = "model: " + p.getModel() + " family: " + p.getFamily() + " cores: " + p.getCores(); 
		return p;
	}
	
	//SELECT ALL
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Processor> getAllProcessors(){
		List<Processor> processors = pm.getAllProcessors();
		return processors;
	}
	
	//GET ROWS
	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRows(){
		String result = Integer.toString(pm.getRows());
		return result;
	}
	
	/*//SEARCH BY FAMILY
	@GET
	@Path("/find/family={family}")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Processor> searchProcessors(@PathParam("family") String family){
		List<Processor> processors = pm.searchProcessors(family);
		return processors;
	}
	*/

	//SEARCH BY FASTEST
	@GET
	@Path("/find/fastest")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Processor> searchFastest(){
		List<Processor> processors = pm.showFastest();
		return processors;
	}
	
	//ADVANCED SEARCH 
	@GET
	@Path("/find/{family}/{model}")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Processor> advancedSearch(@PathParam("family") String family, @PathParam("model") String model){
		List<Processor> processors = pm.advancedSearch(family, model);
		return processors;
	}
		
	//INSERT
	@POST 
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProcessor(Processor processor){
		pm.addProcessor(processor);
		return Response.status(201).entity("Processor").build();
	}
	
	//DELETE
	@DELETE
	@Path("/{processorId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProcessor(@PathParam("processorId") long id){
		pm.deleteProcessor(id);
		return Response.status(201).entity("Processor").build();
	}
	
	//DELETE ALL
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProcessor(){
		pm.clearProcessors();
		return Response.status(201).entity("Processor").build();
	}
	
	//UPDATE
	@PUT
	@Path("/{processorId}/{family}/{model}/{clockRating}/{cores}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProcessor(@PathParam("processorId") long id, @PathParam("model") String model, @PathParam("family") String family, @PathParam("clockRating") double clockRating, @PathParam("cores") int cores){
		Processor processor = new Processor(id, model, family, clockRating, cores);		
		pm.updateProcessor(id, processor);
		return Response.status(200).entity("Processor").build();
	}


}
