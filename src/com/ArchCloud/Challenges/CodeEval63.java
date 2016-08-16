package com.ArchCloud.Challenges;
import java.io.*;
/**
 Counting Primes
Challenge Description:
Given two integers N and M, count the number of prime numbers between N and M (both inclusive)
Input sample:
2,10
20,30
Your program should accept as its first argument a path to a filename. Each line in this file contains two comma separated positive integers. E.g.
Output sample:
4
2
Print out the number of primes between N and M (both inclusive) 
 */
public class CodeEval63 {

	public static void main(String[] args)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
			String str;
			int count;
			while((str = in.readLine()) != null)
			{
				count = 0;
				String[] derp = str.trim().split(",");
				int from = Integer.parseInt(derp[0]);
				int to = Integer.parseInt(derp[1]);
				for(int i = from;i <= to;i++)
					if(isPrime(i))
						count++;
				
				System.out.println(count);
			}
		}catch(Exception ex)
		{ex.printStackTrace();}
	}
	public static boolean isPrime(int num)
	{
	    if ( num > 2 && num%2 == 0 ) {
	        return false;
	    }
	    int top = (int)Math.sqrt(num) + 1;
	    for(int i = 3; i < top; i+=2){
	        if(num % i == 0){
	            return false;
	        }
	    }
	    return true; 
	}
}
