package co.vaughnvernon.architecture.portsadapters.infra.messaging;

import java.util.Date;

import co.vaughnvernon.architecture.portsadapters.application.Services;

// Port Adapter: Message Listener for Person/Employee happenings

public class HumanResourcesMessageListener {
  public void receive(final Message message) {
    System.out.println("Port Adapter: HumanResourcesMessageListener::receive");
    if (message.type.equals("PersonHired")) {
      final String personId = message.id;
      Services.EmployeeApplicationService.hire(personId, hireDateFrom(message.payload));
    }
  }

  private Date hireDateFrom(final String payload) {
    return new Date(); // simulate reading date from payload
  }
}
