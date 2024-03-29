package com.fox.alibaba.leetcode150_7_Satck;

import java.util.Deque;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-19 20:20
* @version 1.0
*/
public class Classic054_Stack_MinStack {

	public static void main(String[] args) {
		Classic054_Stack_MinStack obj = new Classic054_Stack_MinStack();
		 obj.push(1);
		 obj.pop();
		 int param_3 = obj.top();
		 int param_4 = obj.getMin();
		 System.out.println(param_3+" "+param_4);
	}
	Deque<Integer> xStack;
    Deque<Integer> minStack;

    public Classic054_Stack_MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */