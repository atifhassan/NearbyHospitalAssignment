// Incomplete version
//----------------------------------------------------------------------------
// WeightedGraph.java            by Dale/Joyce/Weems                 Chapter 9
//
// Implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------
package structures;

import Interfaces.QueueUnboundedInterface;
import Interfaces.WeightedGraphInterface;

/**
 *
 * @author atifm
 * @param <E>
 */
public class WeightedGraph<E> implements WeightedGraphInterface<E> {

    /**
     *
     */
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 50;  // default capacity
    private int numVertices;
    private int maxVertices;
    private E[] vertices;
    private int[][] edges;
    private boolean[] marks;  // marks[i] is mark for vertices[i]

    /**
     *
     */
    public WeightedGraph() // Instantiates a graph with capacity DEFCAP vertices.
    {
        numVertices = 0;
        maxVertices = DEFCAP;
        vertices = (E[]) new Object[DEFCAP];
        marks = new boolean[DEFCAP];
        edges = new int[DEFCAP][DEFCAP];
    }

    /**
     *
     * @param maxV
     */
    public WeightedGraph(int maxV) // Instantiates a graph with capacity maxV.
    {
        numVertices = 0;
        maxVertices = maxV;
        vertices = (E[]) new Object[maxV];
        marks = new boolean[maxV];
        edges = new int[maxV][maxV];
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() // Returns true if this graph is empty; otherwise, returns false.
    {
        return numVertices == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFull() // Returns true if this graph is full; otherwise, returns false.
    {
        return numVertices == maxVertices;
    }

    /**
     *
     * @param vertex
     */
    @Override
    public void addVertex(E vertex) // Preconditions:   This graph is not full.
    //                  Vertex is not already in this graph.
    //                  Vertex is not null.
    //
    // Adds vertex to this graph.
    {
        vertices[numVertices] = vertex;
        for (int index = 0; index < numVertices; index++) {
            edges[numVertices][index] = NULL_EDGE;
            edges[index][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }

    /**
     *
     * @param vertex
     * @return
     */
    @Override
    public boolean hasVertex(E vertex) // Returns true if this graph contains vertex; otherwise, returns false.
    {
        return numVertices > 0;
    }

    private int indexIs(E vertex) // Returns the index of vertex in vertices.
    {
        int index = 0;
        while (!vertex.equals(vertices[index])) {
            index++;
        }
        return index;
    }

    /**
     *
     * @param fromVertex
     * @param toVertex
     * @param weight
     */
    @Override
    public void addEdge(E fromVertex, E toVertex, int weight) // Adds an edge with the specified weight from fromVertex to toVertex.
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        edges[row][column] = weight;
    }

    /**
     *
     * @param fromVertex
     * @param toVertex
     * @return
     */
    @Override
    public int weightIs(E fromVertex, E toVertex) // If edge from fromVertex to toVertex exists, returns the weight of edge;
    // otherwise, returns a special �null-edge� value.
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        return edges[row][column];
    }

    /**
     *
     * @param vertex
     * @return
     */
    @Override
    public QueueUnboundedInterface<E> getToVertices(E vertex) // Returns a queue of the vertices that are adjacent from vertex.
    {
        QueueUnboundedInterface<E> adjVertices = new QueueLinkedList<>();
        int fromIndex;
        int toIndex;
        fromIndex = indexIs(vertex);
        for (toIndex = 0; toIndex < numVertices; toIndex++) {
            if (edges[fromIndex][toIndex] != NULL_EDGE) {
                adjVertices.Enqueue(vertices[toIndex]);
            }
        }
        return adjVertices;
    }

    /**
     *
     */
    @Override
    public void clearMarks() // Sets marks for all vertices to false.
    {
    }

    /**
     *
     * @param vertex
     */
    @Override
    public void markVertex(E vertex) // Sets mark for vertex to true.
    {
    }

    /**
     *
     * @param vertex
     * @return
     */
    @Override
    public boolean isMarked(E vertex) // Returns true if vertex is marked; otherwise, returns false.
    {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public E getUnmarked() // Returns an unmarked vertex if any exist; otherwise, returns null.
    {
        return null;
    }
}
