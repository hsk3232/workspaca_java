package java_ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {
	public static void main(String[] args) {

		lotto_generator(5);

	}

	public static void lotto_generator(int n) {
		Random number = new Random();
		HashSet<Integer> lotto = null;

		for (int i = 0; i < n; i++) {
			lotto = new HashSet<Integer>();

			// for (int j = 0; lotto.size() <= 6; j++) { 
			// 이 코든 잘못 됨, j를 안쓰고 있고 사실 필요가 없기 때문에
			
				int count = 0;
				while (lotto.size() <= 6) {					
				lotto.add(number.nextInt(45) +1);
				count++;

			}

			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L + "==>" + count); //그래서 이 값을 얻기까지 몇번의 루프를 돌까?
		}
	}
}