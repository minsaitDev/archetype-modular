package mx.com.santander.hexagonalmodularmaven.user.service;

import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;

public class UserCreateService {

    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserCreateCommand userCreateCommand){

        var userToCreate = new User()
                .requestToCreate(userCreateCommand);

        return userRepository.create(userToCreate);

    }

}
