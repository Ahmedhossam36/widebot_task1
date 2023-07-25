/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.widebot_dictionary;

/**
 *
 * @author ahmed
 * 
 * 
  */

import java.util.List;
class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
Node root;

    public void insert(String value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (value.compareTo(current.value) < 0) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (value.compareTo(current.value) > 0) {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    // Value already exists in the tree
                    break;
                }
            }
        }
    }

    public Node search(String value) {
        Node current = root;
        while (current != null) {
            if (value.equals(current.value)) {
                return current;
            } else if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public String findPredecessor(String value) {
        Node current = root;
        Node predecessor = null;

        while (current != null) {
            if (value.compareTo(current.value) > 0) {
                predecessor = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return (predecessor != null) ? predecessor.value : null;
    }

    public String findSuccessor(String value) {
        Node current = root;
        Node successor = null;

        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return (successor != null) ? successor.value : null;
    }

    public void balanceBst(List<String> sortedValues) {
        root = constructBalancedBst(sortedValues, 0, sortedValues.size() - 1);
    }

    private Node constructBalancedBst(List<String> sortedValues, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node newNode = new Node(sortedValues.get(mid));

        newNode.left = constructBalancedBst(sortedValues, start, mid - 1);
        newNode.right = constructBalancedBst(sortedValues, mid + 1, end);

        return newNode;
    }
}

