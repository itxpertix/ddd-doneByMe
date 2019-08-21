package co.vaughnvernon.architecture.portsadapters.model;

public interface PersonRepository {

  Person personOf(Id id);

  void save(Person person);

}