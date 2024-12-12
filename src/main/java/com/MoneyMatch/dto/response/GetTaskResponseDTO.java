package com.MoneyMatch.dto.response;

import com.MoneyMatch.entity.Task;

import java.util.List;

public class GetTaskResponseDTO extends ResponseDTO {
    List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
