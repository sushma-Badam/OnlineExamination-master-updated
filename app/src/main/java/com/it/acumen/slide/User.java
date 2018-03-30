package com.it.acumen.slide;

/**
 * Created by Sushma Badam on 27-03-2018.
 */

public class User {
    private String testname;
    private String branch;

    public User() {

    }

    public User(String testname, String branch) {
        this.testname = testname;
        this.branch = branch;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
