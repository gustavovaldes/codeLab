package com.guga.ctci.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guga
 *
 * Write code to remove duplicates from an unsorted linked list
 * How would you solve this problem if a temporary buffer is not allowed.
 */
public class P21_RemoveDups {


    public static void main(String[] args) {// TODO initial version, unit missing
        Node head = new Node<Integer>(4);
        head.append(5).append(3).append(5).append(2); // 4->5->3->5->2
        printLinkedList(head);
        removeDups(head);
        printLinkedList(head);

        Node head2 = new Node<Integer>(4);
        head2.append(5).append(3).append(5).append(2); // 4->5->3->5->2
        printLinkedList(head2);
        removeDups(head2);
        printLinkedList(head2);


    }

    public static void printLinkedList(Node head){
        while (head!=null){
            System.out.print(head.item+"->");
            head = head.next;
        }
        System.out.println();
    }


    /**
     * solution using HashMap O(n)
     */
    public static Node removeDups(Node<Integer> node){
        Node head = node;
        Map<Integer,Integer> values = new HashMap<>();
        Node parent = null;
        while(node!=null){
            if(values.containsKey(node.item)){
                removeChild(parent,node);
            }else{
                values.put(node.item,node.item);
            }
            parent= node;
            node = node.next;
        }
        return head;
    }

    /**
     * Solution without HashMap, but O(n^2)
     */
    public static Node removeDupsNoBuffer(Node<Integer> node){//TODO add test, can i remove parent reference? clean code?
        Node head = node;
        Node visitor = null;
        Node parent = null;
        while(node!=null){
            visitor= node.next;
            parent = node;
            while (visitor!=null){
                if(visitor.item==node.item){
                    removeChild(parent,visitor);
                }
                parent= visitor;
                visitor= visitor.next;
            }
        }
        return head;
    }


    public static void removeChild(Node parent, Node child){
        parent.next = child.next;
    }
}


class Node<Item> {
    Node next = null;
    Item item;

    public Node(Item item){
        this.item = item;
    }

    Node append(Item item){
        Node next = new Node(item);
        this.next = next;
        return next;
    }
}

