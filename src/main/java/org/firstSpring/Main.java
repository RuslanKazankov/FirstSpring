package org.firstSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IExpenseHandler abc = (IExpenseHandler) context.getBean("abcHandler");
        IExpenseHandler abd = (IExpenseHandler) context.getBean("abdHandler");
        IExpenseHandler abe = (IExpenseHandler) context.getBean("abeHandler");
        IExpenseHandler abf = (IExpenseHandler) context.getBean("abfHandler");

        abc.registerNext(abd);
        abd.registerNext(abe);
        abe.registerNext(abf);
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int expenseReportAmount;
        expenseReportAmount = in.nextInt();
        IExpenseReport expense = (IExpenseReport) context.getBean("expenseReport",expenseReportAmount);
        expenseReportAmount = in.nextInt();
        IExpenseReport expense1 = (IExpenseReport) context.getBean("expenseReport",expenseReportAmount);

        
        ApprovalResponse response = abc.approve(expense);
        ApprovalResponse response1 = abc.approve(expense1);

        System.out.println("The request was "+ response);
        System.out.println("The request was "+ response1);
        System.out.println("The total from first expense was " + expense.getTolal());
        System.out.println("The total from second expense was " + expense1.getTolal());

    }
}
