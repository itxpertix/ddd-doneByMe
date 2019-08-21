package co.vaughnvernon.architecture.portsadapters.infra.resources;

import co.vaughnvernon.architecture.portsadapters.application.PersonApplicationService;
import co.vaughnvernon.architecture.portsadapters.model.Contact;
import co.vaughnvernon.architecture.portsadapters.model.Id;
import co.vaughnvernon.architecture.portsadapters.model.Name;
import co.vaughnvernon.architecture.portsadapters.model.Person;

// Port Adapter: REST resource handler for Person

public class PersonResource {
  private final PersonApplicationService service;

  public PersonResource(final PersonApplicationService service) {
    this.service = service;
  }

  // GET /assets/people/{personId}
  public Person getPerson(final String personId) {
    System.out.println("Port Adapter: PersonResource::getPerson");
    return service.personOf(personId);
  }

  // POST /assets/people
  public Person postPerson(
          final String givenName,
          final String familyName,
          final String mobilePhone,
          final String emailAddress) {
    System.out.println("Port Adapter: PersonResource::postPerson");
    final String id = Id.unique().value;
    service.recordPerson(id, new Name(givenName, familyName),  new Contact(mobilePhone, emailAddress));
    return service.personOf(id);
  }
}
