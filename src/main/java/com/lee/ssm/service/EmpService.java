package com.lee.ssm.service;

import com.lee.ssm.dao.EmpMapper;
import com.lee.ssm.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lee
 * @version 2022/4/19 11:52
 * @since JDK8
 */


@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public List<Emp> findAllEmp(){
       return empMapper.selectByExampleWithDept(null);
    }

    public Integer insertByBatch(Emp emp){
       return empMapper.insertSelective(emp);
    }




}
