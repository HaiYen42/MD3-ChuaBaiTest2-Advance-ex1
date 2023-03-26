package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    @Override
    public void inputData(List<Author> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Author Id: ");
        setAuthorId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter Author Name: ");
        setAuthorName(scanner.nextLine());
        System.out.println("Enter Author Sex: ");
        setSex(scanner.nextBoolean());
        System.out.println("Enter year of birth of Author: ");
        setYear(scanner.nextInt());
    }

    @Override
    public void displayData(List<Author> list) {
        System.out.println("Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", sex=" + sex +
                ", year=" + year +
                '}');
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", sex=" + (sex?"Nam": "Nữ") +
                ", year=" + year +
                '}';
    }
}
