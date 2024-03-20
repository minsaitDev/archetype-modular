package mx.com.santander.hexagonalmodularmaven.user.service;

import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;


public class UserDeleteService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserDeleteService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        var user = userDao.getById(id);
        userRepository.deleteById(user.getId());
    }

}
