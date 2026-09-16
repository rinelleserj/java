// Найти все p-значные числа из заданной последовательности 
// натуральных чисел, в записи которых встречаются не более 
// k (k < p) различных цифр, и подсчитать их
// количество.

import java.util.Scanner;

public class Task7 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число p: ");
        int p = in.nextInt();
        System.out.println("Введите число k(k<p): ");
        int k = in.nextInt();
        if (k >= p) {
            System.out.println("Число k задано неверно ");
            in.close();
            return;
        }

        System.out.println("\nВведите последовательность чисел (для завершения введите Ctrl+D или любую букву):\n");
        int count = countNumbers(in, p, k);

        System.out.println("Количество чисел, подходящих под запрос равно " + count);
        in.close();
    }

    private static boolean isNumberPDigit(int number, int p) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count == p;
    }

    private static boolean isLessThanK(int number, int k) {
        int count = 0;
        int digits[] = new int[10];
        while (number > 0) {
            digits[number % 10]++;
            number /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                count++;
            }
        }
        return count <= k;
    }

    private static int countNumbers(Scanner in, int p, int k) {
        int count = 0;
        while (in.hasNextInt()) {
            int number = in.nextInt();
            if (isNumberPDigit(number, p) && isLessThanK(number, k)) {
                count++;
            }
        }
        return count;
    }
}