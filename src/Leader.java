/*
 * The class that finds the count of equi leaders.
 * Has a time complexity of O(N).
 */

public class Leader 
{
	public int getEquiLeaderCount(int [] V)
	{
		switch (V.length) //Base and Edge Case
		{
			case 2: //Two Elements
				if (V[0]==V[1]) //If Two Elements Are Equal
					return 1; //First Index is Only Equi Leader
			case 1: //One Element (or Two Not Equal Elements)       
				return 0; //First Index is Only Equi Leader
		}
		
		/*
		 * To find the leading value, a make-shift stack is used.
		 * A real one isn't needed since only the size and one of the left over values is
		 * needed. Therefore, a real stack isn't used to save memory. Instead, regular
		 * variables are created to store the information needed.
		 * An important thing to notice is that it's impossible to be an equi leader
		 * 		of an array where the leader of the sub arrays isn't the leader of the full array.
		 * Therefore the leader can be found first, then at each index just compare the counts 
		 * 		to the left and right and see if the leader is also the leader of the sub arrays.	
		 */
		
		//General Case
		int N = V.length; //Number of Elements
		int lead = V[0]; //Current Leader, Initialize and Push on Make-Shift Stack
		int size = 1; //Make-Shift Stack Size, Initialized to 1 With Prior Make-Shift Push
		int limit = N/2; //The Required Minimum to Meet Requirements of Being Leader
		int count = 0; //Count of Equi Leaders
		int lc = 0; //Count of Lead to Left
		int rc = 0; //Count of Lead to Right
		
		for (int i=1; i<N; i++) //Loop Through Array From 2nd Element
		{
			if (size==0) //If Size is Zero
			{
				size++; //Increment Size
				lead = V[i]; //Update Leader
				continue; //Next Loop Increment
			}
			if (lead!=V[i]) //Size is Positive, but Leader Doesn't Match Current Element
				size--; //Decrement Size of Make-Shift Stack
			else //Positive Size, Leader Matches Current Element
				size++; //Increment Size of Make-Shift Stack
		}		
		if (size<1) //No Elements Left in Make-Shift Stack
			return 0; //No Leader, No Equi Leaders
		for (int i=0; i<N; i++) //Loop Through Array Again
		{
			if (V[i]==lead) //If Element Equals Leader
				rc++; //Increment Right Count
		}
		if (rc<=limit) //Count Doesn't Exceed Minimum Requirement
			return 0; //No Leader, No Equi Leader
		for (int S=0; S<N;) //Final Loop Through Array
		{
			if (V[S++]==lead) //If Element Equals Lead
			{
				lc++; //Increment Left Count
				rc--; //Decrement Right Count
			}
			if (lc>S/2 && rc>(N-S)/2) //If Leader is Lead of Two Subarrays
				count++; //Increment Equi Leader Count
		}
		
		return count; //Return Count of Equi Leaders
	}
}