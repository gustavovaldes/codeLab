package com.guga.common;

/**
 * Created by guga
 */
public class BinaryTreeNode<Item> {

    public Item item;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Item item) {
        this.item = item;
    }

    public BinaryTreeNode appendBothReturnLeft(Item left, Item right){
        BinaryTreeNode leftNode =  new BinaryTreeNode<>(left);
        BinaryTreeNode rightode =  new BinaryTreeNode<>(right);
        this.left = leftNode;
        this.right = rightode;
        return leftNode;
    }

    public BinaryTreeNode appendBothReturnRight(Item left, Item right){
        BinaryTreeNode leftNode =  new BinaryTreeNode<>(left);
        BinaryTreeNode rightode =  new BinaryTreeNode<>(right);
        this.left = leftNode;
        this.right = rightode;
        return rightode;
    }

    public BinaryTreeNode appendToLeft(Item item){
        BinaryTreeNode node =  new BinaryTreeNode<>(item);
        this.left = node;
        return node;
    }

    public BinaryTreeNode appendToRight(Item item){
        BinaryTreeNode node =  new BinaryTreeNode<>(item);
        this.right = node;
        return node;
    }
}
