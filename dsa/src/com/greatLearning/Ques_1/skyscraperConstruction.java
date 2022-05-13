package com.greatLearning.Ques_1;

import java.util.*;

public class skyscraperConstruction {
	
	// Program to process the inputed array data and floor numbers.
	public void calculate(int floor_numbers, int[] arr_of_floors) {

		// Creating a new array of size "floor_Numbers" to store "arr_of_floors" data
		// copying data of array "arr_of_floors" into temp[]
		// array "arr_of_floors" also have the same size as that of temp.
		int[] temp = new int[floor_numbers];

		for (int k = 0; k < floor_numbers; k++) {
			temp[k] = arr_of_floors[k];
		}

		// Performing sorting operation on array "temp"
		// i.e. arranging temp data in descending order
		MergeSort obj = new MergeSort();
		obj.sort(temp, 0, temp.length - 1);

		// creating two stacks for storing "arr_of_floors" data
		// Data will be pushed into respective stacks when at some indices
		// arr_of_floors[i] != temp[j]
		Stack<Integer> arr_temp = new Stack<Integer>();
		Stack<Integer> stack1 = new Stack<Integer>();

		// Initializing index for temp[], i=0;
		int i = 0;

		// in this program index 'i' of temp[] is taken as reference and
		// when index 'i' become floor_numbers-1 program will come out from loop
		// or program can also break the loop for specific conditions
		while (i < floor_numbers) {

			/*
			 * Consider example: arr_of_floors = [1, 2, 3, 8, 9, 10, 4, 5, 7, 6] 
			 * temp[] will be sorted array of arr_of_floors[] i.e. temp = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
			 */

			/*
			 * taking data at first position of temp[] 
			 * Comparing it with every data of arr_of_floors[] *
			 */
			
			for (int j = 0; j < floor_numbers; j++) {

				
				if (arr_of_floors[j] != temp[i]) {

					//pushing data into stack
					arr_temp.push(arr_of_floors[j]);
					System.out.println("Day: " + (j + 1) + "\n");
					continue;
				}

				else {
					
					//If first element temp[] is equal to first element of arr_of_floors,
					//then printing the first element and incrementing the index i
					//Incrementing index i will start comparing next element of temp[] with all element of arr_of_floors[j]
					
					if (j == 0) {
						System.out.println("Day: " + (j + 1));
						System.out.print(arr_of_floors[j]);
						i++;
						continue;
					}
					
					/*
					 * If temp[i] is equal to last element of arr_of_temp[],
					 * then printing temp[i] and 
					 * incrementing i, then printing temp[i], unless i=floor_numbers-1;
					 * 
					 * for examle in above mentioned arr_of_floors data
					 * '6' is at last position i.e. floor size 6 is received ata last day (day 10)
					 * so when temp[i]==6; 
					 * all remaing data of temp[] will be printed
					 * i.e. 5, 4, 3, 2, 1
					 */

					else if (j == floor_numbers - 1) {
						System.out.println("Day: " + (j + 1));
						System.out.print(temp[i] + " ");
						i++;
						while (i < floor_numbers) {
							System.out.print(temp[i] + " ");
							i++;
						}
						break;
						
					}

					//In case, where temp[i] =arr_of_floors[j], but not j!=0 or j!=floor_numbers - 1;
					//then printing temp[i], incrementing index i;
					
					/*
					 * checking whether stack arr_temp is empty
					 * if not poping all arr_temp data into array temp3 unless arr_temp becomes empty					 * 					 * 
					 */
					
					else {
						System.out.println("Day: " + (j + 1));
						System.out.print(arr_of_floors[j] + " ");

						i++;

						int[] temp3 = new int[arr_temp.size()];
						int size1 = arr_temp.size();

						/*
						 *during adding stack "arr_temp" popped data into array temp3[],
						 *checking whether element of temp3[] is equal to temp[i];
						 *if temp[i]=temp3[n]
						 *then printing temp[i], and incrementing i;
						 *else putting element into stack "stack1"
						 */
						
						int n = 0;
						while (n < size1) {
							temp3[n] = arr_temp.pop();
							if (temp3[n] == temp[i]) {
								System.out.print(temp[i] + " ");
								i++;
								n++;
							}

							else {
								stack1.push(temp3[n]);
								n++;
							}
						}

						/*
						 * if stack1 is not empty then all the elemnt of stack1 will be pushed into stack "arr_temp"
						 */
						
						while (!stack1.isEmpty()) {
							arr_temp.push(stack1.pop());
						}

						System.out.println("\n");
					}
				}

			}
		}

	}

	//Program to sorting data
	// for coding practise purpose I am writing code for sorting data instead of using inbuilt method.
	
	static class MergeSort {
		public void sort(int[] arr, int left, int right) {
			if (left < right) {
				int mid = (left + right) / 2;
				sort(arr, left, mid);
				sort(arr, mid + 1, right);
				merge(arr, left, mid, right);
			}
		}

		public void merge(int[] arr, int left, int mid, int right) {
			int size1 = mid - left + 1;
			int size2 = right - mid;
			int[] arr1 = new int[size1];
			int[] arr2 = new int[size2];

			for (int i = 0; i < size1; i++) {
				arr1[i] = arr[left + i];
			}

			for (int j = 0; j < size2; j++) {
				arr2[j] = arr[mid + 1 + j];
			}

			int i = 0;
			int j = 0;
			int k = left;

			while (i < size1 && j < size2) {

				if (arr1[i] < arr2[j]) {

					arr[k] = arr2[j];
					j++;
				}

				else {
					arr[k] = arr1[i];
					i++;
				}
				k++;
			}

			while (i < size1) {
				arr[k] = arr1[i];
				i++;
				k++;
			}

			while (j < size2) {
				arr[k] = arr2[j];
				j++;
				k++;
			}
		}
	}
}