// Среди натуральных чисел найти число с максимальной суммой своих простых
// делителей

import java.util.Scanner;

public class Task21 {
    public static void main(String args[]) {
        System.out.println("Введите последовательность чисел(для завершения введите Ctrl+D)" + "\n");

        int result = maxNumber();
        System.out.println("Число с максимальной суммой своих простых делителей: " + result);

    }

    private static boolean isPrime(int number) {
        if (number == 1 || number == 0) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                if (isPrime(i)) {
                    sum += i;
                }
                if (isPrime(number / i) && number / i != i) {
                    sum += number / i;
                }
            }
        }
        return sum;
    }

    private static int maxNumber() {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt(), maxSum = sumOfDivisors(max);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            int curSum = sumOfDivisors(number);
            if (curSum > maxSum) {
                max = number;
                maxSum = curSum;
            }
        }
        in.close();
        return max;
    }
}
