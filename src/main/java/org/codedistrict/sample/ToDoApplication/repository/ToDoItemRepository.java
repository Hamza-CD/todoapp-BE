package org.codedistrict.sample.ToDoApplication.repository;

import org.codedistrict.sample.ToDoApplication.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
