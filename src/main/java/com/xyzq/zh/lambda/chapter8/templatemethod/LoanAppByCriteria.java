package com.xyzq.zh.lambda.chapter8.templatemethod;

/**
 * 使用lambda表达式优化模板方法模式
 * 
 * @author zhanghua
 *
 */
public class LoanAppByCriteria {

	private final Criteria identity;
	private final Criteria creditHistory;
	private final Criteria incomeHistory;
	
	/**
	 * identity,creditHistory,incomeHistory代表3个函数接口，用lambda表达式实现时可用任意对应的lambda函数替代
	 * 
	 * @param identity
	 * @param creditHistory
	 * @param incomeHistory
	 */
	public LoanAppByCriteria(Criteria identity, Criteria creditHistory, Criteria incomeHistory) {
		this.identity = identity;
		this.creditHistory = creditHistory;
		this.incomeHistory = incomeHistory;
	}
	
	/**
	 * 通过函数接口将不同的算法实现注入模板方法中
	 * 
	 * @throws Exception
	 */
	public void checkLoanApplication() throws Exception {
		identity.check();
		creditHistory.check();
		incomeHistory.check();
		reportFindings();
	}
	
	private void reportFindings() {
		System.out.println("LoanAppByCriteria.reportFindings");
	}

}
