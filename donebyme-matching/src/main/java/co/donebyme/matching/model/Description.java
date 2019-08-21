package co.donebyme.matching.model;

public final class Description {
  public final String text;
  
  public static Description has(final String text) {
    return new Description(text);
  }
  
  @Override
  public int hashCode() {
    return text.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Description.class) {
      return false;
    }
    
    return this.text.equals(((Description)other).text);
  }

  @Override
  public String toString() {
    return "Description[text=" + text + "]";
  }

  private Description(final String text) {
    this.text = text;
  }
}
