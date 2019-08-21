package co.vaughnvernon.architecture.portsadapters.infra.persistence;

import java.util.Date;

import co.vaughnvernon.architecture.portsadapters.model.Contact;
import co.vaughnvernon.architecture.portsadapters.model.Employee;
import co.vaughnvernon.architecture.portsadapters.model.EmployeeRepository;
import co.vaughnvernon.architecture.portsadapters.model.Id;
import co.vaughnvernon.architecture.portsadapters.model.Name;
import co.vaughnvernon.architecture.portsadapters.model.Person;

// Port Adapter: Persistence for Employee

public class PersistenceEmployeeRepository implements EmployeeRepository {
  @Override
  public Employee employeeOf(final Id id) {
    System.out.println("Port Adapter: EmployeeRepository::employeeOf");
    // mimic found employee by employee id
    final Employee found =
            new Employee(
                    new Person(new Id("p123"), new Name("Jane", "Doe"), new Contact("212-555-1212", "jane@doe.com")),
                    new Date());

    return found;
  }

  @Override
  public Employee employeeOfPerson(final Id id) {
    System.out.println("Port Adapter: EmployeeRepository::employeeOfPerson");
    // mimic found employee by person id
    final Employee found =
            new Employee(
                    new Person(new Id("p123"), new Name("Jane", "Doe"), new Contact("212-555-1212", "jane@doe.com")),
                    new Date());

    return found;
  }

  @Override
  public void save(final Employee employee) {
    System.out.println("Port Adapter: EmployeeRepository::save");
    // ...
  }
}
