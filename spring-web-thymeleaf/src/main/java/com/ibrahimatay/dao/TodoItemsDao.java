package com.ibrahimatay.dao;

import com.ibrahimatay.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemsDao extends CrudRepository<TodoItem, Integer> {
}
