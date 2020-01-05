package com.xyzq.zh.lambda.chapter8.templatemethod;

/**
 * 模板化方法的lambda表达式调用
 * 
 * @author zhanghua
 *
 */
public class CompanyLoanApplication extends LoanAppByCriteria {
	
	/**
	 * 将检查方法交给Company类实现
	 * 
	 * @param company
	 */
	public CompanyLoanApplication(Company company) {
		// 使用3个lambda表达式对应构造器的3个函数接口
		super(company::checkIdentity, 
				company::checkProfitAndLoss, 
				company::checkHistoricalDebt);
	}

}
