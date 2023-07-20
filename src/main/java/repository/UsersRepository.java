package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
}
