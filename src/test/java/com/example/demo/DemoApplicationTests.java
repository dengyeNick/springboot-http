package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    	System.out.println("sdfs");
    	String time="2020-12";
    	int start=time.indexOf("-")+1;
    	System.out.println(start);
    	int end=time.lastIndexOf("-");
    	System.out.println(start);
    	Calendar c = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    	
    	try {
    		c.setTime(sdf.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String month = String.valueOf(c.get(Calendar.MONTH) + 1);
    	if(Integer.valueOf(month)<10) {
    		month="0"+month;
    	}
    	System.out.println( month);
    }
    
    
    @Test
    void testString() {
    	String time="2020-02";
    	String copy=time;
    	for (int i=0;i<10;i++) {
    		time =copy;
    		time+="-01";
    		System.out.println(time);
    	}
    }

}
