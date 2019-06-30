package objectCreation;

public class ObjectCreationTester {

	private static final int empListSize = 10000;

	public static void main(String[] args) throws CloneNotSupportedException {
		testObjectCreationUsingNew();

		testObjectCreationUsingCloning();
		
		testObjectCreationUsingReflection();
	}

	private static void testObjectCreationUsingNew() {
		long startTime = System.currentTimeMillis();
		Employee[] employees = new Employee[empListSize];
		for (int empCount = 0; empCount < empListSize; empCount++) {
			employees[empCount] = new Employee();
			employees[empCount].setEmpName("Name" + empCount);
			employees[empCount].setEmpAge(empCount);
			
			Address empAddress = new Address();
			empAddress.setIHouseNumber(empCount);
			empAddress.setPostCode("PostCode"+empCount);
			empAddress.setStreetDetails("Street"+empCount);
			employees[empCount].setEmpAddress(empAddress);
			
			employees[empCount].setEmpDepartment("Department" + empCount);
			employees[empCount].setEmpMonthlySalary(empCount * 10);
			employees[empCount].setEmpDesignation("Designation" + empCount);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken(in ms) to create 10,000 objects using new operator : " + (endTime - startTime));
	}

	private static void testObjectCreationUsingCloning() throws CloneNotSupportedException {
		long startTime = System.currentTimeMillis();
		Employee employee = new Employee();
		employee.setEmpName("Name");
		employee.setEmpAge(30);
		
		Address empAddress = new Address();
		empAddress.setIHouseNumber(1);
		empAddress.setPostCode("PostCode");
		empAddress.setStreetDetails("Street");
		employee.setEmpAddress(empAddress);

		employee.setEmpDepartment("Department");
		employee.setEmpMonthlySalary(4000);
		employee.setEmpDesignation("Designation");

		Employee[] clonedEmployees = new Employee[empListSize];
		for (int empCount = 0; empCount < empListSize; empCount++) {
			clonedEmployees[empCount] = (Employee) employee.clone();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken(in ms) to create 10,000 objects using cloning : " + (endTime - startTime));
	}
	
		
	private static void testObjectCreationUsingReflection() {
		long startTime = System.currentTimeMillis();
		Employee[] employees = new Employee[empListSize];
		for (int empCount = 0; empCount < empListSize; empCount++) {
			try {
				employees[empCount] = Employee.class.newInstance();
			} catch (Exception e) {
				// TODO: handle exception
			}
			employees[empCount].setEmpName("Name" + empCount);
			employees[empCount].setEmpAge(empCount);

			Address empAddress = new Address();
			empAddress.setIHouseNumber(empCount);
			empAddress.setPostCode("PostCode"+empCount);
			empAddress.setStreetDetails("Street"+empCount);
			employees[empCount].setEmpAddress(empAddress);			
			
	
			employees[empCount].setEmpDepartment("Department" + empCount);
			employees[empCount].setEmpMonthlySalary(empCount * 10);
			employees[empCount].setEmpDesignation("Designation" + empCount);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken(in ms) to create 10,000 objects using reflection : " + (endTime - startTime));
		
	}

}
