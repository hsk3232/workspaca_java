package data_ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph {
	LinkedList<Integer>[] adjacencyList;
	int n;
	boolean[] visited;

	public Graph(int vertices) {
		n = vertices;
		adjacencyList = new LinkedList[n];
		visited = new boolean[n];
	}
	
	//노드를 돌면서 노드에 저장된 값을 출력
	void displayAdjacencyLists() {
		for(int i = 0; i < n; i ++) {
			System.out.print("Node [" + i + "] :" );
			
			if(adjacencyList[i] != null) {
				for(int near : adjacencyList[i]) {
					System.out.print(near + " ");
				}
			}
			System.out.println();
		}
		
		
	}
	
	//그래프에 간선(Edge)을 추가
	void insertEdge(int start, int end) {
		if(adjacencyList[start] == null) {
			adjacencyList[start] = new LinkedList<>();
		}
		if(adjacencyList[end] == null) {
			adjacencyList[end] = new LinkedList<>();
		}
		
		adjacencyList[start].add(end);
		adjacencyList[end].add(start);
		
	}

	void bfs(int startNode) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		//행렬 버젼에 Queue 설명 참조

		visited[startNode] = true;
		queue.add(startNode);

		System.out.print("BFS traversal: ");
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			if(adjacencyList[current] !=null) {
				for(int near : adjacencyList[current]) {
					if(!visited[near]) {
						visited[near] = true;
						queue.add(near);
					}
				}
			}
			
			
		}
		System.out.println();
	}

	void dfs(int startNode) {
		Arrays.fill(visited, false);
		System.out.print("DFS traversal: ");
		nonRecursiveDfs(startNode);
		System.out.println();
	}

	void nonRecursiveDfs(int startNode) {
		Stack<Integer> stack = new Stack<>();
		/*
		 * Stack 클래스는 자바 표준 라이브러리에서 제공되는 클래스
		 * stack.push(10);    // 스택에 값 넣기
		 * stack.pop();       // 스택에서 값 꺼내기 (제거)
		 * stack.peek();      // 맨 위 값 확인 (제거 X)
		 * stack.isEmpty();   // 비어있는지 확인
		 * 
		 * Stack은 오래된 클래스이고, 동기화(synchronized) 때문에 성능 떨어짐
		 * Deque (예: ArrayDeque)를 사용해서 스택을 구현 추천
		 * Deque<Integer> stack = new ArrayDeque<>();
		 *
		 * stack.push(10);     // 값 넣기
		 * stack.pop();        // 값 꺼내기
		 * stack.peek();       // 맨 위 값 확인
		 */
		stack.push(startNode);
		visited[startNode] = true;

		while (!stack.isEmpty()) {
			int current = stack.pop();
			System.out.print(current + " ");
			
			if(adjacencyList[current] !=null) {
				Collections.sort(adjacencyList[current]);
				//정렬을 하고 싶다면, Collections.sort(adjacencyList[current])
				for(int near : adjacencyList[current]) {
					if(!visited[near]) {
						stack.push(near);
						visited[near] = true;
					}
				}
			}
		}
	}
}

class InputGraph3 {
	int start, end;

	InputGraph3(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class train_실습과제11_1GraphDFSBFS_리스트 {
	static final int N = 8;

	static int[][] makeGraph() {
		return new int[][]{
			{0, 1, 1, 0, 0, 0, 0, 0},
			{1, 0, 0, 1, 1, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 1},
			{0, 1, 0, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 1},
			{0, 0, 0, 1, 1, 1, 1, 0}
		};
	}
    static void showMatrix(int[][]m) {
    	System.out.println("adjacency matrix::");
    	for (int[] row : m) {
    		for (int num: row) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
	public static void main(String[] args) {
		int[][] matrix = makeGraph();
		showMatrix(matrix);
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph(N);

		while (true) {
			System.out.println("\nChoose Command: 1: Add edges, 2: Display Adjacency List, 3: BFS, 4: DFS, 5: Exit => ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				List<InputGraph3> inputData = new ArrayList<>();
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[0].length; j++) {
						if (matrix[i][j] == 1) {
							inputData.add(new InputGraph3(i, j));
						}
					}
				}
				for (InputGraph3 edge : inputData) {
					g.insertEdge(edge.start, edge.end);
				}
				break;

			case 2:
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.print("Enter starting node for BFS: ");
				int startBfsNode = sc.nextInt();
				g.bfs(startBfsNode);
				break;

			case 4:
				System.out.print("Enter starting node for DFS: ");
				int startDfsNode = sc.nextInt();
				g.dfs(startDfsNode);
				break;

			case 5:
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid input. Please re-enter.");
			}
		}
	}
}
