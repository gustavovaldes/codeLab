package com.guga.ctci.linkedlists;

/**
 * Created by guga
 * <p>
 * Check if a linkedList is a Palindrome
 */
public class P26_PalindromeList {


    public static void main(String[] args) {
        Node<Character> head = new Node('a');
        head.append('b').append('c').append('c').append('b').append('a');
        printLinkedList(head);
        System.out.println(isPalindrome(head));

    }

    /*
    brute force implementation
     */
    public static boolean isPalindrome(Node<Character> node) {
        int count = size(node) - 1;
        int mid = count / 2;
        int counter = 0;
        while (counter <=mid) {
            Node temp = getNode(node, count - counter*2);
            System.out.println(temp.item);
            if (node.item != temp.item) {
                return false;
            }
            counter++;
            node = node.next;
        }
        return true;
    }

    private static int size(Node node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    private static Node getNode(Node node, int forward) {
        for (int i = 0; i < forward; i++) {
            node = node.next;
        }
        return node;
    }


    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.item + "->");
            head = head.next;
        }
        System.out.println();
    }

    static class Node<Item> {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }

        public Node append(Item item) {
            Node next = new Node(item);
            this.next = next;
            return next;
        }
    }
}
