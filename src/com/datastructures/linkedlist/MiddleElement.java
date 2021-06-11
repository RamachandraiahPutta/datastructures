package com.datastructures.linkedlist;

import java.util.Objects;

public class MiddleElement {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        System.out.println(findMiddleElement(numbers));
    }

    public static <T> T findMiddleElement(LinkedList<T> linkedList){
        Node<T> slow_ptr = linkedList.head;
        Node<T> fast_ptr = linkedList.head;
        while(Objects.nonNull(fast_ptr) && Objects.nonNull(fast_ptr.next) ){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr.data;
    }
}
