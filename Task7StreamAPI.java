// Дана целочисленная матрица размера A(n,m). Отсортировать
// столбцы матрицы по количеству одинаковых элементов в столбце.

import java.util.Scanner;
import java.util.Arrays;

public class Task7StreamAPI {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] dimensions = enterDimensions(in);
        int n = dimensions[0];
        int m = dimensions[1];
        System.out.println("Введите элементы массива: ");
        int array[][] = new int[n + 1][m];
        enterArray(array, n, m, in);

        for (int i = 0; i < m; i++) {
            array[n][i] = countEqualElementsOfColumn(array, i, n);
        }

        bubbleSort(array, n, m);
        outputArray(array, n, m);
        in.close();
    }

    private static int[] enterDimensions(Scanner in) {
        System.out.println("Введите количество строк массива n: ");
        int n = in.nextInt();
        System.out.println("Введите количество столбцов массива m: ");
        int m = in.nextInt();
        return new int[]{n, m};
    }

    private static void enterArray(int array[][], int n, int m, Scanner in) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = in.nextInt();
            }
        }
    }

    private static int countEqualElementsOfColumn(int array[][], int number, int n) {
        
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = array[i][number];
        }

        return Arrays.stream(column)
                .distinct()
                .map(x -> (int)Arrays.stream(column).filter(num -> num == x).count())
                .max()
                .orElse(1);
    }

    private static void bubbleSort(int array[][], int n, int m) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
                if (array[n][j] > array[n][j + 1]) {
                    swapColumns(array, n, j);
                }
            }
        }
    }

    private static void swapColumns(int array[][], int n, int j) {
        int temp;
        for (int i = 0; i < n + 1; i++) {
            temp = array[i][j];
            array[i][j] = array[i][j + 1];
            array[i][j + 1] = temp;
        }
    }

    private static void outputArray(int array[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
