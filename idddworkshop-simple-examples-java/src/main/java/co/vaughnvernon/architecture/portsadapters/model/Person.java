package co.vaughnvernon.architecture.portsadapters.model;

// Model: Person Aggregate

public class Person {
  private final Id id;
  private Contact contact;
  private Name name;

  public Person(final Id id, final Name name, final Contact contact) {
    System.out.println("Model: Person::ctor");
    this.id = id;
    this.name = name;
    this.contact = contact;
  }

  public Id id() {
    return id;
  }

  public Contact contact() {
    return contact;
  }

  public Name name() {
    return name;
  }
}
