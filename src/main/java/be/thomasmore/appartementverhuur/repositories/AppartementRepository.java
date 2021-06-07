package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppartementRepository extends CrudRepository<Appartement, Integer> {

//List<Appartement>  findByCapacityGreaterThanEqual(@Param("minCapacity")Integer minCapacity);
List<Appartement> findAllBy();
//List<Appartement> findByCapacityGreaterThanEqual(Integer minCapacity);
    Iterable<Appartement> findByCapacityGreaterThan(Integer minCapacity);

    Optional<Appartement> findById(Integer id);

    Iterable<Appartement> findByHuisdierenToegelaten(boolean huisdierenToegelaten);

//    List<Appartement> findByFilter(@Param("minCapacity") Integer minCapacity,
//                                   @Param("maxCapacity") Integer maxCapacity);
}
