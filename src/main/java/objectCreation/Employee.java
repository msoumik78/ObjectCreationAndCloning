package objectCreation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee implements Cloneable, Serializable {
	private static final long serialVersionUID = 7963695131343586301L;

	private String empName;
	private Address empAddress;
	private int empAge;
	private double empMonthlySalary;
	private String empDepartment;
	private String empQualification;
	private String empDesignation;

    public Object clone()throws CloneNotSupportedException{  
        return (Employee)super.clone();  
    }	
	
	
}
