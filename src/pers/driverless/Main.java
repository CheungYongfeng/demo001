package pers.driverless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import pers.driverless.entity.CarInfo;
import pers.driverless.entity.Park;
import pers.driverless.service.CarImpl;

public class Main {
	private static final String[] arr = { "NORTH", "EAST", "SOUTH", "WEST" };
	private static final ArrayList<String> list = new ArrayList<String>(
			Arrays.asList(arr));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.println("set the length of parking lot:");
		while (in.hasNext()) {
			int length = 0;
			while (in.hasNext()) {
				try {
					length = Integer.parseInt(in.next());
					break;
				} catch (NumberFormatException e) {
					System.out
							.println("Wrong input! please input positive integer.");
					continue;
				}
			}

			System.out.println("set the wide of parking lot");
			int wide = 0;
			while (in.hasNext()) {
				try {
					wide = Integer.parseInt(in.next());
					break;
				} catch (NumberFormatException e) {
					System.out
							.println("Wrong input! please input positive integer.");
					continue;
				}
			}
			Park park = new Park(length, wide);

			String orientation = null;
			System.out
					.println("set the Initial orientation of car,please input NORTH,EAST,SOUTH or WEST.");
			while (in.hasNext()) {

				orientation = in.next().trim().toUpperCase();
				if (list.contains(orientation)) {
					break;
				}
				System.out
						.println("wrong input,please input NORTH,EAST,SOUTH or WEST.");
			}

			System.out.println("set the the Initial position-X of car");
			int positionX = 0;
			while (in.hasNext()) {
				try {
					positionX = Integer.parseInt(in.next());
					if(positionX > length || positionX <= 0){
						System.out
							.println("Wrong input! The initialization position cannot exceed the parking area.Please enter again:");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out
							.println("Wrong input! please input positive integer.");
					continue;
				}
			}
			System.out.println("set the the Initial position-Y of car");
			int positionY = 0;
			while (in.hasNext()) {
				try {
					positionY = Integer.parseInt(in.next());
					if(positionY > wide || positionY <= 0){
						System.out
							.println("Wrong input! The initialization position cannot exceed the parking area.Please enter again:");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out
							.println("Wrong input! please input positive integer.");
					continue;
				}
			}
			CarInfo car = new CarInfo(positionX, positionY, orientation);
			System.out.println(car.toString());
			
			CarImpl service = new CarImpl(car, park);
			System.out
					.println("input your command,input \"TURN\" or positive integer");

			while (in.hasNext()) {
				String command = in.next().trim();
				try {
					service.move(command);
				} catch (NumberFormatException e) {
					System.out
							.println("Wrong command! Please input \"TURN\" or positive integer");
					continue;
				} catch (RuntimeException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					break;
				}

				System.out.println(car.toString());
				System.out
						.println("input your command,input \"TURN\" or positive integer");
			}
			System.out.println("set the length of parking lot");
		}

		

	}

}
