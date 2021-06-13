package be.thomasmore.appartementverhuur.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Boeking {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boeking_generator")
    @SequenceGenerator(name = "boeking_generator", sequenceName = "boeking_seq", allocationSize = 1)
    @Id
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDatum;
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eindDatum;
    @ManyToOne(fetch = FetchType.LAZY)
    private Appartement appartement;
    @Min(value = 1)
    @Max(value = 366)
    private Integer numDays = 1;
    @Min(value = 1)
    private Integer numGuests = 1;





    public Boeking() {
    }

    public Boeking(Integer id, Date startDatum, Date eindDatum, Appartement appartement, Integer numDays, Integer numGuests) {
        this.id = id;
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
        this.appartement = appartement;
        this.numDays = numDays;
        this.numGuests = numGuests;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }

    public Integer getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(Integer numGuests) {
        this.numGuests = numGuests;
    }


}
