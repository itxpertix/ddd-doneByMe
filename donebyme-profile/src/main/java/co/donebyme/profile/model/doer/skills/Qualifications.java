package co.donebyme.profile.model.doer.skills;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public final class Qualifications {
  private Set<Qualification> all;

  public static Qualifications of(final Qualification...qualifications) {
    return new Qualifications(qualifications);
  }

  public boolean has(final Qualification qualification) {
    return all.contains(qualification);
  }

  public Stream<Qualification> stream() {
    return all.stream();
  }

  public Qualifications with(final Qualification qualification) {
    if (has(qualification)) {
      return this;
    }
    final Set<Qualification> more = new TreeSet<>(all);
    more.add(qualification);
    return new Qualifications(more);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Qualifications.class) {
      return false;
    }
    return all.equals(((Qualifications) other).all);
  }

  private Qualifications(final Qualification...qualifications) {
    all = new TreeSet<>(Arrays.asList(qualifications));
  }

  private Qualifications(final Set<Qualification> all) {
    this.all = all;
  }
}
