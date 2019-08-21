package co.donebyme.profile.model.doer.skills;

public final class Keyword {
  public final String value;

  public static Keyword is(final String value) {
    return new Keyword(value);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Keyword.class) {
      return false;
    }
    return value.equals(((Keyword) other).value);
  }

  private Keyword(final String value) {
    this.value = value;
  }
}
