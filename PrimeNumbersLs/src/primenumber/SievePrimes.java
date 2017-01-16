package primenumber;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * SievePrimes uses the sieve algorithm to calculate primes from 2 to input n
 * and outputs the result into a txt document.
 * Information on sieve algorithm can be found here: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes 
 * @author Leonel Sanchez
 * @class CS4354
 * @Version 1.0
 */
public class SievePrimes {
		int n;
		String outFile;
	public SievePrimes(int n, String outFile)
	{
		this.n = n;
		this.outFile=outFile;
	}
	/**
	 * ComputePrimes takes the argument n and uses it to compute primes from 2 to n using
	 * Sieves algorithm. n and outFile become defined when SievePrimes object is created.
	 * This method returns nothing, but calls method print in order to display the calculated output
	 * @BufferedWriter
	 * @since 1.0
	 */
	public void computePrimes(BufferedWriter primeFile)
	{
		boolean[] primeArray = new boolean[n+1];
		for (int i = 1; i <= n; i++)
		{
			primeArray[i]=true;
			
		}
	
		//nested loop to turn any element with a multiple of a number 2-7 to false.
		for(int i = 2; i <= Math.sqrt(n);i++)
		{
			//System.out.println(i + " " + primeArray[i]);
			if (primeArray[i] == true)
			{
			
				for (int j = (int) Math.pow(i, 2) ; j <= n;)
				{
					primeArray[j] = false;				
					j = j + i;
										
				}
				
			}
		}
		
		print(primeArray, primeFile);
		
	}
	
	/**
	 * print prints an array to and output file
	 * @primes		array to be displayed
	 * @primeFile 	writing to an output file
	 * @since 1.0
	 */
	private void print(boolean[] primes, BufferedWriter primeFile)
	{
		for ( int i = 2; i <=n;i++)
		{
			if(primes[i]==true)
			{
				try {
					primeFile.write(i + " ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
