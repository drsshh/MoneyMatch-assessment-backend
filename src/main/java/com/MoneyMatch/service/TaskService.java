package com.MoneyMatch.service;

import com.MoneyMatch.dto.response.GetTaskResponseDTO;
import com.MoneyMatch.dto.response.ResponseDTO;
import com.MoneyMatch.entity.Task;

public interface TaskService {
    GetTaskResponseDTO getTasks(String value);

    ResponseDTO createTask(Task task);
    ResponseDTO updateTask(Task updatedTask);
    ResponseDTO deleteTask(String id);

    ResponseDTO deleteAllTasks();
}
