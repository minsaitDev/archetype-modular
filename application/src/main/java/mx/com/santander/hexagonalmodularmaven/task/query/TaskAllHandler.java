package mx.com.santander.hexagonalmodularmaven.task.query;


import mx.com.santander.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TaskAllHandler {

    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;

    public TaskAllHandler(TaskDao taskDao, TaskDtoMapper taskDtoMapper) {
        this.taskDao = taskDao;
        this.taskDtoMapper = taskDtoMapper;
    }

    public List<TaskDto> execute(){
        return taskDao.getAll()
                .stream()
                .map(taskDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
