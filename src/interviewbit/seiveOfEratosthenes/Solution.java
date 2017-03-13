package interviewbit.seiveOfEratosthenes;

import java.util.ArrayList;

/**
 * Get all the prime numbers between 1 - a
 * Created by adib on 8/21/16.
 */
public class Solution {
    public ArrayList<Integer> sieve(int a) {
        boolean[] prime = new boolean[a+1];
        prime[0] = true;
        prime[1] = true;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < Math.sqrt(a); i++) {
            for(int j= 2; j * i <= a; j++ ) {
                prime[j*i] = true;
            }
        }
        for ( int i = 2; i <= a; i++) {
            if (!prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
