package gj.model;

public class Teacher {
    //��ʦ����
    private String tno;
    //��ʦ����
    private String tname;

    public Teacher(String tno,String tname){
     this.tno = tno;
     this.tname = tname;
    }

    /**
     * ��ȡtno
     * @return
     */
    public String getTno(){
        return tno;
    }

    /**
     * ����tno
     * @param Tno
     */
    public  void setTno(String Tno){
        tno = Tno;
    }

    /**
     * ��ȡtname
     * @return
     */
    public String getTname(){
        return tname;
    }

    /**
     * ����tname
     * @param Tname
     */
    public void setTname(String Tname){
        tname = Tname;
    }
}