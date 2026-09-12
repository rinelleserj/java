
// Для каждого числа из заданной последовательности натуральных чисел
// преобразовать его так, чтобы цифры числа образовывали 
// максимально возможное число.
import java.util.Scanner;

public class Task35 {
    public static void main(String args[]) {
        System.out.println("Введите последовательность чисел(для завершения программы введите Ctrl+D)" + "\n");
        enterNumbers();
    }

    private static int maxNumber(int number) {
        if (number == 0) {
            return 0;
        }
        int digits[] = new int[10];
        int curDigit;
        while (number > 0) {
            curDigit = number % 10;
            digits[curDigit]++;
            number /= 10;
        }
        int result = 0;
        for (int i = 9; i >= 0; i--) {
            while (digits[i] > 0) {
                result = result * 10 + i;
                digits[i]--;
            }
        }
        return result;
    }

    private static void enterNumbers() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            System.out.println(maxNumber(number));
        }

        in.close();
    }
}
