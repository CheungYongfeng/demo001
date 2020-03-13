package pers.driverless.entity;

public class Park {
	public Park(int length,int wide){
		this.length = length;
		this.wide = wide;
	}
	private int length;
	private int wide;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWide() {
		return wide;
	}
	public void setWide(int wide) {
		this.wide = wide;
	}
	public String toString() {
		return "Park [length=" + length + ", wide=" + wide + "]";
	}
	
	
}
