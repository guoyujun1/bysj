package gj.model;

public class Course {
    private int cno;
    private String cname;
    private String mname;
    private String tname;

    public Course (int cno,String cname,String mname,String tname){
        this.cno = cno;
        this.cname = cname;
        this.mname = mname;
        this.tname = tname;
    }

    public int getCno() {
        return cno;
    }


    public void setCno(int cno) {
        this.cno = cno;
    }


    public String getCname(){
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getMname() {
        return mname;
    }


    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tno) {
        this.tname = tname;
    }
}

