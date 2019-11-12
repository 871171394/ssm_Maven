package com.shop.web;

import com.shop.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class domeException {

    @RequestMapping("/exception")
    public String exception() throws MyException {
        try {
            System.out.println("aaaaaa");
            int i=10/0;
        } catch (Exception e) {
            throw new MyException("出问题了,可能是除数为零了...");
        }

        return "test";
    }

}
