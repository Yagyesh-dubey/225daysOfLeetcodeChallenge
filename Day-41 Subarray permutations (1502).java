/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner Sc = new Scanner(System.in);
        int tc = Sc.nextInt();
        while (tc-- > 0) {
            int n = Sc.nextInt();
            int k = Sc.nextInt();
            if (n == 1 && k == 1) {
                System.out.println("1");
            } else if (n != 1 && k == 1) {
                System.out.println("-1");
            } else {
                for (int i = 1; i <= n; i++) {
                    if (i != k) {
                        System.out.print(i + " ");
                    }
                }
                System.out.print(k);
                System.out.println();
            }
        }	// your code goes here
	}
}
