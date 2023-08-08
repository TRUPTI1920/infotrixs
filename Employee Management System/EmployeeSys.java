import java.util.*;
import java.io.*;



class EmployeeSys
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		File file = new File("employee.text");
		ArrayList<Employee1> alist = new ArrayList<Employee1>();
		ObjectOutputStream oos = null; 
		ObjectInputStream ois = null;
		ListIterator li = null;

		if (file.isFile())
		{
			ois = new ObjectInputStream(new FileInputStream(file));
			alist = (ArrayList<Employee1>)ois.readObject();
			ois.close();
		}

		int choice = -1;

		do{
			System.out.println("!!-----Employee Management System-----!!");
			System.out.println("1.Add Employee: ");
			System.out.println("2.Display Employees: ");
			System.out.println("3.Find the Employee: ");
			System.out.println("4.Delete the Details of Employee: ");
			System.out.println("5.Update the Details of Employee: ");
			System.out.println("0.Exit.");
			System.out.println("Please enter your choice:");
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("How many employees you want to Add: ");
				int n = sc.nextInt();
				for (int i = 0;i<n ; i++)
				{
				
				System.out.print("Enter employee Id: ");
				int empno = sc.nextInt();

				System.out.print("Enter employee Name: ");
				String ename = sc1.nextLine();

				System.out.print("Enter employee Salary: ");
				int salary = sc.nextInt();

				alist.add(new Employee1(empno,ename,salary));
			}
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(alist);
				oos.close();
				break;

			case 2 :
				if (file.isFile())
				{
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(alist);
				oos.close();
				System.out.println("*-----------------*");
				li = alist.listIterator();
				while (li.hasNext())
				System.out.println(li.next());
				System.out.println("*-----------------*");
				}else{
					System.out.println("File is not Exist!");
				}
			break;

			case 3 :
				if (file.isFile())
				{
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(alist);
					oos.close();

					boolean found = false;
					System.out.println("Enter Employee Id to Search: ");
					int empno = sc.nextInt();
					System.out.println("-------------");
					li = alist.listIterator();
					while (li.hasNext()){
						Employee1 e = (Employee1)li.next();
						if (e.empno==empno)
							{
								System.out.println(e);
								found= true;
							}
					}	
						if (!found)
							{
								System.out.println("Details not found..!!");
							}
				}		
						else{
								System.out.println("File is not Exist!");
							}
			
				
						System.out.println("-------------");
						break;


			case 4 :
				if (file.isFile())
				{
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(alist);
					oos.close();

					boolean found = false;
					System.out.print("Enter Employee Id to Delete: ");
					int empno = sc.nextInt();
					System.out.println("-------------");
					li = alist.listIterator();
					while (li.hasNext()){
						Employee1 e = (Employee1)li.next();
						if (e.empno==empno)
							{
								li.remove();
								found= true;
							}
					}	
						if (found)
							{
							oos= new ObjectOutputStream(new FileOutputStream(file));
								oos.writeObject(alist);
								oos.close();
								System.out.println("Details Deleted Successfully..!!");
								
							}else{
								System.out.println("Details is not found..!!");
								
							}
				}		
						else{
								System.out.println("File not Exist!!");
							}
			
				
						System.out.println("-------------");
						break;

		case 5 :
				if (file.isFile())
				{
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(alist);
					oos.close();

					boolean found = false;
					System.out.print("Enter Employee Id to Update: ");
					int empno = sc.nextInt();
					System.out.println("-------------");
					li = alist.listIterator();
					while (li.hasNext()){
						Employee1 e = (Employee1)li.next();
						if (e.empno==empno)
							{
								System.out.print("Enter new Employee Name: ");
								String ename= sc1.nextLine();

								System.out.print("Enter new Employee Salary: ");
								int salary = sc.nextInt();
								li.set(new Employee1(empno,ename,salary));
								
								
								found= true;
							}
					}	
						if (found)
							{
							oos= new ObjectOutputStream(new FileOutputStream(file));
								oos.writeObject(alist);
								oos.close();
								System.out.println("Details Updated Successfully..!!");
								
							}else{
								System.out.println("Details not found..!!");
								
							}
				}		
						else{
								System.out.println("File not Exist!");
							}
			
				
						System.out.println("-------------");
						break;


					}


				}				
						while (choice!=0);
		
	}
}
