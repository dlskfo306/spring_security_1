package edu.bit.ex.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.LoginService;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class LogInController {

    @Autowired
    private LoginService loginService;

    // 로그인
    // 시큐리티 안쓸 때 로그인하던 방식 
    @PostMapping("/login")
    public String login(UserVO userVO, HttpServletRequest request) throws Exception {

        log.info("post login");
        log.info(userVO);

        // Session 처리를 위한 Session 객체 HttpServletRequest 안에 있음
        HttpSession session = request.getSession();

        UserVO user = loginService.selectUser(userVO);

        log.info(user);

        if (user == null) {
            session.setAttribute("user", null);
        } else {
            session.setAttribute("user", user);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {

        log.info("logout..");

        // Session 처리를 위한 Session 객체 HttpServletRequest 안에 있음
        HttpSession session = request.getSession();
        session.invalidate(); //session 날리기

        return "redirect:/";
    }

}
