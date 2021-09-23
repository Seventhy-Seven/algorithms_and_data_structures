package com.lesson_03;

import java.util.*;

public class Lesson_03 {

    public static <E> void main(String[] args) {

        Integer[] array = {34, 21, 56, 90, 77, 12};
        System.out.println("имеем целочисленный массив array " + Arrays.toString(array));

        long startTime = System.nanoTime();

        List<Integer>list = new LinkedList<>(List.of(array));
        System.out.println("преобразовали массив в LinkedList: " + list);
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(array));
        System.out.println("преобразовали массив в ArrayList: " + arrayList);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Время выполнения вышенаписанных методов = " + duration + " миллисекунд");
        System.out.println();

        startTime = System.nanoTime();

        list.add(1,44);
        System.out.println("новый LinkedList с добавленным элементом : " + list);
        list.remove(0);
        System.out.println("новый LinkedList с удалённым элементом: " + list);
        System.out.println("элемент LinkedList'a с индексом 4: " + list.get(4));
        System.out.println();

        arrayList.add(2,99);
        System.out.println("новый ArrayList с добавленным элементом: " + arrayList);
        arrayList.remove(5);
        System.out.println("новый ArrayList с удалённым элементом: " + arrayList);
        System.out.println("элемент ArrayList'a с индексом 3: " + arrayList.get(3));

        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Время выполнения вышенаписанных методов = " + duration + " миллисекунд");
        System.out.println();


        class ListElement<T>{
            ListElement next;    // указатель на следующий элемент
            T data;            // какие-либо данные
        }

        class List<T> implements Iterator{
            private ListElement head;    //указатель на первый элемент
            private  ListElement tail;   //указтель на последний элемент

            void addFront(T data){      //метод добавления нового элемента спереди
                ListElement listElement = new ListElement();    //создаём новый элемент
                listElement.data =  data;        //инициализация данных
                                                //указатель на следующий элемент автоматически
                if(head == null){               // если список пуст
                    head = listElement;         //список состоит из одного элемента
                    tail = listElement;
                }else {
                    listElement.next = head;    //иначе новый элемент ссылается на бывший
                    head = listElement;         //указатель на первый
                }
            }

            void addBack(T data){     //добавление элемента в конец списка
                ListElement listElement = new ListElement();
                listElement.data = data;
                if(tail == null){                   //если список пуст
                    head = listElement;             //указываем ссылки начала и конца на новый элемент, т.е.список состоит из одного элемента
                    tail = listElement;
                }else{                              //иначе старый последний элемент теперь ссылается на новый
                    tail.next = listElement;        //а в указатель на последний элемент записываем адрес нового элемента
                    tail = listElement;
                }
            }

            void print(T data){                     //метод вывода
                ListElement listElement = head;     //получаем ссылку на первый элемент
                while (listElement != null){        //пока элемент существует
                    System.out.println(listElement.data + " ");    //печатаем его данные
                    listElement = listElement.next;                //и переключаемся на следующий
                }
            }

            void delete(T data){                  //метод удаления
                if(head == null)                  //если список пуст - ничего не делаем
                    return;
                if(head == tail){                 //если список состоит из одного элемента
                    head = null;                  //очищаем указатели начала и конца
                    tail = null;
                    return;
                }

                if(head.data == data){           //если первый элемент тот, что нам нужен
                    head = head.next;            //переключаем указатель начала на второй элемент
                    return;
                }

                ListElement listElement = head;          //иначе начинаем искать
                while (listElement.next != null){        //пока следующий элемент существует
                    if(listElement.next.data == data){   //проверяем следующий элемент
                        if(tail == listElement.data){    //если он последний
                            tail = listElement;           //переключаем указатель последнего элемента на текущий
                        }
                        listElement.next = listElement.next.next;     //найденный элемент удаляем и выходим
                        return;
                    }
                    listElement = listElement.next;        //иначе идём дальше
                }
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        }

        //реализация всех методов

        List list1 = new List();

        startTime = System.nanoTime();

        list1.addFront("слово");
        list1.addBack(33);
        list1.addFront(3.14);
        list1.addBack('A');
        list1.print(list1);
        System.out.println();
        list1.delete(33);
        list1.print(list1);
        System.out.println();
        System.out.println(list1.hasNext());
        System.out.println();
        System.out.println(list1.next());
        System.out.println();

        endTime = System.nanoTime();
        duration = (endTime-startTime);
        System.out.println("Время выполнения вышенаписанных методов = " + duration + " миллисекунд");


        LinkedList<E> list3 = new LinkedList<E>();

        startTime = System.nanoTime();

        list3.add((E) "новое слово");
        list3.addFirst((E) "слово");
        list3.addLast((E)"последнее слово");
        System.out.println(list3);
        System.out.println();
        System.out.println(list3.get(2));
        System.out.println();
        list3.push((E)"внезапное слово");
        System.out.println(list3);
        System.out.println();

        endTime = System.nanoTime();
        duration = (endTime-startTime);
        System.out.println("Время выполнения стандартных методов LinkedList = " + duration + " миллисекунд");
    }
}
