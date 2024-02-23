package org.firstSpring;

public class ApprovalResponse
{
    ApprovalResponseEnum approvalResponseEnum;
    IExpenseApprover approver;

    public ApprovalResponse(ApprovalResponseEnum approvalResponseEnum){
        this.approvalResponseEnum = approvalResponseEnum;
    }
    public ApprovalResponse(ApprovalResponseEnum approvalResponseEnum, IExpenseApprover approver){
        this.approvalResponseEnum = approvalResponseEnum;
        this.approver = approver;
    }


    public enum ApprovalResponseEnum {
        Denied,
        Approved,
        BeyondApprovalLimit;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        switch(this.approvalResponseEnum){
            case Denied:
                s.append("Denied");
                break;
            case Approved:
                s.append("Approved");
                break;
            case BeyondApprovalLimit:
                s.append("BeyondApprovalLimit");
                break;
        }
        if (this.approver != null) s.append(" by " + approver.toString());
        return s.toString();
    }

    public ApprovalResponseEnum getApprovalResponseEnum(){
        return this.approvalResponseEnum;
    }

    public IExpenseApprover getApprover(){
        return approver;
    }


}
