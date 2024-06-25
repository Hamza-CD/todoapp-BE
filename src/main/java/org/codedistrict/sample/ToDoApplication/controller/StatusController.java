package org.codedistrict.sample.ToDoApplication.controller;

import org.codedistrict.sample.ToDoApplication.entity.Status;
import org.codedistrict.sample.ToDoApplication.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo_application/status")
public class StatusController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatus() {
        logger.info("Get all status values");
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusService.createStatus(status);
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable Long id, @RequestBody Status updatedStatus) {
        return statusService.updateStatus(id, updatedStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}
