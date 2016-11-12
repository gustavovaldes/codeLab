package com.guga.nocategory;

import com.guga.common.BinaryTreeNode;

/**
 * Created by guga
 * <p>
 * input:  2 Binary Trees  (no BST) , BT1, BT2
 * return:  true if BT1 contain BT2.
 */
public class BinaryTreeIntersection {

    //TODO more test scenario
    //TODO clean up border cases , clean code.
    //TODO implement using queues instead of recursion.  Analyze time complexity and memory in both cases
    public static void main(String[] args) {

        BinaryTreeNode<Integer> head1 = new BinaryTreeNode<>(100);
        BinaryTreeNode<Integer> head2 = new BinaryTreeNode<>(40);

        head1.appendBothReturnLeft(34, 21).appendBothReturnRight(12, 23).appendToRight(40)
                .appendBothReturnRight(11, 3).appendToRight(3).appendToRight(2);
        head2.appendBothReturnRight(11, 3).appendToRight(3);

        System.out.println(new BinaryTreeIntersection().contains(head1, head2));
    }


    public boolean contains(BinaryTreeNode a, BinaryTreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.item == b.item && equals(a, b)) {
            return true;
        } else {
            return contains(a.left, b) || contains(a.right, b);
        }
    }

    public boolean equals(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null) return true;
        if (b == null)
            return true;//if b finish, it's already contained. to support case where is not at the end edges of a.
        if (a == null) return false;
        if (a.item != b.item) return false;/*TODO it can be done at Node level really, just using the item value because the way I creating the nodes*/
        return equals(a.left, b.left) && equals(a.right, b.right);
    }
}
