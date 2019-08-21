package co.donebyme.matching.model;

public final class Doer {
  public final Id id;
  public final boolean preferred;
  
  public static Doer nonpreferredFrom(final String referencedId) {
    return new Doer(Id.fromExisting(referencedId), false);
  }
  
  public static Doer preferredFrom(final String referencedId) {
    return new Doer(Id.fromExisting(referencedId), true);
  }
  
  @Override
  public int hashCode() {
    return id.hashCode() + (preferred ? 1:0);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Doer.class) {
      return false;
    }
    
    final Doer otherDoer = (Doer) other;
    
    return this.id.equals(otherDoer.id) && this.preferred == otherDoer.preferred;
  }

  @Override
  public String toString() {
    return "Doer[id=" + id + " preferred=" + preferred + "]";
  }
  
  private Doer(final Id id, final boolean preferred) {
    this.id = id;
    this.preferred = preferred;
  }
}
