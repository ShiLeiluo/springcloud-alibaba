package com.fox.alibaba.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.fox.alibaba.service.impl.MsgService;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 16:02
* @version 1.0
*/

@RestController
public class MsgController {
	
	@Resource(name="msgService")
	private MsgService msgService;
	
	@ResponseBody
	@RequestMapping(value = "/getMsg", produces="text/event-stream;charset=UTF-8")
	DeferredResult<String> getMsg(HttpServletResponse response) throws IOException {
		response.setContentType("text/event-stream");
    	response.setCharacterEncoding("UTF-8");
    	response.setStatus(200);
//    	msgService.removeErrorResponse();
//    	msgService.getListRes().add(response);
    	if(!response.getWriter().checkError()){
    		response.getWriter().write("data:hello\n\n");
    		response.getWriter().flush();
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		response.getWriter().write("data:world\n\n");
    		response.getWriter().flush();
    	}
    	
    	
//    	try {
//    		response.getWriter().write("20%");
//			Thread.sleep(1000);
//    		response.getWriter().write("30%");
//			Thread.sleep(1000);
//    		response.getWriter().write("40%");
//			Thread.sleep(1000);
//    		response.getWriter().write("50%");
//			Thread.sleep(1000);
//    		response.getWriter().write("60%");
//			Thread.sleep(1000);
//			response.getWriter().flush();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	DeferredResult<String> df = new DeferredResult<String>(60000l);
    	System.out.println("df: "+df);
    	return df;
    }
	


}
