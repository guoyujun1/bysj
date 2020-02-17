package gj.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息模型类,包含数据库各表相应字段的get、set方法
 * 
 */

public class Student {
	//学号
	private long no;
	//姓名
	private String name;
	//班级
	private String clas;
	//专业代号
	private int mno;
	//专业名称
	private String mname;
	//课程代号
	private int cno;
	//课程名称
	private String cname;
	//平时成绩
	private float regulargrade;
	//考试成绩
	private float testgrade;
	//总成绩
	private float grade;


	public Student() {
	}
	public Student(long no, String name, String mname, String clas) {
		this.no = no;
		this.name = name;
		this.mname = mname;
		this.clas = clas;
	}


	/**
	 * 获取sno
	 * @return 
	 */
	public long getno() {
		return no;
	}
	/**
	 * 设置sno
	 */
	public void setno(long No) {
		no = No;
	}
	
	/**
	 * 获取sname
	 */
	public String getname() {
		return name;
	}
	/**
	 * 设置sname
	 */
	public void setname(String Name) {
		name = Name;
	}

	/**
	 * 获取clas
	 */
	public String getclas() {
		return clas;
	}
	/**
	 * 设置clas
	 */
	public void setclas(String Clas) {
		clas = Clas;
	}
	
	/**
	 * 获取mno
	 */
	public int getmno() {
		return mno;
	}
	/**
	 * 设置mno
	 */
	public void setmno(int Mno) {
		mno = Mno;
	}
	
	/**
	 * 获取mname
	 */
	public String getmname() {
		return mname;
	}
	/**
	 * 设置mname
	 */
	public void setmname(String Mname) {
		mname = Mname;
	}
	
	/**
	 * 获取cno
	 */
	public int getcno() {
		return cno;
	}
	/**
	 * 设置cno
	 */
	public void setcno(int Cno) {
		cno = Cno;
	}
	
	/**
	 * 获取cname
	 */
	public String getcname() {
		return cname;
	}
	/**
	 * 设置cname
	 */
	public void setcname(String Cname) {
		cname = Cname;
	}
	
	/**
	 * 获取平时成绩
	 */
	public float getregulargrade() {
		return regulargrade;
	}
	/**
	 * 设置平时成绩
	 */
	public void setregulargrade(float Regulargrade) {
		this.regulargrade = Regulargrade;
	}
	
	/**
	 * 获取考试成绩
	 */
	public float gettestgrade() {
		return testgrade;
	}
	/**
	 * 设置考试成绩
	 */
	public void settestgrade(float Testgrade) {
		this.testgrade = Testgrade;
	}
	
	/**
	 * 获取总成绩
	 */
	public float getgrade() {
		return grade;
	}

	/**
	 * 设置总成绩
	 */
	public void setgrade(float Grade) {
		this.grade = Grade;
	}

}
