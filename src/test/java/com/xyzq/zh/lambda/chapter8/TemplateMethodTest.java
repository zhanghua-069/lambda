package com.xyzq.zh.lambda.chapter8;

import org.junit.Test;

import com.xyzq.zh.lambda.chapter8.templatemethod.Company;
import com.xyzq.zh.lambda.chapter8.templatemethod.CompanyLoanApplication;

public class TemplateMethodTest {
	
	@Test
	public void test() throws Exception {
		new CompanyLoanApplication(new Company()).checkLoanApplication();
	}
	
}
