package com.company.springbootwithprimefaces.ws;

import lombok.Data;

/**
 *
 */

@Data
public class BaseResult
{
    private Integer errorCode = 0 ;

    private String errorDescription = "Success";

    public BaseResult(Integer errorCode, String errorDescription)
    {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BaseResult()
    {
    }
}
