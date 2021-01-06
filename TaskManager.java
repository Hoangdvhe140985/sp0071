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
public class TaskManager {
    public static void addTask(ArrayList<Task> le) {
        System.out.print("Requirement Name: ");
        String requirementName = Validate.checkInputString();
        System.out.println("You choice 1-4: Code - Test - Design - Review");
        System.out.print("Task Type: ");
        String taskTypeId = Validate.checkInputTaskTypeId();
        System.out.print("Date: ");
        String date = Validate.checkInputDate();
        System.out.print("From: ");
        String planFrom = Validate.checkInputPlan();         
        String planTo ;        
        do {
            System.out.print("Plan To: ");
            planTo = Validate.checkInputPlan();
            if (Double.parseDouble(planFrom) > Double.parseDouble(planTo)) {
                System.out.println("Plan From must less than Plan To");
            }
        } while (Double.parseDouble(planFrom) > Double.parseDouble(planTo));
        System.out.print("Assignee: ");
        String assign = Validate.checkInputString();
        System.out.print("Reviewer: ");
        String reviewer = Validate.checkInputString();
        int length = le.size();
        int id = le.get(length - 1).getId() + 1;
        le.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }

    public static void deleteTask(ArrayList<Task> le) {
        System.out.print("Enter id: ");
        //input id is interger number
        int id = Validate.inputIntLimit(0, Integer.MAX_VALUE);
        //check id input 
        int checkIdExist = findIdExist(le, id);
        //if id input != -1 remove id
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            System.out.println("Delete successful");
            //start from id remove - 1 to end size list                                                                                                                                                                            
            for (int i = id - 1; i < le.size(); i++) {
                //
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    private static int findIdExist(ArrayList<Task> le, int id) {
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    public static void display(ArrayList<Task> le) {
        if (le.size() == 0) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    le.get(i).getId(),
                    le.get(i).getRequirementName(),
                    le.get(i).getTaskTypeId(),
                    le.get(i).getDate(),
                    Double.parseDouble(le.get(i).getPlanTo()) - Double.parseDouble(le.get(i).getPlanFrom()),
                    le.get(i).getassign(),
                    le.get(i).getreviewer()
            );

        }
    }
}
