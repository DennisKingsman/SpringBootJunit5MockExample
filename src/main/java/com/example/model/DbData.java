package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DbData {

    @Id
    @GeneratedValue
    private Long dataId;
    private String data;

}
