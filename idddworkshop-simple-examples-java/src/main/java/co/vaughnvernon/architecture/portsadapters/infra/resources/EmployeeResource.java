package co.vaughnvernon.architecture.portsadapters.infra.resources;

import java.util.Date;

import co.vaughnvernon.architecture.portsadapters.application.EmployeeApplicationService;
import co.vaughnvernon.architecture.portsadapters.model.Employee;

// Port Adapter: REST resource handler for Employee
 
public class EmployeeResource {
  private EmployeeApplicationService service;

  public EmployeeResource(final EmployeeApplicationService service) {
    this.service = service;
  }

  // GET /assets/employees/{id}?usePersonId=boolean
  public Employee getEmployee(final String id, final boolean usePersonId) {
    System.out.println("Port Adapter: EmployeeResource::getEmployee");
    if (usePersonId) {
      return service.employeeOfPerson(id);
    }
    return service.employeeOf(id);
  }

  // POST /assets/employees
  public Employee postEmployee(final String personId, final Date dateHired) {
    System.out.println("Port Adapter: EmployeeResource::postEmployee");
    service.hire(personId, dateHired);
    return service.employeeOfPerson(personId);
  }
}
