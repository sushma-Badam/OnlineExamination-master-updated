package com.it.acumen.slide;

/**
 * Created by ohlordino on 29/3/18.
 */

public class Test {
    private String startdate;
    private String branch;
    private String enddate;
    private String testname;

    public Test()
    {

    }
    public Test(String startdate, String branch, String enddate, String testname) {
        this.startdate = startdate;
        this.branch = branch;
        this.enddate = enddate;
        this.testname = testname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }
}
