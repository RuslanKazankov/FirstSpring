package org.firstSpring;


public class ExpenseReport implements IExpenseReport {
    private Integer total;

    public ExpenseReport(Integer total) {
        this.total = total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }    

    @Override
    public Integer getTolal() {
       return this.total;
    }

}
