package org.firstSpring;

class Employee implements IExpenseApprover {

    private Integer approvalLimit;
    private String name;

    public Employee(String name, Integer approvalLimit) {
        this.name = name;
        this.approvalLimit = approvalLimit;
    }

    @Override
    public ApprovalResponse approveExpense(IExpenseReport expenseReport) {
        return expenseReport.getTolal() > this.approvalLimit
                ? new ApprovalResponse(ApprovalResponse.ApprovalResponseEnum.BeyondApprovalLimit, this)
                : new ApprovalResponse(ApprovalResponse.ApprovalResponseEnum.Approved, this);
    }

    @Override
    public String toString() {
        return "Employee{" + name + '}';
    }

    

}
