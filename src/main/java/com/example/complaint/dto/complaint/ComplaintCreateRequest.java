package com.example.complaint.dto.complaint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComplaintCreateRequest {

    private String title;
    private String description;
}
