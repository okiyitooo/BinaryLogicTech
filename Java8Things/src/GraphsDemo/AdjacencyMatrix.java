package GraphsDemo;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix<T> {
	List<List<T>> adjacencyMatrix;
	public AdjacencyMatrix()  {
		this.adjacencyMatrix=new ArrayList<>();
	}
	
	public AdjacencyMatrix(List<List<T>> adjacencyMatrix) {
		super();
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public void addAdjacency(List<T> adjacency) {
		adjacencyMatrix.add(adjacency);
	}
}
