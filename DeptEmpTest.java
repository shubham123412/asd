import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import mypojos.Department;
import mypojos.Employee;
import mypojos.EmployeeDAO;
import mypojos.EmployeeDAOImpl;

public class DeptEmpTest {
	public static void main(String[] args) {
		
		//find out all employees from dept location 'Chicago'
		DepartmentDAOImpl ddi = new DepartmentDAOImpl();
		/*Department dept = ddi.selectDepartmentByDeptno(30);*/
		ArrayList<Department> deptList =  ddi.selectAllDepartments();
		Iterator<Department> deptIter = deptList.iterator();
		
		System.out.println("Which location to search ? ");
		Scanner scan = new Scanner(System.in);
		String whatToSearch = scan.nextLine();
		boolean found=false;
		
		Department dept = null;
		
		while(deptIter.hasNext()) {
			
			dept = deptIter.next();
			
			if(dept.getDepartmentLocation().equalsIgnoreCase(whatToSearch)) {
				found=true;
				break;
			}
		}
		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		
		if(found) {
			System.out.println("Dept No   : "+dept.getDepartmentNumber());
			System.out.println("Dept Name : "+dept.getDepartmentName());
			System.out.println("Dept Loc  : "+dept.getDepartmentLocation());
			System.out.println("---------------");

			//IM ON MUTE  OBSERVE THE NEW IMPROVEMENT
			//grab all employees 
			
			ArrayList<Employee> allEmps = edi.selectAllEmployees();
			Iterator<Employee> empIter = allEmps.iterator();
			
			while(empIter.hasNext())
			{
				Employee emp = empIter.next();
				
				if(emp.getEmployeeDepartmentNumber() == dept.getDepartmentNumber())
				{
					System.out.println("EMP NO       : "+emp.getEmployeeNumber());
					System.out.println("EMP NAME     : "+emp.getEmployeeName());
					System.out.println("EMP JOB      : "+emp.getEmployeeJob());
					System.out.println("EMP MGR      : "+emp.getEmployeeManager());
					System.out.println("EMP HIREDATE : "+emp.getEmployeeHireDate());
					System.out.println("EMP SAL      : "+emp.getEmployeeSalary());
					System.out.println("EMP COMM     : "+emp.getEmployeeCommission());
					System.out.println("EMP DEPTNO   : "+emp.getEmployeeDepartmentNumber());
					System.out.println("-------------------------------------");
				}
			}
			
		}
		else {
			System.out.println("Location "+whatToSearch+" NOT found");
		}
		
	}
}
