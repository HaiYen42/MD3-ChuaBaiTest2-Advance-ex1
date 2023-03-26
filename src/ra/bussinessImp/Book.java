package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Book implements IShop, Comparable<Book>  {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPage;
    private int authorId;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPage, int authorId, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.authorId = authorId;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice() {
        this.exportPrice = importPrice*RATE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData(List<Author> list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sách");
        this.bookName = input.nextLine();
        System.out.println("Nhập Book Id");
        this.bookId= Integer.parseInt(input.nextLine());
        System.out.println("Nhập tiêu đê");
        this.title =input.nextLine();
        System.out.println("Nhập số trang sách");
        this.numberOfPage= Integer.parseInt(input.nextLine());
        // Nhâ tác giả
        System.out.println("Giá nhập");
        this.importPrice= Float.parseFloat(input.nextLine());
        System.out.println("Nhập số lợng sách");
        this.quantity =Integer.parseInt(input.nextLine());
        this.bookStatus =true;
        // thực hiện tính exportPrice
        setExportPrice();
        System.out.println("Giá xuất là "+ exportPrice);
        System.out.println("List tác giả là:");
        for (Author author: list
        ) {
            author.displayData(list);

        }
        System.out.println("nhập id tác giả");
        this.authorId = Integer.parseInt(input.nextLine());
    }

    @Override
    public void displayData(List<Author> list) {
        String authorName="";
        for (Author author:list) {
            if (author.getAuthorId()==this.authorId) {
                authorName= author.getAuthorName();
            }
        }
        System.out.println("Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", authorId=" + authorId +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", quantity=" + quantity +
                ", bookStatus=" + (bookStatus?"Còn hàng ": "Hết hàng") +
                '}');
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", authorId=" + authorId +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", quantity=" + quantity +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return (int)(this.exportPrice-o.getExportPrice());
    }
}
