package com.xyzq.zh.lambda.chapter8.templatemethod;

/**
 * lambda优化模板方法-定义函数接口
 * 如果验证失败，抛出异常
 * 
 * 采用这种方法而不是基于继承的模式好处在于不需要在LoanAppByCriteria及其子类中实现算法，分配功能时有了更大的灵活性
 * 
 * @author zhanghua
 *
 */
public interface Criteria {
	
	public void check() throws Exception;
	
}
