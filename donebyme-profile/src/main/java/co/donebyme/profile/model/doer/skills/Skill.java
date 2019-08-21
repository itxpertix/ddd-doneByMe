package co.donebyme.profile.model.doer.skills;

public final class Skill implements Comparable<Skill> {
  public final SkillClassification classification;
  public final Qualifications qualifications;
  public final Rate rate;

  public static Skill of(final SkillClassification classification, final Qualifications qualifications, final Rate rate) {
    return new Skill(classification, qualifications, rate);
  }

  @Override
  public int compareTo(final Skill other) {
    final int classificationCompare = classification.compareTo(other.classification);
    if (classificationCompare != 0) return classificationCompare;

    if (!qualifications.equals(other.qualifications)) return -1;

    return rate.compareTo(other.rate);
  }

  private Skill(final SkillClassification classification, final Qualifications qualifications, final Rate rate) {
    this.classification = classification;
    this.qualifications = qualifications;
    this.rate = rate;
  }
}
