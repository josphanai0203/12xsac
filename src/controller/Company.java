package controller;

import java.util.ArrayList;
import java.util.function.Predicate;
import model.Customer;
import util.Input;
import util.ValidatorUtils;

/**
 *
 * @author Admin
 */
public class Company {
    
    public static ArrayList<Customer> customerList = new ArrayList<>();
    
    public void addCustomer(int id , String name,String phone) {
        customerList.add(new Customer(id, name, phone));
    }
    
    public void displayListCustomer() {
        customerList.forEach(c -> System.out.println(c));
    }
    
    public ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> rs = new ArrayList<>();
        for (Customer s : customerList) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
        
    }
    
    public int totalCustomer() {
        return customerList.size();
    }
    
    public void displayCustomerList(ArrayList<Customer> list) {
        for(Customer c:list){
            System.out.println(c);
        }
       
    }
    
}
