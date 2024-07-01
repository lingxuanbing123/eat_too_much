package com.cbl.backend.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewResult {
    private Integer code;
    private String msg;
    private Object data;
    public static NewResult success(){
        return new NewResult(200,"success",null);
    }
    public static NewResult success(Object data){
        return new NewResult(200,"success",data);
    }
    public static NewResult error(String msg){
        return new NewResult(0,msg,null);
    }
}
