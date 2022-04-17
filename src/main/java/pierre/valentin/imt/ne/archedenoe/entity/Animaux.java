package pierre.valentin.imt.ne.archedenoe.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "animaux")
public class Animaux {
    public Animaux() {
        super();
    }

    public Animaux(String race, Long nbPatte, int place, Arche arche) {
        super();
        this.race = race;
        this.nbPatte = nbPatte;
        this.place = place;
        this.arche = arche;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "race")
    private String race;

    @Column(name = "nbPatte")
    private Long nbPatte;

    @Column(name = "place")
    private int place;

    @ManyToOne
    private Arche arche;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long getNbPatte() {
        return nbPatte;
    }

    public void setNbPatte(Long nbPatte) {
        this.nbPatte = nbPatte;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Arche getArche() {
        return arche;
    }

    public void setArche(Arche arche) {
        this.arche = arche;
    }
}
