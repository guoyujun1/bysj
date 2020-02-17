package gj.model;

public class Major {
    private int mno;
    private String mname;
    private String aname;

    public Major(int mno,String mname,String aname){
        this.mno = mno;
        this.mname = mname;
        this.aname = aname;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
