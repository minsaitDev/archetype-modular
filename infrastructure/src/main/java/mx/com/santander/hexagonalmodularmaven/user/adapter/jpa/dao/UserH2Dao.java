package mx.com.santander.hexagonalmodularmaven.user.adapter.jpa.dao;

import mx.com.santander.hexagonalmodularmaven.user.adapter.jpa.UserSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.user.adapter.mapper.UserDboMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.constant.UserConstant;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.model.exception.UserException;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class UserH2Dao implements UserDao {

    private final UserSpringJpaAdapterRepository userSpringJpaAdapterRepository;
    private final UserDboMapper userDboMapper;

    public UserH2Dao(UserSpringJpaAdapterRepository userSpringJpaAdapterRepository, UserDboMapper userDboMapper) {
        this.userSpringJpaAdapterRepository = userSpringJpaAdapterRepository;
        this.userDboMapper = userDboMapper;
    }

    @Override
    public User getById(Long id) {

        var optionalUser = userSpringJpaAdapterRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new UserException(
                    String.format(UserConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }

        return userDboMapper.toDomain(optionalUser.get());
    }

    @Override
    public List<User> getAll() {
        return userSpringJpaAdapterRepository.findAll()
                .stream()
                .map(userDboMapper::toDomain)
                .collect(Collectors.toList());
    }

}
