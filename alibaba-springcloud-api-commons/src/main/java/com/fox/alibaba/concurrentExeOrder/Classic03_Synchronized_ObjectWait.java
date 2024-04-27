package com.fox.alibaba.concurrentExeOrder;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 15:06
* @version 1.0
*/
// 使用线程的wait方法
public class Classic03_Synchronized_ObjectWait {
	private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();
 
    /**
     * 为什么要加这两个标识状态?
     * 如果没有状态标识，当t1已经运行完了t2才运行，t2在等待t1唤醒导致t2永远处于等待状态
     */
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;
    
    // wait(), notify()/notifyAll() wait()也会让当前线程释放它所持有的锁
    // await(), signal()/signalAll()
	public static void main(String[] args) {
		final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    System.out.println("1. 打开冰箱");
                    t1Run = true;
                    myLock1.notify();
                }
            }
        });
 
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    try {
                        if (!t1Run) {
                            myLock1.wait();
                        }
                        synchronized (myLock2) {
                            System.out.println("2. 塞入大象");
                            myLock2.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
 
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock2) {
                    try {
                        if (!t2Run) {
                            myLock2.wait();
                        }
                        System.out.println("3. 关闭冰箱");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
		t2.start();
		t3.start();
		t1.start();
		
	}
}
