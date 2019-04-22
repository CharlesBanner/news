package com.charles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-22
 * Time: 10:50
 */
@RestController
public class IndexController {


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        try {
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello world!";
    }
}
