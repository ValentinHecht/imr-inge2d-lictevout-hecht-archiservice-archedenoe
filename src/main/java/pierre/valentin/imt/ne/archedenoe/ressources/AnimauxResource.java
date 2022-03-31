package pierre.valentin.imt.ne.archedenoe.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import pierre.valentin.imt.ne.archedenoe.repository.AnimauxRepository;

@Path("animaux")
public class AnimauxResource {
    @Autowired
    private AnimauxRepository animauxRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAllAnimals(){
        return "Animals";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAnAnimal(@PathParam("id") String id){
        return "Animal" + id;
    }
}
