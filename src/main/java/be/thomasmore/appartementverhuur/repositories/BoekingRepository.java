package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.Appartement;
import be.thomasmore.appartementverhuur.model.Boeking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BoekingRepository extends CrudRepository <Boeking, Integer> {
Iterable<Boeking> findByAppartement(Appartement appartement);
    List<Boeking> findByIdEquals(Integer id);
List<Boeking> findAllBy();
//    @Query("select a from Appartement a " +
//            "where a.capacity >= :numGuests and " +
//            "not exists (select b from a.boekingen b " +
//            " where :startDay < b.eindDatum and :endDay > b.startDatum) " +
//            "order by a.capacity")
//    List<Appartement> getFreeAppartementen(@Param("numGuests") Integer numGuests,
//                                        @Param("startDatum") LocalDate startDatum,
//                                        @Param("eindDatum") LocalDate eindDatum);
}
