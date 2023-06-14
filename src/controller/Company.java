package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javax.security.auth.callback.Callback;
import model.Customer;
import util.Input;
import util.Validator;

/**
 *
 * @author Admin
 */
public class Company {
    
    static ArrayList<Customer> customerList = new ArrayList<>();
    
    public void addCustomer() {
        int id = Input.enterInt("ID", true, (idCheck -> {
            for (Customer c : customerList) {
                if (c.getCustomerID() == idCheck) {
                    return true;
                }
                
            }
            return false;
        }));
        String name = Input.enterString("Name");
        String phone = Input.enterString("Phone Number (10 numbers)", Validator.REGEX_PHONE_NUMBER);
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
    
    public void handleStatistical() {
        String numStr = Input.enterString("Phone Number Start With ", Validator.REGEX_NUMBER);
        ArrayList<Customer> phoneArr = search(c -> c.getPhone().startsWith(numStr));
        phoneArr.forEach(c -> System.out.println(c));
    }
    
}
