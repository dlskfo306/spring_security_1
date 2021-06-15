package edu.bit.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

/*
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)   
 */
//ENAME, SAL. HIREDATE

@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpVO {

    private String empno;
    private String ename;
    private String job;
    private Timestamp hiredate;
    private int sal;
    private int comm;
    private int deptno;
    /* String authority; */


    // DB에 있는 것을 객체로 가져옴
    /*
     * public String authority() {
     * 
     * return "ROLE_ADMIN"; }
     */
    
    public String getAuthority() {
        if(getJob().toUpperCase().contains("MANAGER"))
            return "ROLE_ADMIN";
         else
            return "ROLE_USER";
    }
}