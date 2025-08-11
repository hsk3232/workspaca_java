package data_mission;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(int n) {
        int answer = 0;
        
        try {
        List<Integer> list = new ArrayList<>();
        int sqrt = (int)Math.sqrt(n);
        System.out.println("1: "+sqrt);
        
        for(int i = 1; i <= sqrt; i++){
            if(n%i == 0){
                list.add(i);
                if(i != n/i){
                    list.add(n/i);
                }
            }
        }
        
        System.out.println(list);
        System.out.println(list.size());
        if(list.size() % 2 == 0)
            answer = list.size() /2;
        else{
            answer = (list.size()/2) +1;
        }
        
        return answer;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 2;
        }
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(20);
		
	}
}