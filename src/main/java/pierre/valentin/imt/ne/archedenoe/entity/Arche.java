package pierre.valentin.imt.ne.archedenoe.entity;

import javax.persistence.*;

@Entity
@Table(name = "arche")
public class Arche {

    public Arche(){
        super();
    }

    public Arche(String nom, int capacite, int occupation) {
        super();
        this.nom = nom;
        this.capacite = capacite;
        this.occupation = occupation;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nom")
    String nom;

    @Column(name = "capacite")
    int capacite;

    @Column(name = "occupation")
    int occupation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }
}
