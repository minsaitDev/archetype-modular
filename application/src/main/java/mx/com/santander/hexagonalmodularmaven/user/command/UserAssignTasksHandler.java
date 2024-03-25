package mx.com.santander.hexagonalmodularmaven.user.command;

import mx.com.santander.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.service.UserAssignTasksService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserAssignTasksHandler {

    private final UserAssignTasksService userAssignTasksService;
    private final UserDtoMapper userDtoMapper;

    public UserAssignTasksHandler(UserAssignTasksService userAssignTasksService, UserDtoMapper userDtoMapper) {
        this.userAssignTasksService = userAssignTasksService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(Long id, List<Long> tasksIds){
        return userDtoMapper
                .toDto(userAssignTasksService.execute(id, tasksIds));
    }

}
