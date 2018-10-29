import java.util.Scanner;

class Labs {
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
        }
    }

    boolean isValid(int ch) {
        return !(ch < '1' | ch > '7' & ch != 'q');
    }

    void Lab5() {
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

    void Lab6() {
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
        for(int i =1;i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                sum+=Math.abs(array[i][j]);
            }
        }

        System.out.println("Сумма модулей элементов, ниже главной диагонали равна " + sum);


    }

    void Lab7() {
        System.out.println("Laboratory work №7. Strings");

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