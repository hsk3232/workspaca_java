package java_ch10;

/*Collection Framework: List, map, set으로 구성
 * List >  ArrayList, LinkedList
 * Map (값과 이어주는 맵핑할 때 맵) >  HashMap => 파이선에서 dictionary: (key, value)
 * Set(집합) > HashSet 
 */

import java.util.ArrayList;
import java.util.Collections;

//interface Comparable{
//	public int compareTo();// 추상메소드
//} ==> 우리가 쓸 필요가 없음 자바 라이브러리에서 제공함.

//Book 클래스
class Book implements Comparable<Book> { // Comparable<Book> 제너릭이라는 것임.
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book book) {
		return this.title.compareTo(book.title);
	}

}

//Library class
class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books;
	int top = 0;

	public Library() {
		books = new ArrayList<Book>(CAPACITY);

		
	}

	// 책 추가 (용량 초과 시 OverflowException 발생)
	public void addBook(Book book) {
		if (books.size() >= CAPACITY) {
			return;
		}
		// top++;
		
		books.add(book);	
	}

	// 책 삭제 (빈 목록에서 삭제 시 UnderflowException 발생)
	public Book removeBook() {
		if (books.isEmpty()) {
			return null;
		}
		return books.remove(0);

	}

	public void printBooks(String msg) {
		System.out.println(msg);
		for(Book books : books) {
			System.out.println(books);
		}
		   System.out.println("-".repeat(60));
	}

	public void sortBooksByTitle() {
		//Collections.sort(books);
		books.sort(null);
		}
	

	// books.sort();//comparator 인터페이스 이해가 필요
	// 자료구조에서 반복함.
	

	public void sortBooksByISBN() {
		books.sort((b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn()));
    }

	public Book searchBookByTitle(String title) {
		 for (Book books : books) {
	            if (books.getTitle().equals(title)) {
	                return books;
	            }
	        }
	        return null;
	    }
	
}

public class 실습10장_컬렉션_C2_과제 {
	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		String[] arr = new String[5];
		arr[0] = "hong";
		arr[1] = "ong";
		arr[2] = "nong";
		arr[3] = "ng";
		arr[4] = "lee";

		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++) {
				// if(arr[i]>arr[j]) => 숫자가 아님으로 비교 연산이 안됨.
				if (arr[i].compareTo(arr[j]) > 0)
					swap(arr, i, j);
			}

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("\n현재 도서 목록:");

		library.sortBooksByTitle(); // 도서 목록 정렬
		// 최종 도서 목록 출력
		library.printBooks("\n\n정렬후 최종 도서 목록:");
		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		// 정렬된 도서 목록 출력
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else
			System.out.println("\n도서명으로 검색한 도서 ");
		System.out.println(foundBook.toString()+"\n"+ "-".repeat(60));
		

		library.removeBook(); // 정상 삭제
		
		// 도서 목록 출력
		library.printBooks("\n\n현재 도서 목록:");
	}
}