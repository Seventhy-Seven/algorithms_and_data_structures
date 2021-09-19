package com.lesson_02;

import java.util.Arrays;
import java.util.Random;

public class Lesson_02 {

    public static int linearSearch(int[]arr, int a){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) return i;
        }
        return -1;
    }

    public static int binarySearch(int[]arr, int a){
        int firstIndex = 0;
        int lastIndex = arr.length-1;

        while (firstIndex <= lastIndex){                     //условие прекращения цикла
            int middleIndex = (firstIndex + lastIndex)/2;
            if(arr[middleIndex] == a){                       //если средний элемент - искомый, то вернуть его индекс
                return middleIndex;
            }else if(arr[middleIndex] < a){                  //если средний элемент меньше, направляем индекс на mid+1, убирая первую часть из рассмотрения
                firstIndex = middleIndex + 1;
            }else if(arr[middleIndex] > a){                  //если средний элемент больше, направляем индекс на mid-1, убирая вторую часть из рассмотрения
                lastIndex = middleIndex - 1;
            }
        }return -1;
    }

    public static int bubbleSort(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return 0;
    }

    public static int sortSelection(int[]arr){
        for (int i = 0; i < arr.length; i++) {              // i - номер текущего шага
            int pos = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {      //цикл выбора наименьшего элемента
                if(arr[j] < min){
                    pos = j;                                //pos - индекс наименьшего элемента
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];                             //меняем местами наименьший с текущим
            arr[i] = min;
            
        }
        return 0;
    }

    public static void sortInsert(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >=0 && current < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }


    public static void main(String[] args) {

        int[] array = {34, 21, 56, 90, 77, 12};
        int[] arrayCopy;

        arrayCopy = Arrays.copyOf(array, array.length);  //копирование содержимого массива

        long startTime = System.nanoTime();      //старт временного отсчёта

        System.out.println("Адрес объекта: " + arrayCopy.toString());
        System.out.println("Содержимое массива: " + Arrays.toString(arrayCopy));
        System.out.println("Сравнение двух массивов: " + array.equals(arrayCopy));
        System.out.println("Сравнение через Arrays: " + Arrays.equals(array, arrayCopy));
        Arrays.sort(arrayCopy);
        System.out.println("Массив отсортирован" + arrayCopy);

        long endTime = System.nanoTime();        //конец временного отсчёта
        long duration = (endTime - startTime);   //вычисление затраченного времени на выполнение вышенаписанных методов
        System.out.println("Время выполнения вышенаписанных методов = " + duration + " миллисекунд");

        startTime = System.nanoTime();
        System.out.println(linearSearch(array,77));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Время работы алгоритма линейного поиска = " + duration + " миллисекунд");

        startTime = System.nanoTime();
        System.out.println(binarySearch(arrayCopy,21));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Время работы алгоритма двоичного поиска = " + duration + " миллисекунд");

        System.out.println();

        int [] arrayOfFourHundred;
        arrayOfFourHundred = new int[400];

        Random random = new Random();
        for (int i = 0; i < 400; i++) {
            arrayOfFourHundred[i] = random.nextInt(100);
        }

        System.out.println("Массив из 400 элементов: " + Arrays.toString(arrayOfFourHundred));
        System.out.println();

        startTime = System.nanoTime();
        Arrays.sort(arrayOfFourHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Отсортированный массив из 400 элементов: " + Arrays.toString(arrayOfFourHundred));
        System.out.println("Время работы алгоритма Arrays.sort() = " + duration + " миллисекунд");
        System.out.println();

        startTime = System.nanoTime();
        bubbleSort(arrayOfFourHundred);
        endTime = System.nanoTime();
        duration = endTime-startTime;

        System.out.println("Остортированный массив из 400 элементов методом bubbleSort: " + Arrays.toString(arrayOfFourHundred));
        System.out.println("Время работы алгориитма bubbleSort = " + duration + " миллисекунд");
        System.out.println();

        startTime = System.nanoTime();
        sortSelection(arrayOfFourHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Остортированный массив из 400 элементов методом выбора: " + Arrays.toString(arrayOfFourHundred));
        System.out.println("Время работы алгориитма сортировки выбором = " + duration + " миллисекунд");
        System.out.println();

        startTime = System.nanoTime();
        sortInsert(arrayOfFourHundred);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        System.out.println("Остортированный массив из 400 элементов методом вставки: " + Arrays.toString(arrayOfFourHundred));
        System.out.println("Время работы алгориитма сортировки вставки = " + duration + " миллисекунд");
    }
}
