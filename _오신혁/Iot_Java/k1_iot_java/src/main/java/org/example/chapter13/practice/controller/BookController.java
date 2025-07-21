package org.example.chapter13.practice.controller;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.service.BookServiceImpl;
import org.example.chapter13.practice.view.BookView;

import java.util.List;

public class BookController {
    // 싱글톤 패턴 인스턴스화(BookServiceImpl)
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();


    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getInputMenuNumber();

            switch (choice) {
                case 1:
                    Book book = view.getBookDetails();
                    if (book != null) service.addBook(book);
                    else System.out.println("필수 데이터 값을 다시 확인해주세요.");

                case 2: // 단건 조회: 요청 데이터 o, 반환 데이터 o
                    String findBookId = view.getInputString("ID");
                    if (findBookId != null) {
                        String foundBook = view.getInputString("ID");
                        view.displayBook(foundBook);
                    }
                    break;
                case 3:
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                case 4: // 도서 수정
                    String updateId = view.getInputString("ID");
                    if (updateId != null) {
                        Book updatedBook = view.getBookDetails();
                        if (updatedBook != null) {
                            service.updateBook(updateId, updatedBook);
                        }
                    }
                    break;
                case 5: // 도서 삭제
                    String removeId = view.getInputString("ID");
                    if (removeId != null) {
                        service.deleteBook(removeId);
                    }
                    break;
                case 0:
                    System.out.println("프로그램을 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 입력해주세요.");
                    
            }
        }
    }
}
