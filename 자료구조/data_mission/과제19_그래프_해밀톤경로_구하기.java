package data_mission;

/*
 * 해밀턴 경로 (Hamiltonian Path)란?
 * 모든 정점을 정확히 한 번씩 방문하는 경로
 */

import java.util.Arrays;
import java.util.Stack;

class Sets2 {
    private int[] parent;
    private int n;

    public Sets2(int sz) {
        n = sz;
        parent = new int[sz + 1]; // Don't want to use parent[0]
        Arrays.fill(parent, -1);  // 0 for Simple versions
    }

    public void display() {
        System.out.print("display:index= ");
        for (int i = 1; i <= n; i++) System.out.print(" " + i);
        System.out.println();

        System.out.print("display: value= ");
        for (int i = 1; i <= n; i++) System.out.print(" " + parent[i]);
        System.out.println();
    }
    void RemoveSet(int i) {
    	//set에서 i를 제거하는 알고리즘 구현 - 중간 노드로 i가 있을 때, root로 i가 있을 때 해결 방법이 필요
    	if (i >= 1 && i <= n) {
            parent[i] = -1;
        }
    }
    public void SimpleUnion(int i, int j) {
    	int ri = SimpleFind(i);
        int rj = SimpleFind(j);
        if (ri == -1 || rj == -1) return;
        if (ri != rj) {
            parent[ri] = rj; // 간단히 j의 루트 밑으로
        }
    }

    public int SimpleFind(int i) {
    	if (i < 1 || i > n) return -1;
        int r = i;
        while (parent[r] > 0) {
            r = parent[r];
        }
        // 경로압축
        int cur = i;
        while (cur != r) {
            int p = parent[cur];
            parent[cur] = r;
            cur = p;
        }
        return r;
    }

    public void WeightedUnion(int i, int j) {
    	int ri = SimpleFind(i);
        int rj = SimpleFind(j);
        if (ri == -1 || rj == -1 || ri == rj) return;

        // parent[루트]는 음수(사이즈), 더 작은(절댓값 큰) 쪽이 큰 집합
        if (parent[ri] <= parent[rj]) {
            parent[ri] += parent[rj];
            parent[rj] = ri;
        } else {
            parent[rj] += parent[ri];
            parent[ri] = rj;
        }
    }

}
class Graph2 {
    private int numVertex; // 노드 숫자
    private int[][] graph; // Adjacency matrix
    private int[] path; // 해밀턴 경로를 배열로 저장

    Graph2(int[][] graph) {
        this.numVertex = graph.length;
        this.graph = graph;
        this.path = new int[numVertex];
        
        // 미방문 경로는 -1로 초기화
        for (int i = 0; i < numVertex; i++) {
            path[i] = -1;
        }
    }
    void show() {
    	for (int n: path)
    		System.out.print(" " + n);
    	System.out.println();
    }
    boolean findPath(int start) {
    	Stack<Integer> stack = new Stack<>();
        path[start] = 0;          // 각 정점의 "방문 순서"를 기록(0부터 시작)
        stack.push(start);        // 노드 start부터 시작
        Sets2 sts = new Sets2(8);   // 과제 틀 유지(이 구현에서는 사용하지 않음)
        int pos = 1;              // 다음에 부여할 방문 순서
        int direction = -1;       // 과제 틀 유지용 변수

        // 각 정점에서 다음으로 시도할 후보 인덱스 저장(백트래킹 재개 지점 기억)
        int[] nextTry = new int[numVertex];
        for (int i = 0; i < numVertex; i++) nextTry[i] = 0;

        while (!stack.isEmpty()) {
            // 모든 정점을 방문하면 성공
            if (pos == numVertex) {
                // 현재 path에는 "정점 -> 방문순서"가 기록됨. 이를 "방문순서 -> 정점" 배열로 변환해서 field에 저장.
                int[] seq = new int[numVertex];
                for (int v = 0; v < numVertex; v++) {
                    int k = path[v];
                    if (k >= 0) {
                        seq[k] = v;
                    }
                }
                this.path = seq;
                showPath();
                return true;
            }

            int current = stack.peek();
            boolean moved = false;

            // current에서 nextTry[current]부터 후보 정점 탐색
            int v = nextTry[current];
            while (v < numVertex) {
                // 다음 번 탐색은 그 다음 후보부터 시작하도록 미리 증가
                nextTry[current] = v + 1;

                if (isSafe(current, v)) {
                    // 방문 처리: v의 방문 순서를 기록하고 스택에 push
                    path[v] = pos;
                    stack.push(v);
                    pos++;

                    // 새 정점에서의 탐색은 0번 후보부터
                    nextTry[v] = 0;
                    moved = true;
                    break;
                }
                v++;
            }

            if (!moved) {
                // 더 이상 진행 불가 → 백트래킹
                int popped = stack.pop();
                if (popped == start) {
                    // 시작점까지 되돌아왔고 더 시도할 간선도 없음 → 실패
                    break;
                }
                // 방문 취소
                path[popped] = -1;
                pos--;
                // pop 뒤에는 스택 top의 다음 후보부터 재시도
            }
        }

        System.out.println("해밀턴 경로 없다.");
        return false;
    }

    boolean isSafe(int currentNode, int nextNode) {
    	// 1) 간선 존재?  2) 아직 방문하지 않았나?
        if (nextNode < 0 || nextNode >= numVertex) return false;
        if (graph[currentNode][nextNode] == 0) return false;
        if (path[nextNode] != -1) return false;
        return true;
    }

    void showPath() {
        System.out.println("해밀턴 경로:");
        for (int i = 0; i < numVertex; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // 해밀턴 경로
    }
}
public class 과제19_그래프_해밀톤경로_구하기 {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 1, 0, 1, 0}
        };
        
        Graph2 g = new Graph2(graph);
        g.findPath(0);
    }
}
