package com.ibrahimatay.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
}
