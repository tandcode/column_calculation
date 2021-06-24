package ua.com.dbncalc.steel.repositories;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dbncalc.steel.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(@NotNull String username);

}
