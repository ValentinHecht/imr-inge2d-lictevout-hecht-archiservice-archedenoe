package pierre.valentin.imt.ne.archedenoe.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import pierre.valentin.imt.ne.archedenoe.entity.Animaux;
import pierre.valentin.imt.ne.archedenoe.repository.AnimauxRepository;


@Path("animaux")
public class AnimauxResource {
    @Autowired
    private AnimauxRepository AnimauxRepository;

    // Récupérer toutes les Animaux
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animaux> GetAllAnimaux(){
        List<Animaux> AnimauxList = new ArrayList<>();
        AnimauxRepository.findAll().forEach(AnimauxList::add);
        return AnimauxList;
    }

    // Recupérer une Animaux en particulier
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAnimauxById(@PathParam("id") Long id){
        Optional<Animaux> a = AnimauxRepository.findById(id);
        if(a.isPresent()){
            return Response.ok(a.get()).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // em.find(Employee.class, id); avec em = entity manager surement
    }

    // Modifier un element dune Animaux
    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ModifyAnAnimaux(@PathParam("id") String id){
        return "PUT" + id;
    }

    // Modifier completement une Animaux
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Animaux UpdateAnAnimaux(@PathParam("id") Long id, Animaux a){
        a.setId(id);
        return AnimauxRepository.save(a);
    }

    // Ajouter une Animaux
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long AddAnAnimaux(Animaux a){
        AnimauxRepository.save(a);
        return a.getId();
    }

    // Supprimer une Animaux
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeleteAnAnimaux(@PathParam("id") long id){
        if (AnimauxRepository.findById(id).isPresent()) {
            AnimauxRepository.deleteById(id);
        }
        return Response.noContent().build();
    }
}
