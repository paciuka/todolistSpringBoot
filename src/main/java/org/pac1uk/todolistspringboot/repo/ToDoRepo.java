package org.pac1uk.todolistspringboot.repo;

import org.pac1uk.todolistspringboot.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoRepo extends JpaRepository<TodoItem, Long> {

    List<TodoItem> findByDone(Boolean done);

}