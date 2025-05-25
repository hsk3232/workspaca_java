package data_mission;

public class mission {

	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];
        int min;
		
		int num = (numer1*denom2) + (numer2*denom1);
		int den = denom2*denom1;
		
		if(num < den ) {
			min = num;
		}
		else {
			min = den;
		}
		
	    for(int i = 2; i < min; i++){
	        if((num % i == 0)  && (den % i == 0)){
	        	int tempNum = num / i;
	        	int tempDen = den / i;
	        	if(tempNum)
	        	
	        	i = 1;
	        
	          }
	        
	    	}
	               
	     }
	            answer[0] = num;
	            answer[1] = den;
        }
        return answer;
	    }
	}
	
