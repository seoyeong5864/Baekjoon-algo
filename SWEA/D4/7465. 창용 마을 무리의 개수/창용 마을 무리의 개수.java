import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int N;
	static int M;
	static int[] p; // 대표를 저장할 배열
	static int count; // 모임의 개수 카운트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = sc.nextInt(); // 마을에 사는 사람의 수 - 노드 개수
			M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수 - 간선 개수
			
			
			int[] x = new int[M];
			int[] y = new int[M];
			for (int i = 0; i < M; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}

			// 로직
			p = new int[N+1]; // 인덱스 0 비우고 노드 개수만큼의 대표 저장할 배열 생성
			
			// 1. 대표집합 만들기
			for(int i = 1; i <= N; i++) {
				makeSet(i);
			}
			
			// 2. x,y 원소를 하나의 그룹으로 union
			for(int i = 0; i < M; i++) {
				union(x[i],y[i]);
			}
			
			// 3. 총 몇개의 집합이 있는지
			// HashSet - 중복을 허용하지 않는 자료구조
			Set<Integer> reps = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				reps.add(findSet(i));
			}
			count = reps.size();
			
			
			
			// 출력
			System.out.println("#" + tc + " " + count);
		}

	} // main

	
	
	// makeSet
	static void makeSet(int x) {
		p[x] = x;
	}

	
	// findSet - x가 속한 대표 노드 찾기
	static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	
	
	// Union - 원소 x가 속한 집합과 y가 속한 집합 합치기
	static void union(int x, int y) {
		// 원소 y가 속한 집합의 대표를 찾고
		// 그 집합의 대표를 원소 x가 속한 집합의 대표 값으로 바꿔줌
		// 즉 x가 속한 집합에 y가 속한 집합이 함쳐짐
		p[findSet(y)] = findSet(x);
	}

}
