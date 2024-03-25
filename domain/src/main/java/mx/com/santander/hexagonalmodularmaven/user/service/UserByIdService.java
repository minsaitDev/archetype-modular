package mx.com.santander.hexagonalmodularmaven.user.service;


import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;

public class UserByIdService {
    private final UserDao userDao;

    public UserByIdService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User execute(Long id){
        return userDao.getById(id);
    }

}
