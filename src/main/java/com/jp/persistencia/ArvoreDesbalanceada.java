package com.jp.persistencia;

import com.jp.modelos.Palavra;

public class ArvoreDesbalanceada {

    public class Node {
        public Palavra key;
        int height;
        Node left;
        Node right;

        Node(Palavra key) {
            this.key = key;
        }
    }

    private Node root;

    private boolean maiorQue(Palavra primeiro, Palavra segundo) {
        if(primeiro.getPalavra().compareTo(segundo.getPalavra()) > 0) return true;

        return false;
    }

    /*private boolean maiorQue(char primeiro, char segundo) {
        if(Character.compare(primeiro, segundo) > 0) return true;

        return false;
    }*/

    private boolean menorQue(Palavra primeiro, Palavra segundo) {
        if(primeiro.getPalavra().compareTo(segundo.getPalavra()) < 0) return true;

        return false;
    }

    /*private boolean menorQue(char primeiro, char segundo) {
        if(Character.compare(primeiro, segundo) < 0) return true;

        return false;
    }*/

    public Node find(Palavra key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = menorQue(current.key, key) ? current.right : current.left;
        }
        return current;
    }

    /*public Node find(char letra) {
        Node current = root;
        while (current != null) {
            if (current.key.getLetra() == letra) {
                break;

            }
            current = menorQue(current.key.getLetra(), letra) ? current.right : current.left;
        }
        return current;
    }*/

    public void insert(Palavra key) {
        root = insert(root, key);
    }

    public void delete(Palavra key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, Palavra key) {
        if (node == null) {
            return new Node(key);
        } else if (maiorQue(node.key, key)) {
            node.left = insert(node.left, key);
        } else if (menorQue(node.key, key)) {
            node.right = insert(node.right, key);
        } else {
            System.out.println("Deu certo");
        }
        return rebalance(node);
    }

    private Node delete(Node node, Palavra key) {
        if (node == null) {
            return node;
        } else if (maiorQue(node.key, key)) {
            node.left = delete(node.left, key);
        } else if (menorQue(node.key, key)) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    public void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(node.key.getPalavra());

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }


    public void printAVLTree() {
        printAVLTree(root, "", true);
    }
}
