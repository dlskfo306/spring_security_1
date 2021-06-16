package edu.bit.ex.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class TxService {

    @Inject
    private UserMapper userMapper;
    // @Autowired = @Inject

    // 정상동작
    public void txTest1() {
        log.info("transactionTest1()..테스트");

        // 두 개 순서 바꾸면 에러남
        // 1(Users):N(Authorities)관계기 때문에 N부터 지우고 1을 지워야 함.
        // 1부터 지우면 부모가 사라지는거기 때문에 자식먼저 날려버려야 함.
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(user);

    }

    public void txTest2() {
        log.info("transactionTest2()..테스트");

        // 두 개 순서 바꾸면 에러남
        // 1(Users):N(Authorities)관계기 때문에 N부터 지우고 1을 지워야 함.
        // 1부터 지우면 부모가 사라지는거기 때문에 자식먼저 날려버려야 함.
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);

    }

    @Transactional
    public void txTest3() {
        log.info("transactionTest3()..테스트");

        // 두 개 순서 바꾸면 에러남
        // 1(Users):N(Authorities)관계기 때문에 N부터 지우고 1을 지워야 함.
        // 1부터 지우면 부모가 사라지는거기 때문에 자식먼저 날려버려야 함.
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);

    }

    // uncheckedExeption(롤백 함)
    @Transactional
    public void txTest4() {

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        throw new RuntimeException("RuntimeException for rollback");
        // 일부러 에러나게 함
    }

    // CheckedExeption 테스트(롤백 안함)
    @Transactional
    public void txTest5() throws SQLException {

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        throw new SQLException("SQLException for rollback");
    }

    /*
     * public void txTest5() { try { userMapper.deleteAuthorities();
     * userMapper.deleteUsers();
     * 
     * throw new SQLException("SQLException for rollback"); } catch (Exception e) {
     * //개발자가 기본적으로 에러처리에 대한 코딩을 한다는 의미 } }
     */

    
    // @Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함
    @Transactional(rollbackFor = SQLException.class)
    public void txTest6() throws SQLException {

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        throw new SQLException("SQLException for rollback");
    }
    
    
    //@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
    // Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor = Exception.class) 
    // 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
    @Transactional(rollbackFor = Exception.class)    
    public void txTest7() throws SQLException {
       userMapper.deleteAuthorities();
       userMapper.deleteUsers();

       throw new SQLException("SQLException for rollback");
    }
}