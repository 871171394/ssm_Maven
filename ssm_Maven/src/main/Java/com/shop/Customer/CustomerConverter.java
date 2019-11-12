package com.shop.Customer;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerConverter implements Converter<String,Date> {


    @Override
    public Date convert(String s) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
