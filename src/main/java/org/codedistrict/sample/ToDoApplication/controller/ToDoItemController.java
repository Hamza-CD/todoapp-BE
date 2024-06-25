package org.codedistrict.sample.ToDoApplication.controller;

import org.codedistrict.sample.ToDoApplication.entity.ToDoItem;
import org.codedistrict.sample.ToDoApplication.service.ToDoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo_application/todoitems")
public class ToDoItemController {

    Logger logger = LoggerFactory.getLogger(ToDoItemController.class);

    @Autowired
    private ToDoItemService toDoItemService;

    @GetMapping
    public List<ToDoItem> getAllToDoItems() {
        return toDoItemService.getAllToDoItems();
    }

    @PostMapping("/{userId}/{statusId}")
    public ToDoItem createToDoItem(@PathVariable Long userId, @PathVariable Long statusId, @RequestBody ToDoItem toDoItem) {
        logger.info("Request received to create new toDoItem with userId: {} and statusId: {}", userId, statusId);
        return toDoItemService.createToDoItem(userId, statusId, toDoItem);
    }

    @PutMapping("/{id}/{statusId}")
    public ToDoItem updateToDoItem(@PathVariable Long id, @PathVariable Long statusId, @RequestBody ToDoItem updatedToDoItem) {
        logger.info("Request received to update toDoItem with id: {} and statusId: {}", id, statusId);
        return toDoItemService.updateToDoItem(id, statusId, updatedToDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable Long id) {
        logger.info("Request received to delete toDoItem with id: {}", id);
        toDoItemService.deleteToDoItem(id);
    }
}
