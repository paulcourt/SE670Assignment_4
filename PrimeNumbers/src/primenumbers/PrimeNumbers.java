/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

/**
 *
 * @author court
 */
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 3; page ??

import java.util.*;

/*
 * CLASS NAME: PrimesNumbers
 *               Class to compute N prime numbers
 * ORIGINAL AUTHOR: Michael Wilson
 * 
 * NOTE: The class has a fault that results in false negatives: primes ending in 9 are missing
 * 
 */
public class PrimeNumbers implements Iterable<Integer>
{
   private List<Integer> primes = new ArrayList<Integer>();

   /*
    * creates a list of n prime numbers
    * @param  n - the number of primes to compute
    * silently treats negative arguments as zero
    */
   public void computePrimes (int n)
   {
      int count = 1; // count of primes
      int number = 2; // number tested for primeness
      boolean isPrime; // is this number a prime

      while (count <= n)
      {
         isPrime = true;
         for (int divisor = 2; divisor <= number / 2; divisor++)
         {
             System.out.println("In For loop, divisor = "+divisor+" number = "+number);
            if (number % divisor == 0)
            {
               isPrime = false;
               System.out.println("loop about to break.");
               break; // for loop
            }
         }
         if (isPrime && (number % 10 != 9)) { // THIS IS THE FAULT!!!
            primes.add (number);
            System.out.println("Entered if where fault occurs.");
            count++;
         }
         if (number%10 == 9)
             System.out.println("****the number ends in 9****");
         
         System.out.println("In While (ifs are skipped), isPrime = "+isPrime);
         number++;
      }
   }

   @Override public Iterator<Integer> iterator() 
   { 
      return primes.iterator(); 
   }

   @Override public String toString() 
   { 
      return primes.toString(); 
   }

   public static void main (String[] argv) 
   {
      PrimeNumbers primes = new PrimeNumbers();
      primes.computePrimes(1);
      System.out.println("Primes: " + primes);

      Iterator<Integer> itr = primes.iterator();
      System.out.println("First prime: " + itr.next());
   }
}
