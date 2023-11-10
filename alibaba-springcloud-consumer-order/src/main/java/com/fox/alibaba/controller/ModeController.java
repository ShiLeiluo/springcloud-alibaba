package com.fox.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fox.alibaba.service.ExportReport;
import com.fox.alibaba.service.impl.ExportReportImpl;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 09:28
* @version 1.0
*/
@RestController
public class ModeController {

    @Autowired
    private ExportReport b;
   	@Autowired
    private ExportReportImpl exportReport;


    /**
     * 这个方法是我们实际导出excl文件得方法
     *
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return  b.export();
    }

    /**
     * 这个方法就是时时进度条
     * 
     * @return
     */
    @GetMapping("/progress")
    public String progress() {
       return exportReport.update();
    }
}
