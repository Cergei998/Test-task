package third_task;

import java.math.BigInteger;

/**
 *         SumOfDigits sumOfDigits = new SumOfDigits();
 *         System.out.println(sumOfDigits.findSumOfDigits(100)); // 648
 */
public class SumOfDigits {

    public int findSumOfDigits(int number) {
        // Create object of BigInteger class
        BigInteger factorialOfNumber = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            // Calculate factorial of input number
            factorialOfNumber = factorialOfNumber.multiply(BigInteger.valueOf(i));
        }
        // factorialOfNumber = 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
        int sum = 0;
        // Convert BigInteger to String value
        String stringOfFactorial = String.valueOf(factorialOfNumber);
        // Convert String to array of chars
        final char[] chars = stringOfFactorial.toCharArray();
        // Iterate array and calculate sum of all elements
        for (int i = 0; i < chars.length; i++) {
        // char[i] convert to String and then convert to Integer
            sum += Integer.parseInt(String.valueOf(chars[i]));
        }
        return sum;
    }
}
