package com.lesson_05;

import java.util.Arrays;

public class Lesson_05 {

    public static int factorial(int a){     //метод простой рекурсии (вычисление факториала)
        if(a == 1) return 1;
        return a*factorial(a-1);
    }

    public static int binarySearch(int[]array, int key){        //метод бинарного поиска с помощью циклов
        int low = 0;
        int high = array.length-1;
        int middle = 0;   //середина массива

        if(key < array[low] || key > array[high] || low > high){
            return -1;
        }

        while (low <= high){
            middle = (low + high)/2;
            if(array[middle] > key){   //если mid больше искомого элемента, значит искомый элемент находится в левой области
                high = middle - 1;
            }else if(array[middle] < key){  //если mid меньше искомого элемента, значит искомый элемент в правой части
                low = middle + 1;
            }else {
                return middle;
            }
        }return -1;
    }

    public static int recursionBinarySearch(int[]array,int key, int from, int to){
        if(from <= to){
            int middle = (from + to)/2;

            if(array[middle] > key){
                return recursionBinarySearch(array,key,from,middle-1);
            }else if(array[middle] < key){
                return recursionBinarySearch(array,key,middle+1,to);
            }return middle;
        }return -1;
    }

    public static void recursionMergeSort(int[] array, int lowerBound, int upperBound){
            if(lowerBound == upperBound) return;
            else {
                int mid = (lowerBound + upperBound)/2;
                recursionMergeSort(array,lowerBound,mid);
                recursionMergeSort(array,mid+1,upperBound);
                merge(array, lowerBound, mid+1, upperBound);
            }
        }

    public static void merge(int[] array, int low, int mid, int high) {
        // создаём временные подмассивы
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        // Копирование наших подмассивов во временные блоки
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        // Итераторы, содержащие текущий индекс временных подмассивов
        int leftIndex = 0;
        int rightIndex = 0;

        // Копирование из leftArray и rightArray обратно в массив
        for (int i = low; i < high + 1; i++) {
            // Если в R и L все еще есть нескопированные элементы, скопируем минимум два
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // Если все элементы были скопированы из rightArray, скопируем остальную часть leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                //Если все элементы были скопированы из leftArray, скопируем остальную часть rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));

        int [] array = {12,54,22,67,90,44,77};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array,77));
        System.out.println(recursionBinarySearch(array,67,0,6));
        recursionMergeSort(array,0,6);
        System.out.println(Arrays.toString(array));
    }
}
