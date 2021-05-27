package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Db_Data")
public class DbData {

    @Id
    @GeneratedValue
    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "dataset")
    private String data;

    public DbData() {
    }

    public DbData(long testId, String dataset) {
        dataId = testId;
        data = dataset;
    }

}
