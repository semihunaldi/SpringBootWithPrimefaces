package com.company.springbootwithprimefaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWithPrimefacesApplicationTests
{

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads()
    {
        System.out.println(new Date(applicationContext.getStartupDate()));
    }

}
