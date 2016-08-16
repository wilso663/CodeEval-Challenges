package com.ArchCloud.Challenges;
import java.io.*;
/**
 * Panacea - truth or lie
 * Challenge Description:

There are many computer and human viruses nowadays. Scientists are scratching their heads over antiviruses that could stop
a particular virus and, in most cases, they find right solutions.
So, virologists need to know which antiviruses can protect us from viruses, and what they still have to 
work on to secure against the remaining viruses. Let’s help them out!

Input sample:
64 6e 78 | 100101100 11110
5e 7d 59 | 1101100 10010101 1100111
93 75 | 1000111 1011010 1100010

The first argument is a path to a file. Each line includes a test case with virus components in the hexadecimal numeral system (HEX)
and antivirus components in the binary number system (BIN). Virus and antivirus components are separated by a pipeline '|'.

Output sample:
True
True
False

Your task is to calculate the sum of all virus components and compare it with the sum of antivirus components. 
If the numbers are the same or the sum of antivirus components is greater than the sum of virus components, 
this means that the virus was stopped. So, print True. Otherwise, print False.

Constraints:

    The sum of components can be from 60 to 1500.
    The number of components in virus and antivirus can be from 1 to 8.
    The number of test cases is 40.

 *
 */
public class CodeEval237 {

	public static void main (String[] args) 
    {
		try{
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader("textfile.txt"));
        String str;
        while ((str = buffer.readLine()) != null) 
        {
            String[] derp = str.split("\\|");
		    String[] herp = derp[0].trim().split(" ");
		    String[] herp2 = derp[1].trim().split(" ");
            int firstSum = 0;
            int secondSum = 0;
            for(int i = 0; i < herp.length;i++)
                firstSum += hex2decimal(herp[i]);
            for(int i = 0; i < herp2.length;i++)
            	secondSum += binary2decimal(herp2[i]);
           
            System.out.println((secondSum >= firstSum));
        }
        buffer.close();
		}
		catch(Exception ex){
		ex.printStackTrace();}
	}
	public static int hex2decimal(String s) 
	{
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
	
	public static int binary2decimal(String s)
	{
        String digits = "01";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 2*val + d;
        }
        return val;
    }
}
