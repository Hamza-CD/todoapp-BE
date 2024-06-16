package org.codedistrict.sample.ToDoApplication.controller;

import org.codedistrict.sample.ToDoApplication.entity.ToDoItem;
import org.codedistrict.sample.ToDoApplication.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo_application/todoitems")
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;

    @GetMapping
    public List<ToDoItem> getAllToDoItems() {
        return toDoItemService.getAllToDoItems();
    }

    @PostMapping("/{userId}")
    public ToDoItem createToDoItem(@PathVariable Long userId, @RequestBody ToDoItem toDoItem) {
        return toDoItemService.createToDoItem(userId, toDoItem);
    }

    @PutMapping("/{id}")
    public ToDoItem updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem updatedToDoItem) {
        return toDoItemService.updateToDoItem(id, updatedToDoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable Long id) {
        toDoItemService.deleteToDoItem(id);
    }
}
