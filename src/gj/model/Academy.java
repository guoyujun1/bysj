package gj.model;

public class Academy {
    private int ano;
    private String aname;

    public Academy(int ano,String aname){
        this.ano = ano;
        this.aname = aname;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
