package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.EmpVO;
import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;

@Mapper
public interface EmpMapper {
    
        //.xml 대신 여기다 붙여쓰기
    @Select("select * from emp where ename = #{ename}")
    public EmpVO getEmp(String ename);
    //ename = ID
}