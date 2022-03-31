package pierre.valentin.imt.ne.archedenoe.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pierre.valentin.imt.ne.archedenoe.entity.Arche;
import pierre.valentin.imt.ne.archedenoe.repository.ArcheRepository;


@Path("arches")
public class ArcheResource {
    @Autowired
    private ArcheRepository archeRepository;

    // Récupérer toutes les arches
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Arche> GetAllArche(){
        List<Arche> archeList = new ArrayList<>();
        archeRepository.findAll().forEach(archeList::add);
        return archeList;
    }

    // Recupérer une arche en particulier
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetArcheById(@PathParam("id") Long id){
        Optional<Arche> a = archeRepository.findById(id);
        if(a.isPresent()){
            return Response.ok(a.get()).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // em.find(Employee.class, id); avec em = entity manager surement
    }

    // Modifier un element dune arche
    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ModifyAnArche(@PathParam("id") String id){
        return "PUT" + id;
    }

    // Modifier completement une arche
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Arche UpdateAnArche(@PathParam("id") Long id, Arche a){
        a.setId(id);
        return archeRepository.save(a);
    }

    /*
        D'apres le cours pour enregister une entité
     */

    // Ajouter une arche
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long AddAnArche(Arche a){
        archeRepository.save(a);
        return a.getId();
    }

    // Supprimer une arche
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeleteAnArche(@PathParam("id") long id){
        if (archeRepository.findById(id).isPresent()) {
            archeRepository.deleteById(id);
        }
        return Response.noContent().build();
    }
}
