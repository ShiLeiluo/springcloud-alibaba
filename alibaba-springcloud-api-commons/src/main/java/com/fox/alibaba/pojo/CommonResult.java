package com.fox.alibaba.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-03 09:33
* @version 1.0
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {
 
    private Integer code;//返回状态码
    private String  message;//返回是否调用成功
    private  T data; //返回的数据
 
    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
 
}
