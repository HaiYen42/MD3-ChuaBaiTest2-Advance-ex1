package ra.bussiness;

import ra.bussinessImp.Author;

import java.util.List;

public interface IShop {
    float RATE =1.3F;

    void inputData(List<Author> list);

    void displayData(List<Author> list);
}
