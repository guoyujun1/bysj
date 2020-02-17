package gj.model;

public class Teacher {
    //教师工号
    private String tno;
    //教师姓名
    private String tname;

    public Teacher(String tno,String tname){
     this.tno = tno;
     this.tname = tname;
    }

    /**
     * 获取tno
     * @return
     */
    public String getTno(){
        return tno;
    }

    /**
     * 设置tno
     * @param Tno
     */
    public  void setTno(String Tno){
        tno = Tno;
    }

    /**
     * 获取tname
     * @return
     */
    public String getTname(){
        return tname;
    }

    /**
     * 设置tname
     * @param Tname
     */
    public void setTname(String Tname){
        tname = Tname;
    }
}