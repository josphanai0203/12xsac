/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import util.Input;
import util.ValidatorUtils;

/**
 *
 * @author Admin
 */
public class CompanyManagement {

    static Company c = new Company();
    static Scanner sc = new Scanner(System.in);

    public void add() {
        int id = Input.enterInt("ID", true, (idCheck -> {
            for (Customer c :Company.customerList) {
                if (c.getCustomerID() == idCheck) {
                    return true;
                }
                
            }
            return false;
        }));
        String name = Input.enterString("Name");
        String phone = Input.enterString("Phone Number (10 numbers)", ValidatorUtils.REGEX_PHONE_NUMBER);
        c.addCustomer(id,name,phone);
    }

    public void display() {
        System.out.println("-----------------------");
        c.displayListCustomer();
        System.out.println("-----------------------");
        System.out.println("Total : " + c.totalCustomer() + " customers");
    }

    public void search() {
        displayFindMenu();
    }

    public void displayFindMenu() {
        int choice = 0;
        while (true) {
            System.out.println("============= Find Menu =============");
            System.out.println("1. Find By CustomerID");
            System.out.println("2. Find By Name ");
            System.out.println("3. Return");
            System.out.println("================ END ================");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input ! Please re-enter");
                continue;
            }
            ArrayList<Customer> searchArr;
            switch (choice) {
                case 1:
                    int id = Input.enterInt("ID Search", true);
                    searchArr = c.search(customer -> customer.getCustomerID() == id);
                    if (searchArr.isEmpty()) {
                        System.out.println("Customer not found ");
                    } else {
                         c.displayCustomerList(searchArr);
                    }
                    break;
                case 2:
                    String name = Input.enterString("Name Search");
                    searchArr = c.search(customer -> customer.getName().equals(name));
                    if (searchArr.isEmpty()) {
                        System.out.println("Customer not found ");
                    } else {
                        c.displayCustomerList(searchArr);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("You must choice 1 to 3 ! Please re-enter");
            }
            if (choice == 3) {
                break;
            }
        }
    }

    public void displayStatistical() {
         String numStr = Input.enterString("Phone Number Start With ", ValidatorUtils.REGEX_NUMBER);
        ArrayList<Customer> phoneArr = c.search(c -> c.getPhone().startsWith(numStr));
        if(phoneArr.isEmpty()){
            System.out.println("No Customer found");
        }else{
            c.displayCustomerList(phoneArr);
        }
    }

}
