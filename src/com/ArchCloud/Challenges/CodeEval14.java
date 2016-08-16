package com.ArchCloud.Challenges;
/**
 * String Permutations
Sponsoring Company: Houghton Mifflin

  
Challenge Description:

Write a program which prints all the permutations of a string in alphabetical order. We consider that digits < upper case letters < lower case letters. The sorting should be performed in ascending order.
Input sample:

Your program should accept a file as its first argument. The file contains input strings, one per line.

For example: 
1 hat
2 abc
3 Zu6				
Output sample:
1 aht,ath,hat,hta,tah,tha
2 abc,acb,bac,bca,cab,cba
3 6Zu,6uZ,Z6u,Zu6,u6Z,uZ6
Print to stdout the permutations of the string separated by comma, in alphabetical order.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
public class CodeEval14 {

	public static void main (String[] args) throws IOException 
    {
        //File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String str;
        
        while ((str = in.readLine()) != null) 
        {
        	//Read in single line strings one a time and print out all possible permutations of that string
            ArrayList<String> List = new ArrayList<String>(); //Create a dynamic size array
            str = str.trim();
            permutation(str, List);
            String[] derp = List.toArray(new String[List.size()]);
		    Arrays.sort(derp); //default sort functions exactly within the challenge constraints
		    for(int i = 0; i< derp.length;i++)
		    {
			
			    System.out.print(derp[i]);
			    if(i < derp.length - 1) //print out commas until the final string
				    System.out.print(",");
		    }
		    System.out.println();
        }
        in.close();
    }
    public static void permutation(String str, ArrayList<String> list) 
    { 
	    permutation("", str, list); 
	}
    /**
     * Helper recursive function returns all possible patterns of a given string
     * @param prefix all characters before the current index in the string
     * @param str all characters left in the string to permute
     * @param list ArrayList to contain string permutations
     */
	private static void permutation(String prefix, String str, ArrayList<String> list)
	{
	    int n = str.length();
	    if (n == 0) list.add(prefix);
	    else 
	    {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list);
	    }
	}

}
