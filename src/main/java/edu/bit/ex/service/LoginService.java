package edu.bit.ex.service;

import javax.inject.Inject; 

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class LoginService {

    @Inject
    private UserMapper userMapper;
    // @Autowired = @Inject

    public UserVO selectUser(UserVO userVO) throws Exception {
        log.info("selectUser ..");
        return userMapper.getUser(userVO);
    }
}