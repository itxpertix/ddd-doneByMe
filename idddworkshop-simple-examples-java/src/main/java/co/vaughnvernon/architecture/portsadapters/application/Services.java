package co.vaughnvernon.architecture.portsadapters.application;

import co.vaughnvernon.architecture.portsadapters.infra.persistence.Repositories;

public class Services {
  public static final EmployeeApplicationService EmployeeApplicationService;
  public static final PersonApplicationService PersonApplicationService;

  static {
    EmployeeApplicationService = new EmployeeApplicationService(Repositories.EmployeeRepository, Repositories.PersonRepository);
    PersonApplicationService = new PersonApplicationService(Repositories.PersonRepository);
  }
}
