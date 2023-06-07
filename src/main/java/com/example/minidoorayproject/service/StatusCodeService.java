package com.example.minidoorayproject.service;

import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.StatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusCodeService {
    private final StatusCodeRepository statusCodeRepository;

    @Autowired
    public StatusCodeService(StatusCodeRepository statusCodeRepository) {
        this.statusCodeRepository = statusCodeRepository;
    }

    public StatusCode createStatusCode(StatusCode statusCode) {
        return statusCodeRepository.save(statusCode);
    }

    public StatusCode getStatusCode(int id) {
        return statusCodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StatusCode", "id", id));
    }

    public StatusCode updateStatusCode(int id, StatusCode updatedStatusCode) {
        return statusCodeRepository.findById(id)
                .map(statusCode -> {
                    statusCode.setCodeName(updatedStatusCode.getCodeName());
                    return statusCodeRepository.save(statusCode);
                })
                .orElseThrow(() -> new ResourceNotFoundException("StatusCode", "id", id));
    }

    public void deleteStatusCode(int id) {
        if (statusCodeRepository.existsById(id)) {
            statusCodeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("StatusCode", "id", id);
        }
    }
}
