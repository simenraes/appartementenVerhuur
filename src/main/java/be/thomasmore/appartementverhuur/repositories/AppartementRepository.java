package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppartementRepository extends CrudRepository<Appartement, Integer> {

    //List<Appartement>  findByCapacityGreaterThanEqual(@Param("minCapacity")Integer minCapacity);
    List<Appartement> findAllBy();

    //List<Appartement> findByCapacityGreaterThanEqual(Integer minCapacity);
    List<Appartement> findByCapacityGreaterThan(int minCapacity);

//    List<Appartement> findByCapacityBetween(int minCapacity, int maxCapacity);

    List<Appartement> findByStadContainingIgnoreCase(String keyword);

    Optional<Appartement> findById(Integer id);
    @Query("SELECT a FROM Appartement a WHERE " +
            "(:min IS NULL OR :min <= a.capacity) AND " +
            "(:max IS NULL OR a.capacity <= :max) AND " +
            "(:maxAfstandTotCentrum IS NULL OR a.afstandTotCentrum <= :maxAfstandTotCentrum) AND " +
            "(:huisdierenToegelaten IS NULL OR a.huisdierenToegelaten = :huisdierenToegelaten)")
    List<Appartement> findByFilter(@Param("min") Integer min,
                                   @Param("max") Integer max,
                                   @Param("maxAfstandTotCentrum") Integer maxAfstandTotCentrum,
                                   @Param("huisdierenToegelaten") Boolean huisdierenToegelaten);


//    Iterable<Appartement> findByHuisdierenToegelaten(boolean huisdierenToegelaten);

//    List<Appartement> findByFilter(@Param("minCapacity") Integer minCapacity,
//                                   @Param("maxCapacity") Integer maxCapacity);
}
