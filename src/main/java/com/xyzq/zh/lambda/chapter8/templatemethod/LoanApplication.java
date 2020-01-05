package com.xyzq.zh.lambda.chapter8.templatemethod;

/**
 * 模板方法模式-抽象方法一般实现
 * 使用模板方法模式描述申请贷款过程
 * 
 * @author zhanghua
 *
 */
public abstract class LoanApplication {
	
	/**
	 * 模板方法申请贷款过程
	 * 
	 * @throws Exception
	 */
	public void checkLoanApplication() throws Exception {
		checkIdentity();
		checkIncomeHistory();
		checkCreditHistory();
		reportFindings();
	}
	
	/**
	 * 申请贷款-验证身份
	 * 
	 * @throws Exception
	 */
	protected abstract void checkIdentity() throws Exception;
	/**
	 * 申请贷款-收入记录
	 * 
	 * @throws Exception
	 */
	protected abstract void checkIncomeHistory() throws Exception;
	/**
	 * 申请贷款-信用记录
	 * 
	 * @throws Exception
	 */
	protected abstract void checkCreditHistory() throws Exception;
	
	/**
	 * 生成报告
	 * 
	 */
	private void reportFindings() {
		
	}
	
}
