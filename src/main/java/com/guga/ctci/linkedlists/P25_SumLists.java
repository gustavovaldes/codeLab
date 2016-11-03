package com.guga.ctci.linkedlists;

/**
 * Created by guga
 * every node is a digit, reverse order, calculate the sum of 2 linked lists.
 * 7->1->6 + 5->9->2  => 617+295 = 912 => 2->1->9
 * <p>
 * follow up: suppose digits are in forward order:
 * <p>
 * 6->1->7 + 2->9->5 => 617+295 = 912 => 9->1->2
 */
public class P25_SumLists {

    public static void main(String[] args) {

        Node l1 = new Node<Integer>(1);
        l1.append(1).append(1).append(8);
        Node l2 = new Node<Integer>(2);
        l2.append(2).append(9).append(2);
        printLinkedList(l1);
        printLinkedList(l2);
        Node result = sumReversal(l1, l2);
        printLinkedList(result);
    }


    public static Node sumReversal(Node<Integer> l1, Node<Integer> l2) {
        /**
         * TODO implement recursive version
         * TODO clean code
         * TODO implement follow up
         */
        int val = l1.item + l2.item;
        Node prev = new Node<>(val % 10);
        Node head = prev;
        int reserval = val / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            val = l1.item + l2.item;
            prev.next = new Node<>(val % 10 + reserval);
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
            reserval = val / 10;
        }
        while (l1 != null) {
            val = l1.item ;
            prev.next = new Node<>(val % 10 + reserval);
            prev = prev.next;
            l1 = l1.next;
            reserval = val / 10;
        }
        while (l2 != null) {
            val = l2.item ;
            prev.next = new Node<>(val % 10 + reserval);
            prev = prev.next;
            l2 = l2.next;
            reserval = val / 10;
        }
        if(reserval>0){
            prev.next = new Node<>(reserval);
        }
        return head;

    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.item + "->");
            head = head.next;
        }
        System.out.println();
    }

    static class Node<Item> {
        Node next = null;
        Item item;

        public Node(Item item) {
            this.item = item;
        }

        Node append(Item item) {
            Node next = new Node(item);
            this.next = next;
            return next;
        }
    }
}
