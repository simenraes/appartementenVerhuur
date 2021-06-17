package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppartementRepository extends CrudRepository<Appartement, Integer> {

    Optional<Appartement> findById(Integer id);

    @Query("SELECT a FROM Appartement a WHERE " +
            "(:min IS NULL OR :min <= a.capacity) AND " +
            "(:max IS NULL OR a.capacity <= :max) AND " +
            "(:maxAfstandTotCentrum IS NULL OR a.afstandTotCentrum <= :maxAfstandTotCentrum) AND " +
            "(:huisdierenToegelaten IS NULL OR a.huisdierenToegelaten = :huisdierenToegelaten) AND " +
            "(:stad IS NULL OR UPPER(a.stad) LIKE UPPER(CONCAT('%', :stad, '%')))")
    List<Appartement> findByFilter(@Param("min") Integer min,
                                   @Param("max") Integer max,
                                   @Param("maxAfstandTotCentrum") Integer maxAfstandTotCentrum,
                                   @Param("huisdierenToegelaten") Boolean huisdierenToegelaten,
                                   @Param("stad") String stad);


}
