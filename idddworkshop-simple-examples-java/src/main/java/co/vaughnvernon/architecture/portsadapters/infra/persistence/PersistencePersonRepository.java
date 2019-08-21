package co.vaughnvernon.architecture.portsadapters.infra.persistence;

import co.vaughnvernon.architecture.portsadapters.model.Contact;
import co.vaughnvernon.architecture.portsadapters.model.Id;
import co.vaughnvernon.architecture.portsadapters.model.Name;
import co.vaughnvernon.architecture.portsadapters.model.Person;
import co.vaughnvernon.architecture.portsadapters.model.PersonRepository;

// Port Adapter: Persistence for Person

public class PersistencePersonRepository implements PersonRepository {
  @Override
  public Person personOf(final Id id) {
    System.out.println("Port Adapter: PersonRepository::personOf");
    // ...

    // mimic found person
    final Person found =
            new Person(
                    id,
                    new Name("Jane", "Doe"),
                    new Contact("212-555-1212", "jane@doe.com"));

    return found;
  }

  @Override
  public void save(final Person person) {
    System.out.println("Port Adapter: PersonRepository::save");
    // ...
  }
}
