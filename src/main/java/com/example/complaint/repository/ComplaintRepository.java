package com.example.complaint.repository;

import com.example.complaint.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByUserId(Long userId);

    Optional<Complaint> findByIdAndUserId(Long id, Long userId);
}
