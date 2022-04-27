package com.ibrahimatay.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "TODO_ITEM")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
}
