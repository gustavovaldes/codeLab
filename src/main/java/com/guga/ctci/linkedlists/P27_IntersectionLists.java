package com.guga.ctci.linkedlists;

/**
 * Created by guga
 * <p>
 * <p>
 * Given 2 single linked list, return the node intersecting both if exist.
 */
public class P27_IntersectionLists {

    public static void main(String[] args) {
        Node list1 = new Node(4);
        Node list2 = new Node(5);

        Node tail = new Node(100);
        tail.append(101).append(102);

        list1.append(3).append(5).append(6).append(tail);
        list2.append(5).append(21).append(tail);

        printLinkedList(list1);
        printLinkedList(list2);

        System.out.println("found: " + getIntersectionNode(list1, list2).item);//expected 100
        System.out.println("found: " + getIntersectionNodeV2(list1, list2).item);//expected 100

    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.item + "->");
            head = head.next;
        }
        System.out.println();
    }


    /*
    brute force, N*M
     */
    public static Node getIntersectionNode(Node l1, Node l2) {
        Node head2 = l2;
        while (l1 != null) {
            while (l2 != null) {
                System.out.println(l1.item + " * " + l2.item);
                if (l1 == l2) return l2;
                l2 = l2.next;
            }
            l1 = l1.next;
            l2 = head2;
        }
        return null;
    }

    /*
    just N + M + ABS(N-M) time.  If intersect, last node is equal in both, so, end of one of the list is the node.
    TODO use paper to clarify the borders
    TODO test
    TODO refactor to clean code
     */
    public static Node getIntersectionNodeV2(Node l1, Node l2) {
        int length1 = 0;
        int length2 = 0;

        Node head1 = l1;
        Node head2 = l2;

        while (l1.next != null) {
            length1++;
            l1 = l1.next;
        }

        while (l2.next != null) {
            length2++;
            l2 = l2.next;
        }
        if (l1 != l2) {
            return null;
        }else{
            int diff = length1 - length2;
            if (diff > 0) {
                for (int i = 1; i < length1 - diff; i++) {
                    head1 = head1.next;
                }
                return  head1;
            } else if (diff < 0) {
                for (int i = 1; i < length2 - diff; i++) {
                    head2 = head2.next;
                }
                return head2;
            } else {
                for (int i = 1; i < length2; i++) {
                    if(head1==head2) return head1;
                    head1 = head1.next;
                    head2 = head2.next;
                }
                return null;
            }
        }
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

        Node append(Node node) {
            this.next = node;
            return node;
        }
    }
}
