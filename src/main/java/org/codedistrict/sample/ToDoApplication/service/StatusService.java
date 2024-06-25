package org.codedistrict.sample.ToDoApplication.service;

import org.codedistrict.sample.ToDoApplication.entity.Status;
import org.codedistrict.sample.ToDoApplication.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    Logger logger = LoggerFactory.getLogger(ToDoItemService.class);

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatus() {
        logger.info("Displaying All Status");
        return statusRepository.findAll();
    }
    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status updatedStatus) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Status ID"));

        // Update fields
        status.setName(updatedStatus.getName());

        // Save updated status
        return statusRepository.save(status);
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
