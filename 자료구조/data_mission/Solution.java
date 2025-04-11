package data_mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	
	
	static List <Integer> list = new ArrayList<>();
       
    
    // 약수 생성 및 합계 method
    public int solution(int n) {
    	      
        // 결과값 초기화
        int answer = 0;
        
        
        
        // 0은 약수에서 제외, 자기 자신
        for(int i = 1; i <= n; i++) {
            if(n%i == 0) {
                list.add(i);
            }            
        }
        for(int j = 0; j <= list.size(); j++){
            answer += list.get(j);
            
        }
    
        return answer;
    }
    
    public static void show(int n) {
        System.out.print( n + "의 약수는");
         System.out.print(list +"입니다.");
        System.out.print("이를 모두 더하면"+ solution() +"입니다.");
     }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	  if(n < 3001 && n < 0) {
              System.out.println("입력 범위를 초과했습니다.");
          }
    	  show(n);
    }
    
}
