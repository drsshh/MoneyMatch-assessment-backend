package com.MoneyMatch.controller;

import com.MoneyMatch.dto.request.GetTaskRequestDTO;
import com.MoneyMatch.dto.response.GetTaskResponseDTO;
import com.MoneyMatch.dto.response.ResponseDTO;
import com.MoneyMatch.entity.Task;
import com.MoneyMatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping(path = "/gettasks")
    public GetTaskResponseDTO getTasks(@RequestBody GetTaskRequestDTO getTaskRequestDTO) {
        GetTaskResponseDTO getTaskResponseDTO;
        getTaskResponseDTO = taskService.getTasks(getTaskRequestDTO.getValue());

        return getTaskResponseDTO;
    }

    @PostMapping(path = "/createtask")
    public ResponseDTO createTask(@RequestBody Task task) {
         ResponseDTO responseDTO;
         responseDTO = taskService.createTask(task);

         return responseDTO;
    }

    @PostMapping(path = "/updatetask")
    public ResponseDTO updateTask(@RequestBody Task updatedTask){
        ResponseDTO responseDTO;

        responseDTO = taskService.updateTask(updatedTask);

        return responseDTO;
    }

    @PostMapping(path = "/deletetask")
    public ResponseDTO deleteTask(@RequestBody Task taskToDelete) {
        ResponseDTO responseDTO;

        responseDTO = taskService.deleteTask(taskToDelete.getId());

        return responseDTO;
    }

    @PostMapping(path = "/deletealltasks")
    public ResponseDTO deleteAllTasks() {
        ResponseDTO responseDTO;

        responseDTO = taskService.deleteAllTasks();

        return responseDTO;
    }
}
