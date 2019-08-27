package com.lengedyun.springbootjpa.controller;

import com.lengedyun.springbootjpa.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beanMappingController")
public class BeanMappingTest {

    @RequestMapping("/goTestPage")
    public String goTestPage(){
        return "beanmappingtest";
    }

    /**表单方式提交**/
    @RequestMapping("/formSubmit")
    public void formSubmit(Person person){
        System.out.println(person.toString());
    }

    /**Ajax方式提交**/
    @RequestMapping("/ajaxSubmit")
    public void ajaxSubmit(Person person){
        System.out.println(person.toString());
    }


    @RequestMapping("/goAjaxPage")
    public String goAjaxPage(){
        return "beanmappingajax";
    }

}
