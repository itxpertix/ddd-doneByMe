package co.vaughnvernon.architecture.portsadapters.infra.persistence;

import co.vaughnvernon.architecture.portsadapters.model.EmployeeRepository;
import co.vaughnvernon.architecture.portsadapters.model.PersonRepository;

public class Repositories {
  public static final EmployeeRepository EmployeeRepository;
  public static final PersonRepository PersonRepository;

  static {
    EmployeeRepository = new PersistenceEmployeeRepository();
    PersonRepository = new PersistencePersonRepository();
  }
}
