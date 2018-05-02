

/************************************************************************************************************
 * Program:			ReOrganize a String 
 * Description:		The program is to reaArange the letters in a string and there should be no two characters 
 * 					adjacent to each other.If present, print the empty string.
 ************************************************************************************************************/
import java.util.Scanner;
public class ReorganizeString
{

	public static void main(String[] args)
	{
		//Accept input from user
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String str = " ";
		String str1 = sc.next();
		
		//Convert to character array for swapping
		char arr[] = str1.toCharArray();
		
		//Loop to check whether array contains adjacent two characters and swap them.
		for(int i = 0; i <= arr.length-1; i++)
				{
					if(arr[i] == arr[i+1])
					{
						count++;
						continue;
					}
					else
					{
						// swap if two different adjacent characters .
						char temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						str = String.valueOf(arr);
					}
				}
		
		
		if(count != 3)
		{
			//Loop to check two adjacent characters.If present then print empty else print array.
			for(int i = 0; i < str.length()-1; i++)
			{
				if(str.charAt(i) == str.charAt(i+1))
				{
					System.out.println("empty");
				}
				else
				{
					System.out.println("String is "+str);
					break;
				}
			}
		}
		else
		{
			System.out.println(str);
		}
	}
}

