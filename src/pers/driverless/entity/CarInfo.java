package pers.driverless.entity;

public class CarInfo {
	public CarInfo(int positionX,int positionY,String orientation){
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}
	
	private int positionX;
	private int positionY;
	private String orientation;
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String toString() {
		return "CarInfo [positionX=" + positionX + ", positionY=" + positionY
				+ ", orientation=" + orientation + "]";
	}
}
