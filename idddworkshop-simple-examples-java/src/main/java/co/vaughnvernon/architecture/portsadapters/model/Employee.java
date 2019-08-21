package co.vaughnvernon.architecture.portsadapters.model;

import java.util.Date;

// Model: Employee Aggregate

public class Employee {
  private Date dateHired;
  
  // Aggregate Rule #3: Reference By Id Only: private final Id personId;
  private Person person;

  public static Employee hireAsOf(final Person person, final Date dateHired) {
    System.out.println("Model: Employee::hireAsOf");
    return new Employee(person, dateHired);
  }

  public Employee(final Person person, final Date dateHired) {
    System.out.println("Model: Employee::ctor");
    this.person = person;
    this.dateHired = dateHired;
  }

  public Date dateHired() {
    return dateHired;
  }

  public Person person() {
    return person;
  }
}
