package com.guga.ctci.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guga
 *
 * Write code to remove duplicates from an unsorted linked list
 */
public class P21_RemoveDups {


    public static void main(String[] args) {// TODO initial version, unit missing
        Node head = new Node<Integer>(4);
        head.append(5).append(3).append(5).append(2); // 4->5->3->5->2
        printLinkedList(head);
        removeDups(head);
        printLinkedList(head);


    }

    public static void printLinkedList(Node head){
        while (head!=null){
            System.out.print(head.item+"->");
            head = head.next;
        }
        System.out.println();
    }


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

