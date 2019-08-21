package co.donebyme.profile.model.doer;

import java.util.UUID;

import co.donebyme.profile.model.doer.ranking.Rank;
import co.donebyme.profile.model.doer.skills.Skill;
import co.donebyme.profile.model.doer.skills.SkillClassification;
import co.donebyme.profile.model.doer.skills.Skills;

public final class Doer {
  public final String id;
  private Skills skills;

  public static Doer with(final Skills skills) {
    return new Doer(skills);
  }

  public Skills skills() {
    return skills;
  }
  
  public Rank rankFor(final SkillClassification skillClassification) {
	  return skills.rankFor(skillClassification);
  }

  public void declareNew(final Skill skill) {
    skills = skills.declare(skill);
  }

  private Doer(final Skills skills) {
    this.id = UUID.randomUUID().toString();
    this.skills = skills;
  }
}
