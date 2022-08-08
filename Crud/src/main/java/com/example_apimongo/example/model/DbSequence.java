package com.example_apimongo.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class DbSequence {
    @Id
    private String id;
    private int seq;

}
