package io.cutita.base.auth.dao.service.impl;

import io.cutita.base.auth.dao.entity.User;
import io.cutita.base.auth.dao.mapper.UserMapper;
import io.cutita.base.auth.dao.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cubita
 * @since 2020-01-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
