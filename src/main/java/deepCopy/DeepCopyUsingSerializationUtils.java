package deepCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang3.SerializationUtils;

import objectCreation.Address;
import objectCreation.Employee;

public class DeepCopyUsingSerializationUtils {

	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException{
		
		Employee employee = createEmployeeUsingFactory();

		Employee shallowCopiedEmployee = (Employee) employee.clone();
		
		System.out.println("*******Properties of shallow copied employee object***********");
		System.out.println("Name:"+shallowCopiedEmployee.getEmpName());
		System.out.println("Age:"+shallowCopiedEmployee.getEmpAge());		
		System.out.println("PostCode: "+shallowCopiedEmployee.getEmpAddress().getPostCode());
		shallowCopiedEmployee.getEmpAddress().setPostCode("PostCodeModifiedInClone");
		System.out.println("Now PostCode in cloned: "+shallowCopiedEmployee.getEmpAddress().getPostCode());
		System.out.println("Now PostCode in original: "+employee.getEmpAddress().getPostCode());

		
                employee = createEmployeeUsingFactory();
		System.out.println("\n\n*******Properties of deep copied employee object***********");
		Employee deepCopiedEmployee = SerializationUtils.clone(employee);
		System.out.println("Name:"+deepCopiedEmployee.getEmpName());
		System.out.println("Age:"+deepCopiedEmployee.getEmpAge());		
		System.out.println("PostCode: "+deepCopiedEmployee.getEmpAddress().getPostCode());		
		deepCopiedEmployee.getEmpAddress().setPostCode("PostCodeModifiedInDeepCopy");
		System.out.println("Now PostCode in deep copies: "+deepCopiedEmployee.getEmpAddress().getPostCode());
		System.out.println("Now PostCode in original: "+employee.getEmpAddress().getPostCode());		
		
	}
	
	private static Employee createEmployeeUsingFactory(){
		Employee employee = new Employee();
		employee.setEmpName("Name");
		employee.setEmpAge(40);
		
		Address empAddress = new Address();
		empAddress.setIHouseNumber(10); 
		empAddress.setPostCode("PostCode");
		empAddress.setStreetDetails("Street");
		employee.setEmpAddress(empAddress);
		
		employee.setEmpDepartment("Department");
		employee.setEmpMonthlySalary(20000);
		employee.setEmpDesignation("Designation");		
		return employee;
		
	}
	
	
	private static Employee serializeAndDeSerializeObject(Employee employee) throws IOException, ClassNotFoundException{
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ObjectOutputStream out = new ObjectOutputStream(bos);
	      out.writeObject(employee);
	 
	      ByteArrayInputStream bis = new   ByteArrayInputStream(bos.toByteArray());
	      ObjectInputStream in = new ObjectInputStream(bis);
	      Employee deepCopied = (Employee) in.readObject();		
	      return deepCopied;
		
	}

}
