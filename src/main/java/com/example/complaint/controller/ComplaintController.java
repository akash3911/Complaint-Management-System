package com.example.complaint.controller;

import com.example.complaint.dto.complaint.ComplaintCreateRequest;
import com.example.complaint.entity.Complaint;
import com.example.complaint.entity.ComplaintStatus;
import com.example.complaint.service.ComplaintService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public Complaint createComplaint(@RequestBody ComplaintCreateRequest request, Authentication authentication) {
        return complaintService.createComplaint(request, authentication.getName());
    }

    @GetMapping
    public List<Complaint> getMyComplaints(Authentication authentication) {
        return complaintService.getUserComplaints(authentication.getName());
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id,
                                  @RequestParam ComplaintStatus status,
                                  Authentication authentication) {
        return complaintService.updateStatus(id, status, authentication.getName());
    }
}
