package be.thomasmore.appartementverhuur.repositories;

import be.thomasmore.appartementverhuur.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}