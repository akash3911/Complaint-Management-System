package com.example.complaint.service;

import com.example.complaint.dto.complaint.ComplaintCreateRequest;
import com.example.complaint.entity.Complaint;
import com.example.complaint.entity.ComplaintStatus;
import com.example.complaint.entity.User;
import com.example.complaint.repository.ComplaintRepository;
import com.example.complaint.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                UserRepository userRepository) {
        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Complaint createComplaint(ComplaintCreateRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setUser(user);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getUserComplaints(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return complaintRepository.findByUserId(user.getId());
    }

    @Override
    public Complaint updateStatus(Long complaintId, ComplaintStatus status, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Complaint complaint = complaintRepository.findByIdAndUserId(complaintId, user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Complaint not found"));

        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}
