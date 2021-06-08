package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Boeking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoekingRepository extends CrudRepository <Boeking, Integer> {
List<Boeking> findAllBy();
}
