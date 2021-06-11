package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.EmpVO;
import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;

@Mapper
public interface EmpMapper {
    public EmpVO getEmp(String ename);
    //ename = ID
}