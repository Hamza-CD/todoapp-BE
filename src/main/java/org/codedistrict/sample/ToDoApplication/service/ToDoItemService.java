package org.codedistrict.sample.ToDoApplication.service;

import org.codedistrict.sample.ToDoApplication.entity.Status;
import org.codedistrict.sample.ToDoApplication.entity.ToDoItem;
import org.codedistrict.sample.ToDoApplication.entity.User;
import org.codedistrict.sample.ToDoApplication.repository.StatusRepository;
import org.codedistrict.sample.ToDoApplication.repository.ToDoItemRepository;
import org.codedistrict.sample.ToDoApplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    Logger logger = LoggerFactory.getLogger(ToDoItemService.class);

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    public List<ToDoItem> getAllToDoItems() {
        logger.info("Displaying All To Do Items");
        return toDoItemRepository.findAll();
    }

    public ToDoItem createToDoItem(Long userId, Long statusId, ToDoItem toDoItem) {
        logger.info("Creating new ToDoItem for user ID {} with status ID {}", userId, statusId);

        // Find user by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        // Find or create Status by ID
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));

        logger.info("Status retrieved: {}", status);

        // Associate ToDoItem with user and status
        toDoItem.setUser(user);
        toDoItem.setStatus(status);

        // Save ToDoItem
        try {
            ToDoItem savedItem = toDoItemRepository.save(toDoItem);
            logger.info("ToDoItem saved successfully with ID {}", savedItem.getId());
            return savedItem;
        } catch (Exception e) {
            logger.error("Error saving ToDoItem: {}", e.getMessage());
            throw e; // Rethrow the exception or handle it as per your application's error handling strategy
        }
    }


    public ToDoItem updateToDoItem(Long id, Long statusId, ToDoItem updatedToDoItem) {
        ToDoItem toDoItem = toDoItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ToDoItem ID"));

        // Find status by ID
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));

        // Update fields
        toDoItem.setTitle(updatedToDoItem.getTitle());
        toDoItem.setDescription(updatedToDoItem.getDescription());
        toDoItem.setStatus(status);

        // Save updated ToDoItem
        return toDoItemRepository.save(toDoItem);
    }

    public void deleteToDoItem(Long id) {
        if (!toDoItemRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid ToDoItem ID");
        }
        toDoItemRepository.deleteById(id);
    }
}
