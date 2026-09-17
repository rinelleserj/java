// Найти число локальных минимумов. (Соседями элемента матрицы
// назовем элементы, имеющие с ним общую сторону или угол. Элемент матрицы
// называется локальным минимумом, если он строго меньше всех своих
// соседей.)

import java.util.Scanner;
import java.util.Random;

public class Task21 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] dimensions = enterDimensions(in);
        int n = dimensions[0];
        int m = dimensions[1];
        int array[][] = new int[n][m];
        fillRandomValues(array, n, m);
        int answer = countLocalMinima(array, n, m);

        System.out.println("Массив: ");
        outputArray(array, n, m);
        System.out.print("Количество локальных минимумов равно " + answer);
        in.close();
    }

    private static int[] enterDimensions(Scanner in) {
        System.out.println("Введите количество строк массива n: ");
        int n = in.nextInt();
        System.out.println("Введите количество столбцов массива m: ");
        int m = in.nextInt();
        return new int[]{n, m};
    }

    private static void fillRandomValues(int array[][], int n, int m) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = random.nextInt(101) - 50;
            }
        }
    }

    private static int countLocalMinima(int array[][], int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (localMinima(array, i, j, n, m)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean localMinima(int array[][], int i, int j, int n, int m) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if ((x != 0 || y != 0) && (i + x >= 0 && j + y >= 0 && i + x < n && j + y < m)) {
                    if (array[i][j] >= array[i + x][j + y]) {
                        return false;
                    }
                }
            }
        }
        return true;
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
