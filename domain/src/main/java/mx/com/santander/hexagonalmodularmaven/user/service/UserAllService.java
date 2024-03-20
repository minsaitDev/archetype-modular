package mx.com.santander.hexagonalmodularmaven.user.service;

import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;

import java.util.List;

public class UserAllService {
    private final UserDao userDao;

    public UserAllService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> execute(){
        return userDao.getAll();
    }

}
