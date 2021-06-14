package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Huurder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HuurderRepository extends CrudRepository <Huurder, Integer> {
    Optional<Huurder> findByUserUsername(String username);

}
