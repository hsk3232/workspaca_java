package data_mission;
/*
 * 6장 구현과제3
 */

class Polynomial3 implements Comparable<Polynomial3> {
	double coef; // 계수
	int exp; // 지수

	// --- 생성자(constructor) ---//
	Polynomial3(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	// 지수(exp) 내림차순, 지수가 같으면 계수(coef)도 내림차순
	@Override
	public int compareTo(Polynomial3 o) {
		if (o == null)
			return -1; // null 안전 처리
		if (this.exp != o.exp) {
			if (this.exp < o.exp)
				return 1; // 지수 큰 게 앞으로
			else
				return -1;
		} else {
			if (this.coef < o.coef)
				return 1; // 계수 큰 게 앞으로
			else if (this.coef > o.coef)
				return -1;
			else
				return 0;
		}
	}

}

public class 과제10_MergeSort다항식정렬 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb) {
		// body를 지우고 작성 훈련 연습이 도움이 된다
		int n = rightb - lefta + 1;
		Polynomial3[] temp = new Polynomial3[n];

		int i = lefta;
		int j = leftb;
		int k = 0;

		while (i <= righta && j <= rightb) {
			if (a[i] == null) {
				temp[k++] = a[j++];
				continue;
			}
			if (a[j] == null) {
				temp[k++] = a[i++];
				continue;
			}

			if (a[i].compareTo(a[j]) <= 0) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		while (i <= righta)
			temp[k++] = a[i++];
		while (j <= rightb)
			temp[k++] = a[j++];

		for (int t = 0; t < n; t++) {
			a[lefta + t] = temp[t];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left + right) / 2;
		if (left == right)
			return;
		MergeSort(a, left, mid);
		MergeSort(a, mid + 1, right);
		merge(a, left, mid, mid + 1, right);
		return;
	}

	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		// str 변수는 다항식 이름으로 스트링이다
		// count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다
		// 정렬후 다항식 x = 2.5x**7 + 3.8x**5 + 3.1x**4 + 1.5x**3 + 3.3x**2 + 4.0x**1 +
		// 2.2x**0
		int n;
		if (count < 0) {
			n = x.length;
		} else {
			n = count;
		}

		StringBuilder sb = new StringBuilder(str);
		boolean first = true;
		for (int i = 0; i < n; i++) {
			if (x[i] == null)
				continue;
			if (!first)
				sb.append(" + ");
			sb.append(String.format("%.1fx**%d", x[i].coef, x[i].exp));
			first = false;
		}
		System.out.println(sb.toString());
	}

	static int AddPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		// z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다
		int p = 0, q = 0;
		int terms = 0;

		while (p < x.length && x[p] != null && q < y.length && y[q] != null) {
			if (x[p].exp == y[q].exp) {
				double c = x[p].coef + y[q].coef;
				if (Math.abs(c) > 1e-12) {
					z[terms++] = new Polynomial3(c, x[p].exp);
				}
				p++;
				q++;
			} else if (x[p].exp > y[q].exp) {
				z[terms++] = new Polynomial3(x[p].coef, x[p].exp);
				p++;
			} else {
				z[terms++] = new Polynomial3(y[q].coef, y[q].exp);
				q++;
			}
		}
		while (p < x.length && x[p] != null)
			z[terms++] = new Polynomial3(x[p].coef, x[p++].exp);
		while (q < y.length && y[q] != null)
			z[terms++] = new Polynomial3(y[q].coef, y[q++].exp);

		return terms;

	}

	// 같은 지수 있으면 합치고, 0되면 제거
	static int addTerm(Polynomial3[] z, Polynomial3 term, int terms) {
		// 다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		// 추가된 항의 수를 count하여 terms으로 리턴한다.
		// 구현코드
		if (term == null || Math.abs(term.coef) < 1e-12)
			return terms;

		for (int i = 0; i < terms; i++) {
			if (z[i].exp == term.exp) {
				z[i].coef += term.coef;
				if (Math.abs(z[i].coef) < 1e-12) {
					for (int j = i + 1; j < terms; j++)
						z[j - 1] = z[j];
					terms--;
				}
				return terms;
			}
		}
		z[terms++] = new Polynomial3(term.coef, term.exp);
		return terms;

	}

	// 곱셈: 이중 루프 + addTerm
	static int MultiplyPolynomial(Polynomial3[] x, Polynomial3[] y, Polynomial3[] z) {
		// z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다
		// terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int terms = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == null)
				continue;
			for (int j = 0; j < y.length; j++) {
				if (y[j] == null)
					continue;
				Polynomial3 term = new Polynomial3(x[i].coef * y[j].coef, x[i].exp + y[j].exp);
				terms = addTerm(z, term, terms);
			}
		}
		return terms;
	}

	static double EvaluatePolynomial(Polynomial3[] z, int zTerms, int value) {
		// zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		// 다항식 계산 결과를 double로 리턴한다
		double result = 0.0;
		for (int i = 0; i < zTerms; i++) {
			if (z[i] == null)
				continue;
			result += z[i].coef * Math.pow(value, z[i].exp);
		}
		return result;
	}

	public static void main(String[] args) {
		Polynomial3[] x = { 
				new Polynomial3(1.5, 3), 
				new Polynomial3(2.5, 7), 
				new Polynomial3(3.3, 2),
				new Polynomial3(4.0, 1), 
				new Polynomial3(2.2, 0), 
				new Polynomial3(3.1, 4), 
				new Polynomial3(3.8, 5), };
		
		Polynomial3[] y = { 
				new Polynomial3(1.5, 1), 
				new Polynomial3(2.5, 2), 
				new Polynomial3(3.3, 3),
				new Polynomial3(4.0, 0), 
				new Polynomial3(2.2, 4), 
				new Polynomial3(3.1, 5), 
				new Polynomial3(3.8, 6), 
				};
		int nx = x.length;

		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);

		Polynomial3[] z = new Polynomial3[20];

		for (int i =0; i < z.length; i++)
			z[i] = null;

		int zTerms = AddPolynomial(x, y, z);// 다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		zTerms = MultiplyPolynomial(x, y, z);// 다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		
		double result = EvaluatePolynomial(z, zTerms, 1);// 다항식 값 계산 함수 z(10) 값 계산한다
		System.out.println(" result = " + result);
	}
}
