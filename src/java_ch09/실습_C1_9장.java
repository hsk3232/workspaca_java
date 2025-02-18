package java_ch09;

import java.sql.Array;
import java.util.Arrays;

/*
도서 관리 시스템은 다양한 책을 관리하고, 고객이 도서를 대여하거나 반납할 수 있게 하는 기능을 제공합니다. 또한, 고객의 대여 기록을 관리하고, 특정 조건에 맞는 책을 검색하거나 필터링하는 기능도 구현합니다.

1단계: 기본 클래스 및 컬렉션 사용
목표: Book 클래스 생성 및 기본 컬렉션 사용
설계:
Book 클래스: 제목, 저자, 출판 연도, ISBN 등을 속성으로 가짐
Library 클래스: 도서 목록을 관리하는 기능 (책 추가, 책 목록 출력)
과제:
Book 클래스를 작성하고 도서 정보를 담는 객체를 생성하세요.
Library 클래스를 작성해 ArrayList를 사용하여 도서를 관리하고, 도서 목록을 출력하세요.
 */
// Book 클래스
class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String iSBN;

	public Book(String title, String author, int publicationYear, String iSBN) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.iSBN = iSBN;
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

	public String getISBN() {
		return iSBN;
	}

	public void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}

	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, iSBN);
	}

}

// Library 클래스
class Library {
	static final int CAPACITY = 20;
	private Book[] books = new Book[CAPACITY];
	private int top;
	
	

	public Library() {
		System.out.println(Array.toString(books));
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public boolean addBook(Book book) {
		for(top = 0; top > CAPACITY; top++) {
			books[top] = book;
		}
			return true;
	}

	public void printBooks(String msg) {
		System.out.println(msg);
		
		
	}

	public void sortBooksByTitle() {
		// String의 compareTo() 사용
		Arrays.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));// 9.3.3 Arrays 클래스
	}// 0부터 top까지 코드 중 2개씩 꺼내서 비교하는데, 스트링 클래스 getTiltle을 호출해서 비교하는 람다식

	public void sortBooksByISBN() {
		// String의 compareTo() 사용
		Arrays.sort(books, (b1, b2) -> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));// 9.3.3
		// for문 중첩 써서 가능하니 생각해 볼것. // Arrays
		// 클래스
	} // for(int i = 0; i< ; i++)
		// for(int j = i+1; j<)
		// if(arr[i]> arr[j])
		// swap(arr, i, j)
	
	
	

	public Book searchBookByTitle(String title) {
		

	}
}

public class 실습_C1_9장 {
	public static void main(String[] args) {
		Library library = new Library();
		String st = "java";
		String st2 = "java";// string interning
		// the process of storing one unique instance of each distinct string value in a
		// pool to optimize memory,
		// so that multiple references to the same string literal point to the same
		// memory location.
		if (st.equals(st2))
			System.out.println("st == st2");

		// 5개의 Book 객체 초기화
		// 5개의 책 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C++", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");
		
		// 책 추가
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);
		
		// 도서 목록 출력
		library.printBooks("\n제목정렬전");
		// 도서 목록 정렬
		library.sortBooksByTitle();
		// 정렬된 도서 목록 출력
		library.printBooks("\n제목정렬후");
		// 특정 제목으로 도서 검색
		library.printBooks("\nISBN정렬전");
		// 도서 목록 정렬
		library.sortBooksByISBN();
		// 정렬된 도서 목록 출력
		library.printBooks("\nISBN정렬후");
		
		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else
			System.out.println("\n도서명으로 검색한 도서" + foundBook.toString());
	}
}