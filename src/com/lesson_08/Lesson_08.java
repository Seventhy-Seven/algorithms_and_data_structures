package com.lesson_08;

public class Lesson_08 {

    public static void hash(char x){
        System.out.println((x >> 15)^x);
    }

    public static void hashFunction(char key, int f){
        System.out.println(key % f);
    }

    public static void main(String[] args) {
        String hashString = "Test";
        char hashChar = 't';
        System.out.println(hashString.hashCode());
        hash(hashChar);
        hashFunction(hashChar,10);
    }
}
