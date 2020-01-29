package com.xyzq.zh.lambda.chapter8.dsl;

import com.xyzq.zh.lambda.chapter8.dsl.reporting.ConsoleFormatter;
import com.xyzq.zh.lambda.chapter8.dsl.reporting.Report;
import com.xyzq.zh.lambda.chapter8.dsl.reporting.ReportFormatter;
import com.xyzq.zh.lambda.chapter8.dsl.reporting.Result;
import com.xyzq.zh.lambda.chapter8.dsl.reporting.SpecificationReport;

public enum Runner {

    current;

    private final Report report;

    private Runner() {
        report = new Report();
    }

    void recordSuccess(String suite, String specification) {
        report.newSpecification(suite, new SpecificationReport(specification));
    }

    void recordFailure(String suite, String specification, AssertionError cause) {
        SpecificationReport specificationReport = new SpecificationReport(specification, Result.FAILURE, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    void recordError(String suite, String specification, Throwable cause) {
        cause.printStackTrace();
        SpecificationReport specificationReport = new SpecificationReport(specification, Result.ERROR, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    public void printReport() {
        ReportFormatter formatter = new ConsoleFormatter();
        formatter.format(report);
    }

    public void run(Class<?> stackSpecClass) {
        try {
            stackSpecClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
