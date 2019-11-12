package com.shop.web;

import com.shop.domian.Product;
import com.shop.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("test")
    public String getName(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        System.out.println("name:"+name);
        return null;
    }

    @RequestMapping("/test2")
    public String getName(String name){

        System.out.println("name:"+name);
        return null;
    }

    @RequestMapping("/test3")
    public String dolog(String name){

        System.out.println("name:"+name);
        return null;
    }

    @RequestMapping("/test4")
    public String dolog(User user){

        System.out.println("name:"+user.getUsername());
        return null;
    }

    //ajax请求,响应
    @RequestMapping("/productJson")
    @ResponseBody
    public Product productJson(Product product){
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        Product p=new Product();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        return p;
    }

    @RequestMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Integer or){
        System.out.println("or:"+or);
        return null;
    }

    @RequestMapping("/test23")
    public String test2(Model model){
        String name="admin";
        model.addAttribute("name",name);
        return "demo";
    }

}
