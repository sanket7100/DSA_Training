package com.sanket;

import java.io.Serializable;

import com.sanket.serialization.SaveToFile;

public class LinkedTest {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "Sanket", 1000000);
		Employee e2 = new Employee(2, "Suraj", 500000);
		Employee e3 = new Employee(3, "Aniket", 700000);
		Employee e4 = new Employee(4, "Shivam", 1200000);
		Employee e5 = new Employee(6, "Vasim", 2000000);

		MyLinkedList l1 = new MyLinkedList();
		l1.add(e1);
		l1.add(e2);
		l1.add(e3);
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.insertAtStart(e4);
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.insertAt(3, e5);
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.deleteFirstNode();
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.deleteLastNode();
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.deleteNodeAt(6);
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		l1.modify(1, "chavan", 2500000);
		l1.printAll();
		System.out.println("----------------------------------------------------------------------");
		SaveToFile.serialize(l1);
		MyLinkedList stored = (MyLinkedList) SaveToFile.deserialise("Employees.txt");
		stored.printAll();
	}

}

class MyLinkedList implements Serializable {
	private static final long serialVersionUID = -178539752132019963L;
	Employee head = null;
	Employee current = null;

	void add(Employee e) {
		if (head == null) {
			head = e;
			current = e;
			head.next = null;
			head.prev = null;
		} else {
			current.next = e;
			e.prev = current;
			current = e;
		}
	}

	void printAll() {
		Employee temp = head;
		while (temp != null) {
			System.out.println(temp.show());
			temp = temp.next;
		}
	}

	void insertAtStart(Employee e) {
		head.prev = e;
		e.next = head;
		head = e;
	}

	void insertAt(int number, Employee e) {
		Employee temp = head;
		while (number > 1) {
			temp = temp.next;
			number--;
		}
		if (temp.prev == null)
			insertAtStart(e);
		else if (temp.next == null)
			add(e);
		else {
			e.prev = temp.prev;
			temp.prev.next = e;
			e.next = temp;
			temp.prev = e;
		}

	}

	void deleteFirstNode() {
		head = head.next;
		head.prev.next = null;
		head.prev = null;
	}

	void deleteLastNode() {
		current = current.prev;
		current.next.prev = null;
		current.next = null;
	}

	void deleteAll() {
		while (head != null) {
			Employee temp = head.next;
			head = null;
			head = temp;
		}
	}

	void modify(long number, String name, float salary) {
		Employee temp1 = head;
		while (temp1 != null) {
			if (temp1.getEmpNumber() == number)
				break;
			temp1 = temp1.next;
		}

		if (temp1 == null)
			throw new RuntimeException("EmployeeNotFoundException");
		else {
			temp1.setEmpName(name);
			temp1.setEmpSalary(salary);
		}
	}

	void deleteNodeAt(long number) {
		Employee temp1 = head;
		while (temp1 != null) {
			if (temp1.getEmpNumber() == number)
				break;
			temp1 = temp1.next;
		}

		if (temp1 == null)
			throw new RuntimeException("EmployeeNotFoundException");
		else {
			if (temp1.prev == null) {
				deleteFirstNode();
			} else if (temp1.next == null) {
				deleteLastNode();
			} else {
				temp1.next.prev = temp1.prev;
				temp1.prev.next = temp1.next;
				temp1.next = null;
				temp1.prev = null;
			}
		}

	}

	Employee getHead() {
		return head;
	}

}

class Employee implements Serializable {
	private long empNumber;
	private String empName;
	private float empSalary;

	Employee next;
	Employee prev;

	public long getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(long empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public Employee() {
		super();
	}

	public Employee(long empNumber, String empName, float empSalary) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String show() {
		return "Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + ", next="
				+ next + ", prev=" + prev + "]";
	}

}
