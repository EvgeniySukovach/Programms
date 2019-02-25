package Homework_1;

import java.text.DecimalFormat;

public class Homework {

    public static void main(String[] args) {

        Homework homework_1 = new Homework();

        System.out.println("Conditions: ");

        //Task_1: Если а – четное посчитать а*б, иначе а+б
        homework_1.task_1(6, 3);

        //Task_2: Определить какой четверти принадлежит точка с координатами (х,у)
        homework_1.task_2(-2, -3);

        //Task_3: Найти суммы только положительных из трех чисел+
        homework_1.task_3(-2, -3, 4);

        //Task_4: Посчитать выражение макс(а*б*с, а+б+с)+3
        homework_1.task_4(2, 3, 4);

        //Task_5:определения оценки студента по его рейтингу
        homework_1.task_5(33);

        System.out.println("Cycles: ");

        //Циклы_1: Найти сумму четных чисел и их количество в диапазоне от 1 до 99
        homework_1.cycle_1();

        //Циклы_2: Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1)
        homework_1.cycle_2(1);

        //Циклы_3: Найти корень натурального числа с точностью до целого
        homework_1.cycle_3(42);

        //Циклы_4: Вычислить факториал числа n. n! = 1*2*…*n-1*n;!
        homework_1.cycle_4(6);

        //Циклы_5: Посчитать сумму цифр заданного числа
        homework_1.cycle_5(7);

        //Циклы_6: Вывести число, которое является зеркальным отображением последовательности цифр заданного числа
        homework_1.cycle_6(56789);

        System.out.println("Arrays: ");
        // Инициализируем тестовый массив
        int[] arr = {25, 10, -66, 99, 19, 8, 34, 9, 7};

        //Массивы_1:Найти минимальный элемент массива
        homework_1.array_1(arr);

        //Массивы_2:Найти максимальный элемент массива
        homework_1.array_2(arr);

        //Массивы_3: Найти индекс минимального элемента массива
        homework_1.array_3(arr);

        //Массивы_4: Найти индекс максимального элемента массива
        homework_1.array_4(arr);

        //Массивы_5: Посчитать сумму элементов массива с нечетными индексами
        homework_1.array_5(arr);

        //Массивы_6: Сделать реверс массива (массив в обратном направлении)
        homework_1.array_6(arr);

        //Массивы_7: Посчитать количество нечетных элементов массива
        homework_1.array_7(arr);


        //Массивы_8: Поменять местами первую и вторую половину массива, например, для массива 1 2 3 4, результат 3 4 1 2
        homework_1.array_8(arr);

        //Массивы_9: Bubble sort
        homework_1.array_9(arr);

        //Features_2:
        homework_1.feature_2(2, 3, 5, 9);

    }

    // МЕТОДЫ РЕШЕНИЯ ЗАДАЧ
    // Conditions:

    private void task_1(int a, int b) {
        System.out.print("Solution for Task_1: Если а – четное посчитать а*б, иначе а+б ");
        if (a % 2 == 0) System.out.println( a * b);
        else System.out.println( a + b);
    }

    private void task_2(int x, int y) {
        System.out.print("Solution for Task_2: Определить какой четверти принадлежит точка с координатами (х,у)");
        if (x>0){
            if (y>0) System.out.println("1st quarter");
            else System.out.println("4th quarter");
    }   else {
            if (y>0) System.out.println("2nd quarter");
            else System.out.println("3rd quarter");
        }
    }

    private void task_3(int a, int b, int c) {
        System.out.print("Solution for Task_3: Найти суммы только положительных из трех чисел ");
        if (a<0) a = 0;
        if (b<0) b = 0;
        if (c<0) c = 0;
        if (a<0 & b<0 & c<0){
            System.out.println("All numbers are not positive");
        }
        else System.out.println(a+b+c);
    }

    private void task_4(int a, int b, int c){
        System.out.print("Solution for Task_4: Посчитать выражение макс(а*б*с, а+б+с)+3");
        int x = a*b*c;
        int y = a+b+c;
        if (x > y) System.out.println(x +3);
        else System.out.println(y + 3);
    }

    private void task_5(int rating){
        System.out.print("Solution for Task_5: Написать программу определения оценки студента по его рейтингу,\n" +
                " на основе правил");
        if (rating >= 0 && rating <20) System.out.println("F");
        if (rating >= 20 & rating <40) System.out.println("D");
        if (rating >= 40 & rating <60) System.out.println("C");
        if (rating >= 60 & rating <80) System.out.println("B");
        if (rating >= 80 & rating <100) System.out.println("A");
        System.out.println();
    }

    // Циклы:
    //Найти сумму четных чисел и их количество в диапазоне от 1 до 99
    private void cycle_1() {
        System.out.println("Solution for Task cycle_1: Найти сумму четных чисел и их количество в диапазоне от 1 до 99");

        int count = 0;
        int sum = 0;
        for(int i=1; i<=99; i++){
            if (i%2==0) {
                count++;
                sum += i;
            }
        }
        System.out.println("The sum of even numbers is "+ sum);
        System.out.println("The total number of even data is " + count);
        System.out.println();
    }

    //Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1)
    private void cycle_2(int number) {
        System.out.println("Solution for Task cycle_2: Проверить простое ли число? (число называется простым, если оно делится только само на себя и на 1");

        int count = 0;
        for (int i =1; i<=number; i++){
            if (number%i==0) count++;
        }
        if (count == 2 || count == 1 ) System.out.println(number + " is a simple number");
        else System.out.println(number + " is not a simple number");
        System.out.println();
    }

    //Найти корень натурального числа с точностью до целого
    private void cycle_3(int number) {
        System.out.println("Solution for Task cycle_3: Найти корень натурального числа с точностью до целого");
        for (int i = 1; i <= number; i++) {
            if ((i*i <= number) & ((i+1)*(i+1)>number)){
                if ((number - i*i )< ((i+1)*(i+1)- number))
                    System.out.println("The square root of number" + number + " is " + i);
                else System.out.println("The square root of number" + number + " is " + (i+1));
            }
        }
        System.out.println();
    }

    //Вычислить факториал числа n. n! = 1*2*…*n-1*n;!
    private void cycle_4(int number) {
        System.out.println("Solution for Task cycle_4: Вычислить факториал числа n. n! = 1*2*…*n-1*n;!");
      int factorial = 1;
        for (int i = 1; i <= number; i++) {
         factorial *= i;
        }
        System.out.println("Factorial from " + number + " is " + factorial);
        System.out.println();
    }

    //Посчитать сумму цифр заданного числа
    private void cycle_5(int number) {
        System.out.println("Solution for Task cycle_5: Посчитать сумму цифр заданного числа");
        int sum =0;
        for(int i= 0; i < number; i++){
            sum = sum + i;
        }
        System.out.println("The sum of digits of number " +number+" is " + sum);
        System.out.println();
    }

    //Вывести число, которое является зеркальным отображением последовательности цифр заданного числа
    private void cycle_6(int number) {
        System.out.println("Solution for Task cycle_6: Вывести число, которое является зеркальным отображением последовательности цифр заданного числа");
        System.out.print("The mirror number is ");
        while (number !=0) {
            System.out.print(number%10);
            number /=10;
        }
        System.out.println();
        System.out.println();
    }

   /* Одномерные массивы

    Найти индекс минимального элемента массива
    Найти индекс максимального элемента массива
    Посчитать сумму элементов массива с нечетными индексами
    Сделать реверс массива (массив в обратном направлении)
    Посчитать количество нечетных элементов массива
    Поменять местами первую и вторую половину массива, например, для массива 1 2 3 4, результат 3 4 1 2
    Отсортировать массив (пузырьком (Bubble), выбором (Select), вставками (Insert))
    Отсортировать массив (Quick, Merge, Shell, Heap)

   тестовый массив:  int[] arr = {5, 10, 6, 19, 8, 3, 9, 7};
    */

    //Найти минимальный элемент массива
   private void array_1(int[] arr){
       System.out.println("Solution for Task Arrays_1: Найти минимальный элемент массива");
       int min = arr[0];
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] < min){
               min = arr[i];
           }
       }
       System.out.println(min);
       System.out.println();
   }

    //Найти максимальный элемент массива
    private void array_2(int[] arr){
        System.out.println("Solution for Task Arrays_2: Найти максимальный элемент массива");
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]> max){
                max = arr[i];
            }
        }
        System.out.println(max);
        System.out.println();
    }

    //Найти индекс минимального элемента массива
    private void array_3(int[] arr){
        System.out.println("Solution for Task Arrays_3: Найти индекс минимального элемента массива");
        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]< min){
                min = arr[i];
                index = i;
            }
        }
        System.out.println(index);
        System.out.println();
    }

    //Найти индекс максимального элемента массива
    private void array_4(int[] arr){
        System.out.println("Solution for Task Arrays_4: Найти индекс максимального элемента массива");
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        System.out.println(index);
        System.out.println();
    }

    //Посчитать сумму элементов массива с нечетными индексами
    private void array_5(int[] arr){
        System.out.println("Solution for Task Arrays_5: Посчитать сумму элементов массива с нечетными индексами");
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(i%2==1){
                sum += arr[i];
            }
        }
        System.out.println(sum);
        System.out.println();
    }

    //Сделать реверс массива (массив в обратном направлении)
    private void array_6(int[] arr){
        System.out.println("Solution for Task Arrays_6: Сделать реверс массива (массив в обратном направлении)");
        int [] revers = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            revers[arr.length-1 - i] = arr[i];
        }
        for(int x: revers) System.out.print(x + " ");
        System.out.println();
        System.out.println();
    }

    //Посчитать количество нечетных элементов массива
    private void array_7(int[] arr) {
        System.out.println("Solution for Task Arrays_7: Посчитать количество нечетных элементов массива");
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(i%2==1){
                count ++;
            }
        }
        System.out.println(count);
        System.out.println();
    }

    //Поменять местами первую и вторую половину массива, например, для массива 1 2 3 4, результат 3 4 1 2
    private void array_8(int[] arr) {
        System.out.println("Solution for Task Arrays_8: Поменять местами первую и вторую половину массива, например, для массива 1 2 3 4, результат 3 4 1 2");
        int[] arr2 = new int[arr.length];
        for (int i = arr.length/2; i < arr.length; i++) {
            if(arr.length%2==1)
            arr2[(arr.length/2+i+1)-arr.length] = arr[i];
            else  arr2[(arr.length/2+i)-arr.length] = arr[i];
        }
        for (int i = 0; i < arr.length/2; i++) {
            if(arr.length%2==1)
                arr2[(arr.length/2+i+1)] = arr[i];
            else arr2[arr.length/2 + i] = arr[i];
        }
        for(int x: arr2) System.out.print(x + ", ");
        System.out.println();
        System.out.println();
    }

    //Bubble sort
    private void array_9(int[] arr){
        System.out.println("Solution for Task Arrays_9: Bubble sort");
        int temp;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            }
        }
        for(int x=0; x< arr.length; x++) System.out.print(arr[x] + ", ");
        System.out.println();
    }

        //Features
    private void feature_1(){
        System.out.println("Solution for Feature 1: ");
    }

    private void feature_2(int x1, int y1,int x2, int y2){
        System.out.println("Solution for Feature 2:  ");
        int sideX = x1 - x2;
        int sideY = y1 - y2;
        int sideZ2 = sideX*sideX + sideY*sideY;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(Math.sqrt(sideZ2)));
    }
}

