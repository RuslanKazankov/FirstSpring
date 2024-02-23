package org.firstSpring;

public class EndOfChainExpenseHandler implements IExpenseHandler {
    private static EndOfChainExpenseHandler instance;
    private EndOfChainExpenseHandler(){}

    public static EndOfChainExpenseHandler getInstance(){
        if(instance == null){
            instance = new EndOfChainExpenseHandler();
        }
        return instance;
    }


    @Override
    public ApprovalResponse approve(IExpenseReport expenseReport) {
        return new ApprovalResponse(ApprovalResponse.ApprovalResponseEnum.BeyondApprovalLimit);
    }

    @Override
    public void registerNext(IExpenseHandler next) {

    }
}
