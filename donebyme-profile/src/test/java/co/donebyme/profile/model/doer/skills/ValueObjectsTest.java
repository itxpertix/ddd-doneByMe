package co.donebyme.profile.model.doer.skills;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ValueObjectsTest {

  @Test
  public void testThatValuesCompose() {
    final Skill doerSkill =
            Skill.of(
                    SkillClassification.from(
                            Keyword.is("#windows"),
                            Keyword.is("#washing"),
                            Keyword.is("#inside"),
                            Keyword.is("#outside"),
                            Keyword.is("#extra-tall"),
                            Keyword.is("#count=25")),
                    Qualifications.of(
                            Qualification.Certified,
                            Qualification.Bonded,
                            Qualification.Licensed,
                            Qualification.Years),
                    Rate.flatRateOf(10000));

    assertNotNull(doerSkill);

    assertEquals(doerSkill.classification,
            SkillClassification.from(
                    Keyword.is("#windows"),
                    Keyword.is("#washing"),
                    Keyword.is("#inside"),
                    Keyword.is("#outside"),
                    Keyword.is("#extra-tall"),
                    Keyword.is("#count=25")));

    assertEquals(doerSkill.qualifications,
                    Qualifications.of(
                            Qualification.Certified,
                            Qualification.Bonded,
                            Qualification.Licensed,
                            Qualification.Years));

    assertEquals(doerSkill.rate, Rate.flatRateOf(10000));
  }
}
