package com.fox.alibaba.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-28 14:35
* @version 1.0
*/
public abstract class TimeTask {
	public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
    
            @Override
            public void run() {
    
                System.out.println("Run timerTask：" + new Date());
            }
        };
  
        Timer timer = new Timer();
 
        timer.schedule(timerTask, 1000, 3000);
        timer.cancel();
	}
}
