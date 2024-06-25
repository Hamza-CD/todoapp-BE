package org.codedistrict.sample.ToDoApplication.repository;

import org.codedistrict.sample.ToDoApplication.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByName(String name);
}
