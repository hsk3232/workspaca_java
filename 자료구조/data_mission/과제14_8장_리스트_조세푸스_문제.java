package data_mission;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class 과제14_8장_리스트_조세푸스_문제 {
	 // 노드 (원형 단일 연결 리스트)
    static class Node {
        int id;
        Node next;
        Node(int id) { this.id = id; }
    }

    // 원형 단일 연결 리스트
    static class CircularList {
        Node head;   // 비어있지 않으면 head는 "가장 작은 id"를 가리키도록 유지
        int size;

        // 오름차순 정렬 삽입 (중복 방지 가정: main에서 유일성 보장)
        void insertSorted(int id) {
            Node newNode = new Node(id);
            if (head == null) {
                head = newNode;
                newNode.next = newNode; // 원형
                size = 1;
                return;
            }
            // 새 id가 가장 작으면 head 앞에 삽입하고 head 갱신
            if (id < head.id) {
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                newNode.next = head;
                tail.next = newNode;
                head = newNode;
                size++;
                return;
            }
            // head 이후에서 정렬 위치 찾기 (prev.id <= id <= curr.id 인 지점 앞)
            Node prev = head;
            Node curr = head.next;
            while (curr != head && curr.id < id) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
            newNode.next = curr;
            size++;
        }

        // 초기 정렬된 id들 출력
        String toAscendingString() {
            if (head == null) return "[]";
            StringBuilder sb = new StringBuilder();
            Node p = head;
            do {
                sb.append(p.id);
                p = p.next;
                if (p != head) sb.append(' ');
            } while (p != head);
            return sb.toString();
        }

        // 요세푸스 제거: K번째마다 제거, 제거 순서를 반환하고 마지막 남은 노드의 id를 함께 리턴
        // (리스트 내부는 제거에 따라 실시간 갱신됨)
        List<Integer> josephusEliminate(int k) {
            List<Integer> removed = new ArrayList<>();
            if (head == null || size == 0) return removed;

            // 시작을 head에서: prev는 tail로 세팅 (삭제를 위해 prev 필요)
            Node prev = head;
            while (prev.next != head) {
                prev = prev.next; // tail
            }
            Node curr = head;

            // 반복: size가 1이 될 때까지 K번째마다 제거
            while (size > 1) {
                int step = 1;
                while (step < k) {
                    prev = curr;
                    curr = curr.next;
                    step++;
                }
                // 이제 curr이 제거 대상 (K번째)
                removed.add(curr.id);
                // head가 삭제 대상이면 head를 다음으로 이동
                if (curr == head) {
                    head = curr.next;
                }
                // 삭제: prev.next가 curr 다음을 가리키게
                prev.next = curr.next;
                curr = curr.next;
                size--;
            }
            // 마지막 남은 노드는 head
            return removed;
        }

        int lastId() {
            if (head == null) return -1;
            return head.id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        System.out.print("N(사람 수) 입력: ");
        int N = sc.nextInt();
        System.out.print("K(제거 간격) 입력: ");
        int K = sc.nextInt();

        if (N <= 0 || K <= 0) {
            System.out.println("N과 K는 1 이상이어야 합니다.");
            return;
        }

        // 고유 id 난수 생성 (중복 방지)
        // 범위는 1~9999 정도로 넉넉히
        HashSet<Integer> used = new HashSet<>();
        Random rnd = new Random();

        CircularList circle = new CircularList();

        // 생성 순서대로 리스트에 "오름차순 정렬 삽입"
        for (int i = 0; i < N; i++) {
            int id = 0;
            boolean ok = false;
            while (!ok) {
                id = rnd.nextInt(9999) + 1; // 1..9999
                if (!used.contains(id)) {
                    used.add(id);
                    ok = true;
                }
            }
            circle.insertSorted(id);
        }

        // 1) 초기 오름차순 id 출력
        System.out.println("초기 정렬된 id: " + circle.toAscendingString());

        // 2) 제거되는 k번째 id 순서대로 출력
        List<Integer> removed = circle.josephusEliminate(K);
        if (removed.isEmpty() && N > 1) {
            System.out.println("제거 순서: (없음)");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < removed.size(); i++) {
                sb.append(removed.get(i));
                if (i < removed.size() - 1) sb.append(' ');
            }
            System.out.println("제거 순서(K=" + K + "): " + sb.toString());
        }

        // 3) 마지막 남는 id 출력
        System.out.println("마지막 남는 id: " + circle.lastId());
    }
}
