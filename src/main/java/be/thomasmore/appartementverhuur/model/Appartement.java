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
    private String stad;
    private boolean isParkingBeschikbaar;
    private int afstandTotCentrum;
    private String extraInfo;
    private int prijsPerMaand;


    public Appartement() {
    }

    public Appartement(Integer id, int capacity, String appartementNaam, String stad, boolean isParkingBeschikbaar, int afstandTotCentrum, String extraInfo, int prijsPerMaand) {
        this.id = id;
        this.capacity = capacity;
        this.appartementNaam = appartementNaam;
        this.stad = stad;
        this.isParkingBeschikbaar = isParkingBeschikbaar;
        this.afstandTotCentrum = afstandTotCentrum;
        this.extraInfo = extraInfo;
        this.prijsPerMaand = prijsPerMaand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAppartementNaam() {
        return appartementNaam;
    }

    public void setAppartementNaam(String appartementNaam) {
        this.appartementNaam = appartementNaam;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public boolean isIsParkingBeschikbaar() {
        return isParkingBeschikbaar;
    }

    public void setIsParkingBeschikbaar(boolean isparkingBeschikbaar) {
        this.isParkingBeschikbaar = isparkingBeschikbaar;
    }

    public int getAfstandTotCentrum() {
        return afstandTotCentrum;
    }

    public void setAfstandTotCentrum(int afstandTotCentrum) {
        this.afstandTotCentrum = afstandTotCentrum;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public boolean isParkingBeschikbaar() {
        return isParkingBeschikbaar;
    }

    public void setParkingBeschikbaar(boolean parkingBeschikbaar) {
        isParkingBeschikbaar = parkingBeschikbaar;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public int getPrijsPerMaand() {
        return prijsPerMaand;
    }

    public void setPrijsPerMaand(int prijsPerMaand) {
        this.prijsPerMaand = prijsPerMaand;
    }
}

