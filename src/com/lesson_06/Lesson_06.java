package com.lesson_06;

public class Lesson_06 {

    static class Person{

        public String name;
        public int id;
        public int age;

        public Person(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    static class Node{

        public Person person;
        public Node leftChild;
        public Node rightChild;

        public void display(){
            System.out.println("Имя: " + person.name + " , Возраст: " + person.age);
        }
    }

    static class Tree{
        private Node root;

        public void insert(Person person){
            Node node = new Node();
            node.person = person;
            if(root == null)
                root = node;
            else{
                Node current = root;
                Node parent;
                while (true){
                    parent = current;
                    if(person.id < current.person.id){
                        current = current.leftChild;
                        if(current == null){
                            parent.leftChild = node;
                            return;
                        }
                    }else{
                        current = current.rightChild;
                        if(current == null){
                            parent.rightChild = node;
                            return;
                        }
                    }
                }
            }

        }

        public Node find(int key){
            Node current = root;
            while (current.person.id != key){
                if(key < current.person.id)
                    current = current.leftChild;
                else
                    current = current.rightChild;
                if(current == null)
                    return null;
            }
            return current;
        }

        public boolean delete(int id){
            Node current = root;
            Node parent = root;

            boolean isLeftChild = true;

            while (current.person.id != id){
                parent = current;
                if(id < current.person.id){
                    isLeftChild = true;
                    current = current.leftChild;
                }else{
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if(current == null){
                    return false;
                }
            }

            if(current.leftChild == null && current.rightChild == null){
                if(current == root){
                    root = null;
                } else if(isLeftChild){
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            }else if(current.rightChild == null){
                if(current == null){
                    root = current.rightChild;
                }else if(isLeftChild){
                    parent.leftChild = current.rightChild;
                }else{
                    parent.rightChild = current.rightChild;
                }
            }else{
                Node successor = getSuccessor(current);
                if(current == root){
                    root = successor;
                }else if(isLeftChild){
                    parent.leftChild = successor;
                }else {
                    parent.rightChild = successor;
                }
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        public Node getSuccessor(Node node){
            Node successorParent = node;
            Node successor = node;
            Node current = node.rightChild;

            while (current != null){
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }
            if(successor != node.rightChild){
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = node.rightChild;
            }

            return successor;
        }

        public void displayTree(){
            Node current = root;
            System.out.println("Симметричный ");
            inOrder(root);
            System.out.println("Прямой ");
            preOrder(root);
            System.out.println("Обратный ");
            postOrder(root);

        }

        public void inOrder(Node rootNode){
            if(rootNode != null){
                inOrder(rootNode.leftChild);
                rootNode.display();
                inOrder(rootNode.rightChild);
            }
        }

        public void preOrder(Node rootNode){
            if(rootNode != null){
                rootNode.display();
                preOrder(rootNode.leftChild);
                preOrder(rootNode.rightChild);
            }
        }

        public void postOrder(Node rootNode){
            if(rootNode != null){
                postOrder(rootNode.leftChild);
                postOrder(rootNode.rightChild);
                rootNode.display();
            }
        }

        public Node min(){

            Node current , last = null;
            current = root;
            while (current != null){
                last = current;
                current = current.leftChild;
            }
            return last;
        }

        public Node max(){
            Node current, last = null;
            current = root;
            while (current != null){
                last = current;
                current = current.rightChild;
            }
            return last;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(new Person("Пётр", 4, 30));
        tree.insert(new Person("Вася", 3, 25));
        tree.insert(new Person("Саша", 2, 27));
        tree.insert(new Person("Лёша", 1,29));

        tree.max().display();
        tree.min().display();

        tree.find(3).display();

        tree.delete(2);

        System.out.println();
        tree.displayTree();

    }
}

