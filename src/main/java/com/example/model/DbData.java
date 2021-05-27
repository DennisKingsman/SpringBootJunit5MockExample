package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Db_Data")
public class DbData {

    @Id
    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "dataset")
    private String data;

    public DbData() {
    }

    public DbData(long dataId) {
        this.dataId = dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DbData{" +
                "dataId=" + dataId +
                ", data='" + data + '\'' +
                '}';
    }

}
