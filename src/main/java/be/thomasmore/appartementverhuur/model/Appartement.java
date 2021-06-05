package be.thomasmore.appartementverhuur.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appartement {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int capacity;
    private String appartementNaam;


    public Appartement() {
    }

    public Appartement(Integer id, String appartementNaam, int capacity) {
        this.id = id;
        this.appartementNaam = appartementNaam;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppartementNaam() {
        return appartementNaam;
    }

    public void setAppartementNaam(String name) {
        this.appartementNaam = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
