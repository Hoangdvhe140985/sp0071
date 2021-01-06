/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sp0071;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    

    public static void main(String[] args) {
        ArrayList<Task> le = new ArrayList<>();
        le.add(new Task(1, "Dev Program", "Code", "26-06-2015", "9.5", "17.5", "Dev", "Lead"));
        int id = 1;
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validate.inputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    TaskManager.addTask(le);
                    break;
                case 2:
                    TaskManager.deleteTask(le);
                    id--;
                    break;
                case 3:
                    TaskManager.display(le);
                    break;
                case 4:
                    return;

            }
        }
    }
}
