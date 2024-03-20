package mx.com.santander.hexagonalmodularmaven.user.command;

import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import mx.com.santander.hexagonalmodularmaven.user.service.UserCreateService;
import mx.com.santander.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler {

    private final UserCreateService userCreateService;
    private final UserDtoMapper userDtoMapper;
    public UserCreateHandler(UserCreateService userCreateService, UserDtoMapper userDtoMapper) {
        this.userCreateService = userCreateService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(UserCreateCommand userCreateCommand) {
        return userDtoMapper
                .toDto(userCreateService.execute(userCreateCommand));
    }

}
