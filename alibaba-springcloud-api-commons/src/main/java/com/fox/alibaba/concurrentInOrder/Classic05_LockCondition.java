package com.fox.alibaba.concurrentInOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 16:19
* @version 1.0
*/
// 使用线程的Condition(条件变量)方法
public class Classic05_LockCondition {

    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
 
    /**
     * 为什么要加这两个标识状态?
     * 如果没有状态标识，当t1已经运行完了t2才运行，t2在等待t1唤醒导致t2永远处于等待状态
     */
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;

    // wait(), notify()/notifyAll()
    // await(), signal()/signalAll()
	public static void main(String[] args) {
		
		final Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				System.out.println("1. 打开冰箱");
				t1Run = true;
				condition1.signal();
				lock.unlock();
			}
		});
		final Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					if (!t1Run) {
						condition1.await();
					}
					System.out.println("2. 塞入大象");
					t2Run = true;
					condition2.signal();
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					lock.unlock();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					if (!t2Run) {
						condition2.await();
					}
					System.out.println("3. 关闭冰箱");

				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					lock.unlock();
				}
			}
		});
		t3.start();
		t1.start();
		t2.start();
	}
}
