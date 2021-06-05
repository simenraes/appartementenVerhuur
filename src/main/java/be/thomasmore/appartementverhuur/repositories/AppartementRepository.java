package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppartementRepository extends CrudRepository<Appartement, Integer> {
    List<Appartement> findAllBy();
}
