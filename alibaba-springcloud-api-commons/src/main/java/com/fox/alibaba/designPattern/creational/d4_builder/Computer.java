package com.fox.alibaba.designPattern.creational.d4_builder;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 10:36
* @version 1.0
*/
/**
 * 产品类
 * @author F1337248
 *
 */
public class Computer {
	private String mBoard;
	private String mDisplay;
	private String mOS;
	public String getmBoard() {
		return mBoard;
	}
	public void setmBoard(String mBoard) {
		this.mBoard = mBoard;
	}
	public String getmDisplay() {
		return mDisplay;
	}
	public void setmDisplay(String mDisplay) {
		this.mDisplay = mDisplay;
	}
	public String getmOS() {
		return mOS;
	}
	public void setmOS(String mOS) {
		this.mOS = mOS;
	}
	
	
	public static class Builder {
		private String mBoard;
		private String mDisplay;
		private String mOS;

		public Builder setmBoard(String mBoard) {
			this.mBoard = mBoard;
			return this;
		}

		public Builder setmDisplay(String mDisplay) {
			this.mDisplay = mDisplay;
			return this;
		}

		public Builder setmOS(String mOS) {
			this.mOS = mOS;
			return this;
		}
		
		/**
		 * 组装产品
		 */
		
		private void constract(Computer computer) {
			computer.setmBoard(mBoard);
			computer.setmDisplay(mDisplay);
//			computer.setmOS(mOS);
		}
		
		public Computer create() {
			
			Computer computer = new Computer();
			constract(computer);
			return computer;
			
		}
	}
	

	
}
