package edu.bit.ex.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //회원가입 폼
    @GetMapping("/user/userForm")
    public void userForm() {
       log.info("userForm()..");
    }
   

    @PostMapping("/user/addUser")
    public String addUser(UserVO userVO) {

       log.info("user/addUser");
       userService.addUser(userVO);
       
       return "redirect:/";
    }
    
	
}
