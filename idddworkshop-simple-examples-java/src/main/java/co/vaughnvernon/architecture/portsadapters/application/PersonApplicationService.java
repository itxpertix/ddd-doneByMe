package co.vaughnvernon.architecture.portsadapters.application;

import co.vaughnvernon.architecture.portsadapters.model.*;

// Application Service for Person operations

public class PersonApplicationService {
  private final PersonRepository personRepository;

  public PersonApplicationService(final PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public void recordPerson(final String id, final Name name, final Contact contact) {
    System.out.println("Application: PersonApplicationService::recordPerson");
    final Person person = new Person(new Id(id), name, contact);
    personRepository.save(person);
  }

  public Person personOf(final String id) {
    System.out.println("Application: PersonApplicationService::personOf");
    return personRepository.personOf(new Id(id));
  }
}
