package com.lesson_08;

import java.util.Random;

public class Linear_Probing {

    static class Item {

        private int data;

        public Item(int data) {
            this.data = data;
        }

        public int getKey() {
            return this.data;
        }
    }

    static class HashTable {
        private Item[] hashArray;
        private int arraySize;
        private Item nonItem;

        public HashTable(int size) {
            this.arraySize = size;
            hashArray = new Item[arraySize];
            nonItem = new Item(-1);
        }

        public void display() {
            for (int i = 0; i < arraySize; i++) {
                if (hashArray[i] != null) {
                    System.out.println(hashArray[i].getKey());
                } else {
                    System.out.println("***");
                }
            }
        }

        public int hashFunc(int key) {
            return key % arraySize;
        }

        public void insert(Item item) {
            int key = item.getKey();
            int hashVal = hashFunc(key);
            while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
                ++hashVal;
                hashVal %= arraySize;
            }
            hashArray[hashVal] = item;
        }

        public Item delete(int key) {
            int hashVal = hashFunc(key);
            while (hashArray[hashVal] != null) {
                if (hashArray[hashVal].getKey() == key) {
                    Item temp = hashArray[hashVal];
                    hashArray[hashVal] = nonItem;
                    return temp;
                }
                ++hashVal;
                hashVal %= arraySize;
            }
            return null;
        }

        public Item find(int key) {
            int hashVal = hashFunc(key);
            while (hashArray[hashVal] != null) {
                if (hashArray[hashVal].getKey() == key) {
                    return hashArray[hashVal];
                }
                ++hashVal;
                hashVal %= arraySize;
            }
            return null;
        }
    }

    public static void hashFunc2(int key, int size){
        System.out.println(key % size);
    }

    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hashTable = new HashTable(size);
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = random.nextInt(999);
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }

        hashTable.insert(new Item(999));
        hashTable.insert(new Item(203));

        hashTable.display();

        hashFunc2(999,66);
        System.out.println(hashTable.find(999).getKey());

        hashTable.delete(203);

    }
}
