package com.example.complaint.service;

import com.example.complaint.dto.complaint.ComplaintCreateRequest;
import com.example.complaint.entity.Complaint;
import com.example.complaint.entity.ComplaintStatus;

import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(ComplaintCreateRequest request, String userEmail);

    List<Complaint> getUserComplaints(String userEmail);

    Complaint updateStatus(Long complaintId, ComplaintStatus status, String userEmail);
}
