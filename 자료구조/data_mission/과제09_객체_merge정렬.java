package data_mission;

/*
 * 6장 구현 실습과제2
 */

class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
    
    public PhyscData(String name, int height, double vision) {
    	this.name = name;
		this.height = height;
		this.vision = vision;
    	
    }

	@Override
	public int compareTo(PhyscData o) {
		int compName = name.compareTo(o.name);
		int compHeight = Integer.compare(height, o.height);
		int compVision = Double.compare(vision, o.vision);
		
		if(compName != 0) return compName;
		else if(compHeight != 0) return compHeight;
		else if(compVision != 0) return compVision;
		else return 0; 
	
	}
	
}

public class 과제09_객체_merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lA, int rA, int lB, int rB ) {
		//임시 배열 생성
		PhyscData temp[] = new PhyscData[a.length];
		int i = 0;
		int p = lA, q = lB;
		while(p <= rA && q <= rB) {
			//a[p] < a[q]
			if (a[p].compareTo(a[q])<0) 
				temp[i++] = a[p++];
			else if (a[p].compareTo(a[q]) > 0)
				temp[i ++] = a[q ++];
			else {
				temp[i++] = a[p++];
			}
		}
		while (p <= rA) temp[i++] = a[p++];  // 고친 부분 1
		while (q <= rB) temp[i++] = a[q++];  // 고친 부분 2

		// temp를 원래 배열로 복사
		for (int j = 0; j < i; j++) {
			a[lA + j] = temp[j];
		}

	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("강민하", 172, 0.3),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("박준서", 171, 1.0),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		         new PhyscData("유서범", 171, 1.5),
		     };
		int nx = x.length;

		   MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
			System.out.println("오름차순으로 정렬했습니다.");
		     System.out.println("■ 신체검사 리스트 ■");
		     System.out.println(" 이름     키  시력");
		     System.out.println("------------------");
		     for (int i = 0; i < x.length; i++)
		         System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}
