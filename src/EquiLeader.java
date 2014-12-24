/*
 *	Shaun Mbateng
 *	EquiLeader
 *	This program finds the number of equi leaders in a given array.
 *	It has a time complexity of O(N).
 */

import java.util.Scanner; //For User Input

public class EquiLeader 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in); //For Inputs
		int len; //Length of Array
		int [] values; //Array to Check
		int elCount; //Count of Equi Leaders
		Leader Set = new Leader();
		
		//Enter and Set Array Length
		System.out.print("Enter the Array Length: ");
		len = cin.nextInt();
		values = new int [len];
		System.out.println();
		
		//Fill Arrays
		for (int i=0; i<len; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			values[i] = cin.nextInt();
		}
		
		cin.close(); //No More Inputs Needed
		elCount = Set.getEquiLeaderCount(values);
		System.out.println(); //Print Line Space
		
		//Print Message Depending on Result
		if (elCount!=1)
			System.out.println("There are "+elCount+" equi leaders in the given array.");
		else
			System.out.println("There is 1 equi leader in the given array.");
	}
}
