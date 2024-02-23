package org.firstSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    public Employee abc(){
        return new Employee("abc", 10);
    }
    @Bean
    public Employee abd(){
        return new Employee("abd", 100);
    }
    @Bean
    public Employee abe(){
        return new Employee("abe", 1000);
    }
    @Bean
    public Employee abf(){
        return new Employee("abf", 10000);
    }

    @Bean
    public ExpenseHandler abcHandler(){
        return new ExpenseHandler(abc());
    }
    @Bean
    public ExpenseHandler abdHandler(){
        return new ExpenseHandler(abd());
    }
    @Bean
    public ExpenseHandler abeHandler(){
        return new ExpenseHandler(abe());
    }
    @Bean
    public ExpenseHandler abfHandler(){
        return new ExpenseHandler(abf());
    }

    @Bean
    @Scope(value = "prototype")
    public ExpenseReport expenseReport(Integer total){
        return new ExpenseReport(total);
    }

}
