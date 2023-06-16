/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import controller.Company;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;
import javax.security.auth.callback.Callback;

/**
 *
 * @author Admin
 */
public class Input {

    static Scanner sc = new Scanner(System.in);
    private static final String ERR_MESSAGE = "Wrong Input ! Please Re-enter ";
    private static final String REGEX_NOT_MATCH = "Input Not Valid ! Please Re-enter ";

    public static String enterString(String mess) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            return str;

        }
    }

    static public String enterString(String mess, String regex) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = Validator.checkRegex(str, regex);
            if (isTrue) {
                return str;
            } else {
                System.out.println(REGEX_NOT_MATCH);
            }

        }
    }

    public static int enterInt(String mess, boolean check,Predicate<Integer> duplicate) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (intVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {
                    if(duplicate.test(intVar)){
                        System.out.println(mess +" has exist");
                    } else {
                        return intVar;
                        
                    }
                }
            } else {
                return intVar;
            }
        }
    }

    public static int enterInt(String mess, boolean check) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (intVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {

                    return intVar;

                }
            } else {
                return intVar;
            }
        }
    }

    public static float enterFloat(String Mess, boolean check) {
        float floatVar;
        while (true) {
            System.out.println("Enter " + Mess + " :");
            try {
                floatVar = Float.parseFloat(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (floatVar < 0) {
                    System.out.println(Mess + " must greater than 0");
                } else {
                    return floatVar;
                }
            } else {
                return floatVar;
            }
        }
    }
}
