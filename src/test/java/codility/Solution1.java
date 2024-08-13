package codility;

import java.util.Scanner;

class Solution {
    public int solution(int N) {
        int originalSum = sumOfDigits(N);
        int currentNumber = N + 1;


        while (true) {

            int currentSum = sumOfDigits(currentNumber);


            if (currentSum == originalSum) {
                return currentNumber;
            }


            if (currentNumber % 10 == 9) {
                currentNumber += 1; // Skip numbers like x9, x99, etc.
            } else {
                currentNumber++;
            }
        }
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (N): ");
        int N = scanner.nextInt();

        Solution sol = new Solution();
        int result = sol.solution(N);

        System.out.println("The smallest integer greater than " + N + " with the same digit sum is: " + result);
    }
}
