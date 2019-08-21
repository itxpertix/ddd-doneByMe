package co.donebyme.profile.model.doer.skills;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class SkillClassification implements Comparable<SkillClassification> {
  public final List<Keyword> orderedKeywords;

  public static SkillClassification from(final Keyword... orderedKeywords) {
    return new SkillClassification(orderedKeywords);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != SkillClassification.class) {
      return false;
    }
    return orderedKeywords.equals(((SkillClassification) other).orderedKeywords);
  }

  @Override
  public int compareTo(final SkillClassification other) {
    return this.equals(other) ? 0 : 1;
  }

  private SkillClassification(final Keyword...orderedKeywords) {
    this.orderedKeywords = Collections.unmodifiableList(Arrays.asList(orderedKeywords));
  }
}
