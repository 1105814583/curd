package com.lee.ssm.service;

import com.lee.ssm.dao.DeptMapper;
import com.lee.ssm.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lee
 * @version 2022/4/20 21:07
 * @since JDK8
 */


@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> selectAll(){
        return  deptMapper.selectByExample(null);
    }


}
