package data_mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	
	
	public List<Integer> makeList(int n) {
		List<Integer> list = new ArrayList<>();
		 // 0은 약수에서 제외, 자기 자신
		for(int i = 1; i <= n; i++) {
            if(n%i == 0) {
                list.add(i);
            }
        }
        
        return list;
        
	}
    
    // 약수 생성 및 합계 method
    public int solution(int n) {
    	List<Integer> list = makeList(n);
    	      
        // 결과값 초기화
        int answer = 0;
        
        
        for(int j = 0; j <= list.size()-1; j++){
        	answer += list.get(j);
            
        }
    
        return answer;
    }
    


    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("정수를 입력해 주세요");
    	int n = sc.nextInt();
    	  if(n < 3001 && n < 0) {
              System.out.println("입력 범위를 초과했습니다.");
          }
    	  Solution so = new Solution();
    	  System.out.print( n + "의 약수는");
          System.out.print(so.makeList(n) +"입니다.");
          System.out.print("이를 모두 더하면 "+ so.solution(n) +"입니다.");
      
    }
    
}
