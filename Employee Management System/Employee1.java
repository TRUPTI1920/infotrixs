import java.util.*;
import java.io.*;
class Employee1 implements Serializable
{
	int empno;
	String ename;
	int salary;

	Employee1(int empno , String ename,int salary){
		this.empno = empno ;
		this.ename = ename ;
		this.salary = salary;
	}
	public String toString(){
		return empno+" "+ename+" "+salary;
	}
}
