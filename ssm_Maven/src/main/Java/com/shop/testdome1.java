package com.shop;





import org.junit.jupiter.api.Test;

import java.util.*;

public class testdome1 {

    @Test
    public void dome01(){
        String a="as.dsad.jsp";

        //(as.dsad.jsp)字符串.substring 从什么地方开始截取(下标从0开始)
        System.out.println( a.substring(2));//.dsad.jsp
        //(as.ds1ad.jsp)字符串中最后一个"."在什么位置
        System.out.println(a.lastIndexOf("."));//下标为7
        //删除字符串中包含的"."
        System.out.println(a.replace(".",""));
        //按照什么进行分割
        String[] split = a.split("\\.");
        System.out.println(Arrays.toString(split));

    }

}
