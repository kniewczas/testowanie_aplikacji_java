package com.example.jbehavedemo;

public class Calculator {
	
	private int leftOp;
	private int rightOp;
	
	public int add(){
		return leftOp + rightOp;
	}
	
	public int subtract(){
		return leftOp - rightOp;
	}

	public int getLeftOp() {
		return leftOp;
	}

	public void setLeftOp(int leftOp) {
		this.leftOp = leftOp;
	}

	public int getRightOp() {
		return rightOp;
	}

	public void setRightOp(int rightOp) {
		this.rightOp = rightOp;
	}
}
