package com.lesson_04;

import java.util.*;
import java.util.Queue;

public class Lesson_04 {


    public static void main(String[] args) {

       Stack<Object>stack = new Stack();
       stack.push("первый");
       stack.push("второй");
       stack.push("третий");
       System.out.println(stack);
       System.out.println();

       stack.pop();
       System.out.println(stack);
       System.out.println();

       System.out.println(stack.peek());
       System.out.println(stack.isEmpty());
       System.out.println(stack.search("второй"));

       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(1);
       queue.add(2);
       queue.add(3);

       System.out.println(queue);
       System.out.println();

       queue.offer(4);
       queue.offer(5);

       System.out.println(queue);
       System.out.println();
       System.out.println(queue.remove());
       System.out.println(queue.poll());
       System.out.println();
       System.out.println(queue);
       System.out.println();
       System.out.println(queue.element());
       System.out.println();
       System.out.println(queue.peek());
       System.out.println();

       Deque<Character>deque = new LinkedList<>();
       deque.addFirst('A');
       deque.add('B');
       deque.addLast('C');
       System.out.println(deque);
       System.out.println();
       System.out.println(deque.getFirst() + " " + deque.getLast());
       System.out.println(deque.offerFirst('a') + " " + deque);
       System.out.println(deque.offerLast('b') + " " + deque);
       System.out.println(deque.removeFirst() + " " + deque);
       System.out.println(deque.removeLast() + " " + deque);
       System.out.println(deque.removeFirstOccurrence('A') + " " + deque);
       System.out.println(deque.removeLastOccurrence('C') + " " + deque);
       System.out.println();

       PriorityQueue<Integer>priorityQueue = new PriorityQueue<>();
       priorityQueue.add(11);
       priorityQueue.add(22);
       priorityQueue.add(33);

       while (!priorityQueue.isEmpty()){
          System.out.println(priorityQueue.remove());
       }



    }
}
