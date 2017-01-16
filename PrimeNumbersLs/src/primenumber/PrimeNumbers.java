
package primenumber;

import java.io.*;

/**
 * PrimeNumbers takes two command line arguments, The first is a number n that is used to find the prime
 * numbers between 2 and n, while the second is the name of the output file.
 * @author Leonel Sanchez
 * @version 1.0
 */

public class PrimeNumbers {

	
	public static void main(String[] args) {
	
		String fileName = args[1]+ ".txt";
		int maxPrime = Integer.parseInt(args[0]);
		
		try {
			BufferedWriter primeFile = new BufferedWriter(new FileWriter(fileName));
			
			primeFile.write("N is " + maxPrime);
			primeFile.newLine();
			primeFile.write("File Name is " + fileName);
			primeFile.newLine();
			SievePrimes primes = new SievePrimes(maxPrime, fileName);
			primes.computePrimes(primeFile);			
			primeFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("Data is output in file " + fileName);		
		
	}

}

