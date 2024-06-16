package org.codedistrict.sample.ToDoApplication.repository;


import org.codedistrict.sample.ToDoApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
