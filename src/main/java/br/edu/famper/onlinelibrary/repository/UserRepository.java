package br.edu.famper.onlinelibrary.repository;

import br.edu.famper.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
