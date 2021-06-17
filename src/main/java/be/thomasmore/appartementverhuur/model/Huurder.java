package be.thomasmore.appartementverhuur.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Huurder {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "huurder_generator")
    @SequenceGenerator(name = "huurder_generator", sequenceName = "huurder_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String naam;
    private String geslacht;
    private String telefoonNummer;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Boeking> boekingen;


    public Huurder() {
    }

    public Huurder(Integer id, String naam, String geslacht, String telefoonNummer, User user, Collection<Boeking> boekingen) {
        this.id = id;
        this.naam = naam;
        this.geslacht = geslacht;
        this.telefoonNummer = telefoonNummer;

        this.user = user;
        this.boekingen = boekingen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public Collection<Boeking> getBoekingen() {
        return boekingen;
    }

    public void setBoekingen(Collection<Boeking> boekingen) {
        this.boekingen = boekingen;
    }
}
