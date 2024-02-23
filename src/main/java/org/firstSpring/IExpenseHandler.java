package org.firstSpring;

public interface IExpenseHandler {
    public ApprovalResponse approve(IExpenseReport expenseReport);
    public void registerNext(IExpenseHandler next);
}
