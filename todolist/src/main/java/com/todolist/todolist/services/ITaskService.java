package com.todolist.todolist.services;

import com.todolist.todolist.models.Task;

import java.util.List;

public interface ITaskService {

    public void createTask(Task task);

    public List<Task> getTasks();

    public Task getTaskById(Long id);

    public Task getTaskByName(String name);

    public void editTask(Long id, Task task);

    public void deleteTask(Long id);




}
