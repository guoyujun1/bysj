package gj.model;

public class Grade {
    private long sno;
    private int cno;
    private String cname;
    //平时成绩
    private float regulargrade;
    //考试成绩
    private float testgrade;
    //总成绩
    private float grade;

    public Grade(long sno,String cname,float regulargrade,float testgrade,float grade ){
        this.sno = sno;
        this.cname = cname;
        this.regulargrade = regulargrade;
        this.testgrade = testgrade;
        this.grade = grade;
    }

    public long getSno() {
        return sno;
    }

    public void setSno(long sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public float getRegulargrade() {
        return regulargrade;
    }

    public void setRegulargrade(float regulargrade) {
        this.regulargrade = regulargrade;
    }

    public float getTestgrade() {
        return testgrade;
    }

    public void setTestgrade(float testgrade) {
        this.testgrade = testgrade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
