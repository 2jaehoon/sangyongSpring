package kr.co.sist.domain;

import java.sql.Date;

public class EmpDomain {
	private int empno, mgr, sal, comm, deptno;
	private String ename, job;
	private Date hiredate;
	
	
	
	public EmpDomain() {
		
	}



	public EmpDomain(int empno, int mgr, int sal, int comm, int deptno, String ename, String job, Date hiredate) {
		this.empno = empno;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}



	public int getEmpno() {
		return empno;
	}



	public void setEmpno(int empno) {
		this.empno = empno;
	}



	public int getMgr() {
		return mgr;
	}



	public void setMgr(int mgr) {
		this.mgr = mgr;
	}



	public int getSal() {
		return sal;
	}



	public void setSal(int sal) {
		this.sal = sal;
	}



	public int getComm() {
		return comm;
	}



	public void setComm(int comm) {
		this.comm = comm;
	}



	public int getDeptno() {
		return deptno;
	}



	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public Date getHiredate() {
		return hiredate;
	}



	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}



	@Override
	public String toString() {
		return "EmpDomain [empno=" + empno + ", mgr=" + mgr + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno
				+ ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + "]";
	}
	
	

}
