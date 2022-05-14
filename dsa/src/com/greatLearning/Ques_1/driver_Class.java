package com.greatLearning.Ques_1;

import java.util.Scanner;

public class driver_Class {
	public static void main(String[] arg) {
		Scanner aj = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int floor_numbers = aj.nextInt();

		int[] arr_of_floors = new int[floor_numbers];

		for (int i = 1; i <= floor_numbers; i++) {
			System.out.println("enter the floor size given on day : " + i);
			arr_of_floors[i - 1] = aj.nextInt();
		}

		System.out.println("The order of construction is as follows");

		skyscraperConstruction obj = new skyscraperConstruction();
		obj.calculate(floor_numbers, arr_of_floors);
	}

}
