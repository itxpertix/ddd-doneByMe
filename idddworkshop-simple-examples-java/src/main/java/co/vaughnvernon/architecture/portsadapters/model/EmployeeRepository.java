package co.vaughnvernon.architecture.portsadapters.model;

public interface EmployeeRepository {

  Employee employeeOf(Id id);

  Employee employeeOfPerson(Id id);

  void save(Employee employee);

}