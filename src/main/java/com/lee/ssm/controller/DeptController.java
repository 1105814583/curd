package com.lee.ssm.controller;

import com.lee.ssm.common.Msg;
import com.lee.ssm.entity.Dept;
import com.lee.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lee
 * @version 2022/4/20 21:07
 * @since JDK8
 */



@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping("/list")
    public Msg selectAllDept(){
         List<Dept> depts = deptService.selectAll();
        return Msg.success(depts);
    }




}
