package com.fox.alibaba.concurrent;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-19 15:40
* @version 1.0
*/
//synchronized的可重入性
public class Classic04_Synchronized_Runnable implements Runnable{
    static Classic04_Synchronized_Runnable instance=new Classic04_Synchronized_Runnable();
    static int a=0;
    static int b=0;

    @Override
    public void run() {
        for(int j=0;j<2;j++){
            //this,当前实例对象锁
            synchronized(this){
                a++;
                increase();//synchronized的可重入性
                System.out.println(Thread.currentThread().getName()+ "a: "+a+", b: "+b);
            }
        }
    }

    public synchronized void increase(){
        b++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("----------------------------");
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }
}
