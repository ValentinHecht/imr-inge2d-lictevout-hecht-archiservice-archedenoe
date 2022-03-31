package pierre.valentin.imt.ne.archedenoe.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "animaux")
public class Animaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "nb_patte", nullable = false)
    private int nbPatte;

    @Column(name = "place", nullable = false)
    private int place;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getNbPatte() {
        return nbPatte;
    }

    public void setNbPatte(int nbPatte) {
        this.nbPatte = nbPatte;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
