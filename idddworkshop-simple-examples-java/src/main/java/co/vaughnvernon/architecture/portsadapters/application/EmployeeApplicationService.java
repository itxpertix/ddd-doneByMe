package co.vaughnvernon.architecture.portsadapters.application;

import java.util.Date;

import co.vaughnvernon.architecture.portsadapters.model.*;

// Application Service for Employee operations

public class EmployeeApplicationService {
  private final EmployeeRepository employeeRepository;
  private final PersonRepository personRepository;

  public EmployeeApplicationService(final EmployeeRepository employeeRepository, final PersonRepository personRepository) {
    this.employeeRepository = employeeRepository;
    this.personRepository = personRepository;
  }

  public Employee employeeOf(final String employeeId) {
    System.out.println("Application: EmployeeApplicationService::employeeOf");
    return employeeRepository.employeeOf(new Id(employeeId));
  }

  public Employee employeeOfPerson(final String personId) {
    System.out.println("Application: EmployeeApplicationService::employeeOfPerson");
    return employeeRepository.employeeOfPerson(new Id(personId));
  }

  public void hire(final String personId, final Date dateHired) {
    System.out.println("Application: EmployeeApplicationService::hire");
    final Person person = personRepository.personOf(new Id(personId));
    final Employee employee = Employee.hireAsOf(person, dateHired);
    employeeRepository.save(employee);
  }
}
