package com.datastructures.linkedlist;

import java.util.Objects;

public class DetectLoop {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(7);
        linkedList.add(16);
        linkedList.add(9);

        System.out.println(hasLoop(linkedList));
        linkedList.head.next.next.next.next = linkedList.head.next;
        System.out.println(hasLoop(linkedList));
    }

    public static <T> boolean hasLoop(LinkedList<T> linkedList){
        Node<T> slow_ptr = linkedList.head;
        Node<T> fast_ptr = linkedList.head.next;
        while((Objects.nonNull(fast_ptr) && Objects.nonNull(fast_ptr.next))){
            if(slow_ptr==fast_ptr)
                return true;
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return false;
    }
}
