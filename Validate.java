/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sp0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    static int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    static String checkInputDate() {       
        while (true) {
            try {
                String result = in.nextLine().trim();
                //date format according to pattern
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                //convert string to fomat date
                Date date = format.parse(result);
                //result not equals with format date throw exception
                if (!result.equalsIgnoreCase(format.format(date))) {
                    throw new Exception();
                } else {
                    return result;
                }
            } catch (Exception ex) {
                System.out.println("Please reenteer date (dd-MM-yyyy)");
            }
        }
    }

    static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
  
    static String checkInputTaskTypeId() {       
        while (true) {                       
            int n = inputIntLimit(1, 4);            
            String result = null;
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Design";
                    break;
                case 4:
                    result = "Review";
            }
            return result;
        }
    }

    static String checkInputPlan() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }
}
