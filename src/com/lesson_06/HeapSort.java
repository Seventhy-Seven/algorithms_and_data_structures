package com.lesson_06;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    private static int heapSize;

    public static void sort(int[] arr){
        buildHeap(arr);
        while (heapSize > 1){
            swap(arr,0,heapSize-1);
            heapSize--;
            heapfy(arr,0);
        }
    }

    private static void buildHeap(int[]arr){
        heapSize = arr.length;
        for (int i = arr.length/2; i >= 0 ; i--) {
            heapfy(arr,i);
        }
    }

    private static void heapfy(int[]arr, int i){
        int l = left(i);
        int r = right(i);
        int largest = i;

        if(l < heapSize && arr[i] < arr[l]){
            largest = l;
        }
        if(r < heapSize && arr[largest] < arr[r]){
            largest = r;
        }
        if(i != largest){
            swap(arr, i, largest);
            heapfy(arr,largest);

        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int right(int i){
        return 2*i + 2;
    }

    private static int left(int i){
        return 2*i + 1;
    }

    public static void main(String[] args) {

        int[]array;
        Random random = new Random();
        array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        HeapSort arraySorting = new HeapSort();

        arraySorting.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
