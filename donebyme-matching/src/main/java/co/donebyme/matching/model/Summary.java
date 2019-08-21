package co.donebyme.matching.model;

public final class Summary {
  public final String text;
  
  public static Summary has(final String text) {
    return new Summary(text);
  }
  
  @Override
  public int hashCode() {
    return text.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Summary.class) {
      return false;
    }
    
    return this.text.equals(((Summary)other).text);
  }

  @Override
  public String toString() {
    return "Summary[text=" + text + "]";
  }

  private Summary(final String text) {
    this.text = text;
  }
}
