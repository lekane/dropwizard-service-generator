package ${package};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/${classNamePrefix?lower_case}")
@Produces(MediaType.APPLICATION_JSON)
public class ${classNamePrefix}Resource {
    private static final Logger LOG = LoggerFactory.getLogger( ${classNamePrefix}Resource.class );

    public ${classNamePrefix}Resource() {
        //
    }

    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStatus( ) {
    	return "OK";
    }

}