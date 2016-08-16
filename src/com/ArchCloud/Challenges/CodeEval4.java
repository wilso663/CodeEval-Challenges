package com.ArchCloud.Challenges;
/** 
Sum of Primes

Challenge Description:

Write a program which determines the sum of the first 1000 prime numbers.
Input sample:

There is no input for this program.
Output sample:
3682913

Print to stdout the sum of the first 1000 prime numbers. 
 */
public class CodeEval4 {

	public static void main(String[] args) 
	{
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		int primesFound = 0;
		int sum = 1;
		for(int i = 1; i < Integer.MAX_VALUE;i+=2)
		{
			if(primesFound == 1000)
			{
				System.out.println(sum);
				break;
			}
			if(isPrime(i))
			{
				sum += i;
				primesFound++;
			}
		}
	}
	public static boolean isPrime(int num)
	{
	    if ( num > 2 && num%2 == 0 ) {
	        return false;
	    }
	    int top = (int)Math.sqrt(num) + 1; //We can take the square root of a number to determine if it is prime.
	    for(int i = 3; i < top; i+=2){
	        if(num % i == 0){
	            return false;
	        }
	    }
	    return true; 
	}

}
