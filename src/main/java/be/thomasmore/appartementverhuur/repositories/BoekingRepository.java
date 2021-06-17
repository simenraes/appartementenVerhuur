package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.model.Boeking;
import org.springframework.data.repository.CrudRepository;

public interface BoekingRepository extends CrudRepository <Boeking, Integer> {
Iterable<Boeking> findByAppartement(Appartement appartement);


}
