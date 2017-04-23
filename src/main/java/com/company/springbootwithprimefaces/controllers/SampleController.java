package com.company.springbootwithprimefaces.controllers;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */

@Component
@Scope("view")
public class SampleController
{
    @Getter
    @Setter
    private String hello="Hello Sample Controller";

    @Getter
    @Setter
    public List<String> testStrings = Lists.newArrayList("Aaa","Bbb","Ccc","Ddd");

    public void testButton()
    {
        throw new RuntimeException("Sample Exception for error page");
    }

}
