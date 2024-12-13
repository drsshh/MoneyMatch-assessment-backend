package com.MoneyMatch.service;

import com.MoneyMatch.dto.response.GetTaskResponseDTO;
import com.MoneyMatch.dto.response.ResponseDTO;
import com.MoneyMatch.entity.Task;
import com.MoneyMatch.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public GetTaskResponseDTO getTasks(String value) {
        GetTaskResponseDTO getTaskResponseDTO = new GetTaskResponseDTO();

        try {
            switch (value) {
                case "All":
                    getTaskResponseDTO.setTasks(taskRepository.findTasksNotRemoved());
                    break;

                case "F":
                    getTaskResponseDTO.setTasks(taskRepository.findTasksProgressFinish());
                    break;

                case "D":
                    getTaskResponseDTO.setTasks(taskRepository.findTasksProgressNotDone());
                    break;

                case "R":
                    getTaskResponseDTO.setTasks(taskRepository.findTasksRemoved());
                    break;

                default:
                    getTaskResponseDTO.setTasks(taskRepository.findTasksProgressNotDone());
                    break;
            }
            getTaskResponseDTO.setErrorCode("0");
            getTaskResponseDTO.setErrorDescr("Successful.");

        } catch (Exception e) {
            getTaskResponseDTO.setTasks(null);
            getTaskResponseDTO.setErrorCode("1");
            getTaskResponseDTO.setErrorDescr(e.getMessage());
        }

        return getTaskResponseDTO;
    }

    @Override
    public ResponseDTO createTask(Task task) {
        ResponseDTO response = new ResponseDTO();

        try {
            String todayDateFormat = new SimpleDateFormat("yyMMdd").format(new Date());

            List<Task> todaysTasks = taskRepository.findByIdStartingWith(todayDateFormat + "-");
            int maxSuffix = todaysTasks.isEmpty() ? 0 :
                    todaysTasks.stream()
                            .map(t -> extractSuffix(t.getId()))
                            .max(Integer::compare)
                            .orElse(0);

            String newTaskId = String.format("%s-%03d", todayDateFormat, maxSuffix + 1);
            task.setId(newTaskId);
            task.setDescription(task.getDescription());
            taskRepository.save(task);

            response.setErrorCode("0");
            response.setErrorDescr("Successful.");
        } catch (Exception e) {
            response.setErrorCode("1");
            response.setErrorDescr(e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseDTO updateTask(Task updatedTask) {
        ResponseDTO response = new ResponseDTO();
        try {
            Task task = taskRepository.findById(updatedTask.getId());
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setProgress(updatedTask.getProgress());
            taskRepository.save(task);

            response.setErrorCode("0");
            response.setErrorDescr("Successful.");
        } catch (Exception e) {
            response.setErrorCode("1");
            response.setErrorDescr(e.getMessage());
        }

        return response;
    }

    @Override
    public ResponseDTO deleteTask(String id) {
        ResponseDTO response = new ResponseDTO();

        try {
            Task task = taskRepository.findById(id);
            task.setProgress('R');

            taskRepository.save(task);

            response.setErrorCode("0");
            response.setErrorDescr("Successful.");
        } catch (Exception e) {
            response.setErrorCode("1");
            response.setErrorDescr(e.getMessage());
        }

        return response;
    }

    @Override
    public ResponseDTO deleteAllTasks(){
        ResponseDTO response = new ResponseDTO();
        try {
            taskRepository.deleteAll();

            response.setErrorCode("0");
            response.setErrorDescr("Successful.");
        } catch (Exception e) {
            response.setErrorCode("1");
            response.setErrorDescr(e.getMessage());
        }
        return response;
    }

    private int extractSuffix(String id) {
        if (id == null || !id.contains("-")) {
            return 0;
        }
        try {
            return Integer.parseInt(id.split("-")[1]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
