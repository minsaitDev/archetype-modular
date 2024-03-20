package mx.com.santander.hexagonalmodularmaven.task.query;


import mx.com.santander.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

@Component
public class TaskByIdHandler {
    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;

    public TaskByIdHandler(TaskDao taskDao, TaskDtoMapper taskDtoMapper) {
        this.taskDao = taskDao;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto execute(Long id){
        return taskDtoMapper.toDto(taskDao.getById(id));
    }

}
