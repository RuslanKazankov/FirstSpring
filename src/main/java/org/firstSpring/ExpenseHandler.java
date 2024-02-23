package org.firstSpring;

public class ExpenseHandler implements IExpenseHandler {
    private IExpenseApprover approver;
    private IExpenseHandler next;

    public ExpenseHandler(IExpenseApprover expenseApprover){
        approver = expenseApprover;
        next = EndOfChainExpenseHandler.getInstance();
    }

    @Override
    public ApprovalResponse approve(IExpenseReport expenseReport) {
        ApprovalResponse approvalResponse = approver.approveExpense(expenseReport);
        return approvalResponse.getApprovalResponseEnum() != ApprovalResponse.ApprovalResponseEnum.BeyondApprovalLimit ? approvalResponse : next.approve(expenseReport);
    }

    @Override
    public void registerNext(IExpenseHandler next) {
        this.next = next;
    }
}
