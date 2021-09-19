package com.lesson_01;

public class Main {
    
    // метод линейного поиска простым перебором элементов входного массива, временная сложность равна O(n)

    public static int methodSearch(int arr[], int a){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Класс с данными в примитивных типах

        class Primitive {
            final int a;
            final char b;
            final float c;
            final double d;
            final short e;
            final boolean f;
            final long h;

            public Primitive(int a, char b, float c, double d, short e, boolean f, long h) {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d = d;
                this.e = e;
                this.f = f;
                this.h = h;
            }

            public void showPrimitiveData() {
                System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + h);
            }
        }

        Primitive pr = new Primitive(1, 'A', 3.14f, 2.71, (short) 33, true, 123456789);
        pr.showPrimitiveData();


        // Класс с данными в ссылочных типах

        class Reference {
            final Integer integer;
            final Character character;
            final Float fl;
            final Double db;
            final Short sh;
            final Boolean bool;

            public Reference(Integer integer, Character character, Float fl, Double db, Short sh, Boolean bool) {
                this.integer = integer;
                this.character = character;
                this.fl = fl;
                this.db = db;
                this.sh = sh;
                this.bool = bool;
            }

            public void showReferenceData() {
                System.out.println(integer + " " + character + " " + fl + " " + db + " " + sh + " " + bool + " ");
            }
        }

        Reference ref = new Reference(6, 'F', 3.14f, 2.71, (short) 45, false);
        ref.showReferenceData();


        // внутренний класс с собственными данными и методом вывода
        class TV {
            final int channelNumber;
            final int soundVolume;
            final boolean isOn;

            public TV(int channelNumber, int soundVolume, boolean isOn) {
                this.channelNumber = channelNumber;
                this.soundVolume = soundVolume;
                this.isOn = isOn;
            }

            public void showData() {
                System.out.println(channelNumber + " " + soundVolume + " " + isOn);
            }
        }

        TV television = new TV(3, 7, true);
        television.showData();

        int [] array = {43,54,76,12,5,1,875};
        int myVar = 76;

        System.out.println(methodSearch(array,myVar));
    }
}