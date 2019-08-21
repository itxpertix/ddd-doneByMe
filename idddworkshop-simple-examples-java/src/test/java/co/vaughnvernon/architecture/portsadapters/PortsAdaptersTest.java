package co.vaughnvernon.architecture.portsadapters;

import java.util.Date;

import org.junit.Test;

import co.vaughnvernon.architecture.portsadapters.application.Services;
import co.vaughnvernon.architecture.portsadapters.infra.resources.EmployeeResource;
import co.vaughnvernon.architecture.portsadapters.infra.resources.PersonResource;

public class PortsAdaptersTest {

  @Test
  public void testThatLayersExecute() {
    System.out.println("Executing Layers...");

    System.out.println("BOOTSTRAP");
    PersonResource personResource = new PersonResource(Services.PersonApplicationService);
    personResource.postPerson("Jane", "Doe", "212-555-1212", "jane@doe.com");
    System.out.println("BOOTSTRAP");
    personResource.getPerson("p123");

    System.out.println("BOOTSTRAP");
    EmployeeResource employeeResource = new EmployeeResource(Services.EmployeeApplicationService);
    employeeResource.postEmployee("p123", new Date());
    System.out.println("BOOTSTRAP");
    employeeResource.getEmployee("p123", true);
    System.out.println("BOOTSTRAP");
    employeeResource.getEmployee("e123", false);
  }
}
