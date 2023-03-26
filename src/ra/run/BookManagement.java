package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public  class BookManagement {
    static  Scanner input = new Scanner(System.in);
    static List<Author>listAuthor = new ArrayList<>();
    static List<Book> listBook= new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println(
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                            "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                            "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) [10 điểm]\n" +
                            "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                            "5. Thoát [05 điểm]");
            System.out.println("Nhập lựa chọn: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    inputAuthorInfor();
                    break;
                case 2:
                    inputBookInfor();
                    break;
                case 3:
                    System.out.println("Sắp xếp sách theo giá xuất tăng dần");
                    Collections.sort(listBook);
                    for (Book book:listBook) {
                        book.displayData(listAuthor);
                    }
                    break;
                case 4:
                    findBookViaAuthorName();
                    break;
                case 5:
                    System.out.println("Bạn đã thoát khỏi chương trình ");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn ko hợp lệ");
            }
        }
    }
    //Option 1:
    public static void inputAuthorInfor(){
        System.out.println("Enter number of author");
        int quantity=input.nextInt();
        for (int i = 0; i < quantity; i++) {
            listAuthor.add(new Author());
            listAuthor.get(i).inputData(listAuthor);
        }
    }
    public static void inputBookInfor(){
        System.out.println("Enter the number of Book ");
        int quantity= input.nextInt();
        for (int i = 0; i < quantity; i++) {
            listBook.add(new Book());
            listBook.get(i).inputData(listAuthor);
        }
    }
    public static void findBookViaAuthorName(){
        System.out.println("Enter author Name ");
        input.nextLine();
        String authorName= input.nextLine();
        int authorId=0;
        for (Author author:listAuthor) {
            if (authorName.equalsIgnoreCase(author.getAuthorName())) {
                authorId=author.getAuthorId();
            }
        }
        for (Book book:listBook) {
            if (book.getAuthorId()==authorId) {
                book.displayData(listAuthor);
            }
        }
    }
}

