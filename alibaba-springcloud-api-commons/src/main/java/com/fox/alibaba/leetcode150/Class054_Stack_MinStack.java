package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-19 20:20
* @version 1.0
*/
public class Class054_Stack_MinStack {

	public static void main(String[] args) {
		Class054_Stack_MinStack obj = new Class054_Stack_MinStack();
		 obj.push(1);
		 obj.pop();
		 int param_3 = obj.top();
		 int param_4 = obj.getMin();
		 System.out.println(param_3+" "+param_4);
	}
    public Class054_Stack_MinStack() {

    }
    
    public void push(int val) {

    }
    
    public void pop() {

    }
    
    public int top() {
		return 0;

    }
    
    public int getMin() {
		return 0;

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