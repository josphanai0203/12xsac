/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {
    static Scanner sc = new Scanner(System.in);
    static CompanyManagement cm = new CompanyManagement();
    
    public void displayMenu() {
        int choice = 0;
        while (true) {
            System.out.println("====== Welcome To Employee Manager ===========");
            System.out.println("1. List All Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Add New Customer");
            System.out.println("4. Customer Statistical");
            System.out.println("5. Exit");
            System.out.println("================ END ================");
            System.out.println("Nhập lựa chọn của bạn :");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input ! Please re-enter");
                continue;
            }
            switch (choice) {
                case 1:
                    cm.display();
                    break;
                case 2:
                   cm.search();
                    break;
                case 3:
                    cm.add();
                    break;
                case 4:
                    cm.displayStatistical();
                    break;
                case 5:

                    break;

                default:
                    System.out.println("You must choice 1 to 5 ! Please re-enter");
            }
            if (choice == 5) {
                System.out.println("GoodBye");
                break;
            }

        }
    }
    

}
