package mx.com.santander.hexagonalmodularmaven.task.service;

import mx.com.santander.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.task.model.exception.TaskException;
import mx.com.santander.hexagonalmodularmaven.task.port.repository.TaskRepository;

public class TaskCreateService {

    private final TaskRepository taskRepository;
    private final TaskSuperComplexService taskSuperComplexService;
    public TaskCreateService(TaskRepository taskRepository, TaskSuperComplexService taskSuperComplexService) {
        this.taskRepository = taskRepository;
        this.taskSuperComplexService = taskSuperComplexService;
    }

    public Task execute(TaskCreateCommand createCommand){

        var calculatedTime = taskSuperComplexService.execute();

        if(calculatedTime > createCommand.getTimeRequiredToComplete()){
            throw new TaskException("Super complex exception");
        }

        var taskToCreate = new Task()
                .requestToCreate(createCommand);
        return taskRepository.create(taskToCreate);
    }

}
