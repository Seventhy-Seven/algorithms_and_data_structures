package com.lesson_07;

class Vertex{
    public char label;

    public boolean wasVisited;

    public Vertex(char label, boolean wasVisited) {
        this.label = label;
        this.wasVisited = wasVisited;
    }

    public Vertex(char label){
        this.label = label;
    }
}

class Graph{
    private final int MAX_VERTS = 32;
    private Vertex [] vertexList;
    private int[][]adjMat;
    private int size;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

    public int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == i && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void DFS(int f){     //рекурсивный метод обхода в глубину

        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if(!vertexList[i].wasVisited && v != -1){
                fullDisplayVertex(f,v);
                DFS(i);
            }
        }
    }

    private void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Вершины " + vertexList[vertex1].label + " - " + vertexList[vertex2].label);
    }

    public void BFS(int v){    //метод обхода в ширину
        int [] queue = new int[size];
        int queueHead = 0;
        int queueTail = 0;

        vertexList[0].wasVisited = true;
        queue[queueTail++] = v;

        displayVertex(0);

        int v2;

        while (queueHead < queueTail){
            v = queue[queueHead++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if(!vertexList[i].wasVisited && v2 != -1){
                    vertexList[i].wasVisited = true;
                    displayVertex(queueTail);
                    queue[queueTail++] = i;
                }
            }
        }
        for (int i = 0; i < size; i++) {    //сброс флага
            vertexList[i].wasVisited = false;
        }
    }
}

public class Lesson_07 {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        //graph.displayVertex(4);

        graph.DFS(5);
        graph.BFS(2);
    }
}
