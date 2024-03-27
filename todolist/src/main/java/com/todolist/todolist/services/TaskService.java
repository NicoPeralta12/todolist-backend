package com.todolist.todolist.services;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository repository;

    @Override
    public void createTask(Task task) {
        repository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Task getTaskByName(String name) {
        Task tsk = null;

        for (Task task: this.getTasks()){
            if(task.getName().equalsIgnoreCase(name)){
                tsk=task;
            }
        }

        return tsk;
    }

    @Override
    public void editTask(Long id, Task task) {
        for(Task tsk: this.getTasks()){
            if(tsk.getId().equals(id)){
                tsk=task;
                repository.save(tsk);
            }
        }
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
