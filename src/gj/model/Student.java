package gj.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * ѧ����Ϣģ����,�������ݿ������Ӧ�ֶε�get��set����
 * 
 */

public class Student {
	//ѧ��
	private long no;
	//����
	private String name;
	//�༶
	private String clas;
	//רҵ����
	private int mno;
	//רҵ����
	private String mname;
	//�γ̴���
	private int cno;
	//�γ�����
	private String cname;
	//ƽʱ�ɼ�
	private float regulargrade;
	//���Գɼ�
	private float testgrade;
	//�ܳɼ�
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
	 * ��ȡsno
	 * @return 
	 */
	public long getno() {
		return no;
	}
	/**
	 * ����sno
	 */
	public void setno(long No) {
		no = No;
	}
	
	/**
	 * ��ȡsname
	 */
	public String getname() {
		return name;
	}
	/**
	 * ����sname
	 */
	public void setname(String Name) {
		name = Name;
	}

	/**
	 * ��ȡclas
	 */
	public String getclas() {
		return clas;
	}
	/**
	 * ����clas
	 */
	public void setclas(String Clas) {
		clas = Clas;
	}
	
	/**
	 * ��ȡmno
	 */
	public int getmno() {
		return mno;
	}
	/**
	 * ����mno
	 */
	public void setmno(int Mno) {
		mno = Mno;
	}
	
	/**
	 * ��ȡmname
	 */
	public String getmname() {
		return mname;
	}
	/**
	 * ����mname
	 */
	public void setmname(String Mname) {
		mname = Mname;
	}
	
	/**
	 * ��ȡcno
	 */
	public int getcno() {
		return cno;
	}
	/**
	 * ����cno
	 */
	public void setcno(int Cno) {
		cno = Cno;
	}
	
	/**
	 * ��ȡcname
	 */
	public String getcname() {
		return cname;
	}
	/**
	 * ����cname
	 */
	public void setcname(String Cname) {
		cname = Cname;
	}
	
	/**
	 * ��ȡƽʱ�ɼ�
	 */
	public float getregulargrade() {
		return regulargrade;
	}
	/**
	 * ����ƽʱ�ɼ�
	 */
	public void setregulargrade(float Regulargrade) {
		this.regulargrade = Regulargrade;
	}
	
	/**
	 * ��ȡ���Գɼ�
	 */
	public float gettestgrade() {
		return testgrade;
	}
	/**
	 * ���ÿ��Գɼ�
	 */
	public void settestgrade(float Testgrade) {
		this.testgrade = Testgrade;
	}
	
	/**
	 * ��ȡ�ܳɼ�
	 */
	public float getgrade() {
		return grade;
	}

	/**
	 * �����ܳɼ�
	 */
	public void setgrade(float Grade) {
		this.grade = Grade;
	}

}
