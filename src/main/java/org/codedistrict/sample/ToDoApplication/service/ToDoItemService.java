package org.codedistrict.sample.ToDoApplication.service;

import org.codedistrict.sample.ToDoApplication.entity.ToDoItem;
import org.codedistrict.sample.ToDoApplication.repository.ToDoItemRepository;
import org.codedistrict.sample.ToDoApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ToDoItem> getAllToDoItems() {
        return toDoItemRepository.findAll();
    }

    public ToDoItem createToDoItem(Long userId, ToDoItem toDoItem) {
        // Find user by ID
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        // Associate ToDoItem with user
        toDoItem.setUser(userRepository.getOne(userId));

        // Save ToDoItem
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItem updateToDoItem(Long id, ToDoItem updatedToDoItem) {
        ToDoItem toDoItem = toDoItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ToDoItem ID"));

        // Update fields
        toDoItem.setTitle(updatedToDoItem.getTitle());
        toDoItem.setDescription(updatedToDoItem.getDescription());
        toDoItem.setCompleted(updatedToDoItem.isCompleted());

        // Save updated ToDoItem
        return toDoItemRepository.save(toDoItem);
    }

    public void deleteToDoItem(Long id) {
        toDoItemRepository.deleteById(id);
    }
}