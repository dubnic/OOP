import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Labs {
    static Scanner input = new Scanner(System.in);

    void helpon(int what) {
        switch (what) {
            case '1':
                System.out.println("Laboratory work №1. ");
                System.out.println("Does not exist on Java");
                break;
            case '2':
                System.out.println("Laboratory work №2. Branching of computing processes");
                System.out.println("Does not exist on Java");
                break;
            case '3':
                System.out.println("Laboratory work №3. Looping");
                System.out.println("Does not exist on Java");
                break;
            case '4':
                System.out.println("Laboratory work №4. The simplest classes");
                System.out.println("Does not exist on Java");
                break;
            case '5':
                Lab5();
                break;
            case '6':
                Lab6();
                break;
            case '7':
                Lab7();
                break;
            case '8':
                Lab8();
                break;
        }
    }

    boolean isValid(int ch) {
        return !(ch < '1' | ch > '9' & ch != 'q');
    }

    private void Lab5() {
        System.out.println("Laboratory work №5. One-dimensional arrays");

        int firstPositiveNumber = -1, secondPositiveNumber = -1;
        int j = 0, k = 0, f = 0, sum = 0, buf;
        int maxModulo = 0;

        System.out.print("Enter size of array: ");

        Scanner input = new Scanner(System.in);

        int arraySize = input.nextInt();
        int array[] = new int[arraySize];

        System.out.println("Введите минимум интервала заполнения массива:  ");
        int min = input.nextInt();
        System.out.println("Введите максимум интервала заполнения массива:  ");
        int max = input.nextInt();

        for (int i = 0; i < array.length; i++) {

            array[i] = (int) (Math.random() * (max - min)) + min; //заполняем массив случайными числами

            System.out.print(" " + array[i]); //выводим в консоль содержимое массива

            if (Math.abs(array[i]) > Math.abs(maxModulo)) maxModulo = array[i]; //находим максимальный по модулю элемент

            if (array[i] > 0) {
                if (firstPositiveNumber < 0) {
                    firstPositiveNumber = array[i]; //находим первый положительный элемент
                    j = i;
                    f = j;//и его индекс
                } else if (secondPositiveNumber < 0) {
                    secondPositiveNumber = array[i]; // находим второй положительный массив
                    k = i; //и его индекс
                }
            }

            for (; j + 1 < k; j++)
                sum += array[j + 1]; //находим сумму элементов между первым и вторым положительными числами

            if (array[i] == 0) { //отправляем нулевые элементы в конец массива (не работает)
                buf = array[i];
                for (int n = 0; n < array.length - 1; n++) array[i] = array[i + 1]; //что-то не так в условии
                array[array.length - 1] = buf;
            }

        }

        System.out.println("\nМаксимальный по модулю элемент: " + maxModulo);
        System.out.println("Первое положительное число - " + firstPositiveNumber + ", его номер в массиве " + f);
        System.out.println("Второе положительное число - " + secondPositiveNumber + ", его номер в массиве " + k);

        if (sum == 0) {
            System.out.print(firstPositiveNumber + " и " + secondPositiveNumber + " находятся рядом друг с другом - ");
            System.out.println(" их номера в массиве - " + f + " " + k + " соответственно, элементов между ними нет");
        } else
            System.out.println("Сумма элементов между " + firstPositiveNumber + " и " + secondPositiveNumber + " равна " + sum);


    }

    private void Lab6() {
        System.out.println("Laboratory work №6. Two-dimensional arrays.");

        int sum = 0;
        int array[][] = new int[10][10];

        Scanner input = new Scanner(System.in);
        System.out.println("Введите минимум интервала заполнения массива:  ");
        int min = input.nextInt();
        System.out.println("Введите максимум интервала заполнения массива:  ");
        int max = input.nextInt();

        System.out.println("Исходная матрица: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * (max - min)) + min; //заполняем массив случайными числами
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //сглаживание матрицы
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if (i == 0) { //сглаживание первой (нулевой) строки
                    if (j == 0) array[i][j] = (array[i][j + 1] + array[i + 1][j + 1] + array[i + 1][j]) / 3;
                    else if (j == array.length - 1)
                        array[i][j] = (array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j]) / 3;
                    else for (j = 1; j < array.length - 1; j++) {
                            array[i][j] = (array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j] + array[i + 1][j + 1] + array[i][j + 1]) / 5;
                            System.out.print(array[i][j] + " ");
                        }
                }

                if (j == 0 & i > 0 & i < array.length - 1) { //сглаживание первого (нулевого) столбца
                    array[i][j] = (array[i - 1][j] + array[i - 1][j + 1] + array[i][j + 1] + array[i + 1][j + 1] + array[i + 1][j]) / 5;
                }

                if (i > 0 & i < array.length - 1 & j > 0 & j < array.length - 1) //сглаживание квадрата "без рамки"
                    array[i][j] = (array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1] +
                            array[i][j + 1] + array[i][j - 1] +
                            array[i + 1][j + 1] + array[i + 1][j] + array[i + 1][j - 1]) / 8;

                if (j == array.length - 1 & i > 0 & i < array.length - 1) //сглаживание последнего столбца
                    array[i][j] = (array[i - 1][j] + array[i - 1][j - 1] + array[i][j - 1] + array[i + 1][j - 1] + array[i + 1][j]) / 5;

                if (i == array.length - 1) { //сглаживание последней строки
                    if (j == 0) array[i][j] = (array[i - 1][j] + array[i - 1][j + 1] + array[i][j + 1]) / 3;
                    else if (j == array.length - 1)
                        array[i][j] = (array[i - 1][j] + array[i - 1][j - 1] + array[i][j - 1]) / 3;
                    else for (j = 1; j < array.length - 1; j++) {
                            array[i][j] = (array[i][j - 1] + array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1] + array[i][j + 1]) / 5;
                            System.out.print(array[i][j] + " ");
                        }
                }

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //нахождение суммы модулей элементов, находящихся ниже главной диагонали
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += Math.abs(array[i][j]);
            }
        }

        System.out.println("Сумма модулей элементов, ниже главной диагонали равна " + sum);


    }

    private void Lab7() {
        System.out.println("Laboratory work №7. Strings");
        String s;
        int k = 0;

        System.out.println("Введите количество слов в искомом предложении: ");

        int words = input.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader("Введение.txt"))) {
            while ((s = br.readLine()) != null) {
                for (String str : s.split("\\Q.\\E ")) { //делим содержимое файла на предложения
                    for (String word : str.split(" ")) k++;//делим предложение на слова
                    if (k == words) System.out.println(str);
                    k = 0;
                }
            }
        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " + exc);
        }
    }

    private void Lab8() {
        RealMatrix yyy = new RealMatrix(5);
        yyy.setFillMatrixMannually();
        yyy.inverseMatrix();
    }
}

class LabsClass {
    public static void main(String[] args)
            throws java.io.IOException {
        char choice, ignore;
        Labs lbsobj = new Labs();

        for (; ; ) {
            do {
                System.out.print("\nEnter the number of the laboratory work: ");

                choice = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (!lbsobj.isValid(choice));

            if (choice == 'q') break;

            lbsobj.helpon(choice);
        }
    }
}

class RealMatrix {
    private int[][] firstRealMatrix;
    private int[][] resultMatrix;
    private int[][] identityMatrix;


    RealMatrix(int size) {
        this.firstRealMatrix = new int[size][size];
        this.resultMatrix = new int[size][size];
        this.identityMatrix = new int[size][size];

        for (int i = 0; i < identityMatrix.length; i++) {
            for (int j = 0; j < identityMatrix.length; j++) {
                if (i == j) identityMatrix[i][j] = 1;
                else identityMatrix[i][j] = 0;
            }
        }

    }

    void setFillMatrixMannually() {
        for (int i = 0; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix.length; j++) {
                firstRealMatrix[i][j] = Labs.input.nextInt();
            }
        }
    }

    int[][] getFirstRealMatrix() {
        return firstRealMatrix;
    }

    int[][] addMatrix(int[][] secondRealMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[i][j] = firstRealMatrix[i][j] + secondRealMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    int[][] addMatrix(int num) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[i][j] = firstRealMatrix[i][j] + num;
            }
        }
        return resultMatrix;
    }

    int[][] combinedAddMatrix(int[][] secondRealMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                firstRealMatrix[i][j] = +secondRealMatrix[i][j];
            }
        }
        return firstRealMatrix;
    }

    int[][] subMatrix(int[][] secondRealMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[i][j] = firstRealMatrix[i][j] - secondRealMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    int[][] subMatrix(int num) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[i][j] = firstRealMatrix[i][j] - num;
            }
        }
        return resultMatrix;
    }

    int[][] combinedSubMatrix(int[][] secondRealMatrix) {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                firstRealMatrix[i][j] -= secondRealMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    boolean equalMatrix(int[][] secondRealMatrix) {
        return Arrays.equals(firstRealMatrix, secondRealMatrix);
    }

    int[][] matrixTransposition() {
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix.length; j++) {
                resultMatrix[j][i] = firstRealMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    int[][] inverseMatrix() {

        for (int i = 0, j = 0; j < firstRealMatrix[0].length; j++) {
            firstRealMatrix[i][j] /= firstRealMatrix[i][i]; //первую строку делим элемент [0][0]
            identityMatrix[i][j] /= firstRealMatrix[i][i];
        }

        for (int i = 1; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix[0].length; j++) {
                firstRealMatrix[i][j] -= firstRealMatrix[i][0] * firstRealMatrix[0][j];
                identityMatrix[i][j] -= firstRealMatrix[i][0] * identityMatrix[0][j];
            }
        }

        for (int i = 1, j = 0; j < firstRealMatrix[0].length; j++) {
            firstRealMatrix[i][j] /= firstRealMatrix[i][i]; //первую строку делим элемент [0][0]
            identityMatrix[i][j] /= firstRealMatrix[i][i];
        }

        for (int i = 0; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix[0].length; j++) {
                if (i == 1) continue;
                firstRealMatrix[i][j] -= firstRealMatrix[i][1] * firstRealMatrix[1][j];
                identityMatrix[i][j] -= firstRealMatrix[i][1] * identityMatrix[1][j];
            }
        }

        for (int i = 2, j = 0; j < firstRealMatrix[0].length; j++) {
            firstRealMatrix[i][j] /= firstRealMatrix[i][i]; //первую строку делим элемент [0][0]
            identityMatrix[i][j] /= firstRealMatrix[i][i];
        }

        for (int i = 0; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix[0].length; j++) {
                if (i == 2) continue;
                firstRealMatrix[i][j] -= firstRealMatrix[i][2] * firstRealMatrix[2][j];
                identityMatrix[i][j] -= firstRealMatrix[i][2] * identityMatrix[2][j];
            }
        }

        for (int i = 3, j = 0; j < firstRealMatrix[0].length; j++) {
            firstRealMatrix[i][j] /= firstRealMatrix[i][i]; //первую строку делим элемент [0][0]
            identityMatrix[i][j] /= firstRealMatrix[i][i];
        }

        for (int i = 0; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix[0].length; j++) {
                if (i == 3) continue;
                firstRealMatrix[i][j] -= firstRealMatrix[i][3] * firstRealMatrix[3][j];
                identityMatrix[i][j] -= firstRealMatrix[i][3] * identityMatrix[3][j];
            }
        }

        for (int i = 4, j = 0; j < firstRealMatrix[0].length; j++) {
            firstRealMatrix[i][j] /= firstRealMatrix[i][i]; //первую строку делим элемент [0][0]
            identityMatrix[i][j] /= firstRealMatrix[i][i];
        }

        for (int i = 0; i < firstRealMatrix.length; i++) {
            for (int j = 0; j < firstRealMatrix[0].length; j++) {
                if (i == 4) continue;
                firstRealMatrix[i][j] -= firstRealMatrix[i][4] * firstRealMatrix[4][j];
                identityMatrix[i][j] -= firstRealMatrix[i][4] * identityMatrix[4][j];
            }
        }

        for (int[] kek : identityMatrix) {
            for (int lol : kek) {
                System.out.print(lol + " ");
            }
            System.out.println();
        }
        return identityMatrix;
    }

    int indexAccess(int size) {
        System.out.print("Enter line number: ");
        int lineNumber = Labs.input.nextInt();
        System.out.print("Enter column number: ");
        int columnNumber = Labs.input.nextInt();

        return firstRealMatrix[lineNumber][columnNumber];
    }
}