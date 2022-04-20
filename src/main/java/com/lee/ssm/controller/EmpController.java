package com.lee.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.ssm.common.Msg;
import com.lee.ssm.entity.Emp;
import com.lee.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @version 2022/4/19 11:48
 * @since JDK8
 */

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

//    @GetMapping("/")
//    public String index(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize, Model model) {
//        PageHelper.startPage(pageNo,pageSize);
//        List<Emp> emps = empService.findAllEmp();
//        PageInfo pageInfo=new PageInfo(emps,5);
//        model.addAttribute("pageInfo", pageInfo);
//        return "index";
//    }

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/json")
    @ResponseBody
    public Msg json(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize, Model model) {
        PageHelper.startPage(pageNo,pageSize);
        List<Emp> emps = empService.findAllEmp();
        PageInfo pageInfo=new PageInfo(emps,5);
        return Msg.success(pageInfo);
    }








}
