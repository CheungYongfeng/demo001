package pers.driverless.service;

import pers.driverless.entity.CarInfo;
import pers.driverless.entity.Park;

public class CarImpl implements Car {
	private CarInfo car;
	private Park park;
	public CarImpl(CarInfo car, Park park){
		this.car = car;
		this.park = park;
	}

	public void move(String command) throws NumberFormatException,RuntimeException{
		if("TURN".equals(command.toUpperCase())){
			car.setOrientation(turn());
		}else{
			int distance = Integer.parseInt(command);
			
			switch(getOrientation()){
			case "NORTH":
				car.setPositionY(getPositionY() + distance);
				break;
			case "EAST":
				car.setPositionX(getPositionX() + distance);
				break;
			case "WEST":
				car.setPositionX(getPositionX() - distance);
				break;
			case "SOUTH":
				car.setPositionY(getPositionY() - distance);
				break;	
			}
			
			if(!isFeasible()){
				throw new RuntimeException("The car is beyond the drivable range! Please re-initialize the information of parking lot and car");
			}
		}
	}

	public int getPositionX() {
		// TODO Auto-generated method stub
		return car.getPositionX();
	}

	public int getPositionY() {
		// TODO Auto-generated method stub
		return car.getPositionY();
	}

	public String getOrientation() {
		// TODO Auto-generated method stub
		return car.getOrientation();
	}
	
	public boolean isFeasible(){
		if(park.getLength()<getPositionX() || getPositionX()<0
				|| park.getWide()<getPositionY() || getPositionY()<0){
			return false;
		}
		return true;
	}
	
	public String turn(){
		String forward = null;
		switch(getOrientation()){
			case "NORTH":
				forward = "EAST";
				break;
			case "EAST":
				forward = "SOUTH";
				break;
			case "SOUTH":
				forward = "WEST";
				break;
			case "WEST":
				forward = "NORTH";
				break;	
		}
		
		return forward;
	}
}
