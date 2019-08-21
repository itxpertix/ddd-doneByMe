package co.donebyme.matching.model;

public final class Client {
  public final Id id;

  public static Client from(final String referencedId) {
    return new Client(Id.fromExisting(referencedId));
  }
  
  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Client.class) {
      return false;
    }
    
    return this.id.equals(((Client)other).id);
  }

  @Override
  public String toString() {
    return "Client[id=" + id + "]";
  }

  private Client(final Id id) {
    this.id = id;
  }
}
