package pierre.valentin.imt.ne.archedenoe.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import pierre.valentin.imt.ne.archedenoe.entity.Animaux;
import pierre.valentin.imt.ne.archedenoe.entity.Arche;
import pierre.valentin.imt.ne.archedenoe.repository.ArcheRepository;
import pierre.valentin.imt.ne.archedenoe.repository.AnimauxRepository;


@Path("arches")

public class ArcheResource {
    @Autowired
    private ArcheRepository archeRepository;
    @Autowired
    private AnimauxRepository animauxRepository;

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
    public Arche UpdateAnArche(
            @PathParam("id") Long id,
            Arche a
            /*
            @RequestParam(value = "nom", defaultValue = "") String nom,
            @RequestParam(value = "occupation", defaultValue = "0") int occupation,
            @RequestParam(value = "capacite", defaultValue = "9999") int capacite*/
    ){
        /*
        a.setId(id);
        if(nom.isEmpty()){
            a.setNom(a.getNom());
        }
        else{
            a.setNom(String.valueOf(nom));
        }

        if(capacite == "9999".parseInt()){
            a.setCapacite(a.getCapacite());
        }
        else{
            a.setCapacite(capacite);
        }

        if(occupation == "0"){
            a.setOccupation(a.getOccupation());
        }
        else{
            a.setOccupation(occupation);
        }

        */
        return archeRepository.save(a);
    }

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

    @GET
    @Path("{id}/animaux")
    @Produces(MediaType.APPLICATION_JSON)
    // GET /arches/{id}/animaux
    public List<Animaux> listerAnimaux(@PathParam("id") Long id) {
        return archeRepository.findById(id).get().getAnimauxSet();
    }

    // Ajouter une arche
    @POST
    @Path("{idArche}/animaux")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddAnimalToArche(@PathParam("idArche") Long idArche, @RequestBody String animalId){
        Long animal = Long.valueOf(animalId);

        Optional<Arche> arche = archeRepository.findById(idArche);
        Optional<Animaux> animalOptional = animauxRepository.findById(animal);

        if(!arche.isPresent() || !animalOptional.isPresent()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Arche a = arche.get();
        Animaux an = animalOptional.get();
        a.getAnimauxSet().add(an);
        archeRepository.save(a);

        return Response.ok(a).build();

    }
}
