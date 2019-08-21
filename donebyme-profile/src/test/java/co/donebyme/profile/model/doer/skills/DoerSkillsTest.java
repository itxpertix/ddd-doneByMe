package co.donebyme.profile.model.doer.skills;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoerSkillsTest {

  @Test
  public void testThatFluentModelRocks() {
    final Skill skill =
            Skill.of(
                    SkillClassification.from(
                            Keyword.is("#windows"),
                            Keyword.is("#washing"),
                            Keyword.is("#inside"),
                            Keyword.is("#outside"),
                            Keyword.is("#extra-tall")),
                    Qualifications.of(
                            Qualification.Certified,
                            Qualification.Bonded,
                            Qualification.Licensed,
                            Qualification.Years),
                    Rate.flatRateOf(10000));

    assertNotNull(skill);

    assertEquals(skill.classification,
            SkillClassification.from(
                    Keyword.is("#windows"),
                    Keyword.is("#washing"),
                    Keyword.is("#inside"),
                    Keyword.is("#outside"),
                    Keyword.is("#extra-tall")));

    Skills doerSkills = Skills.startingWith(skill);
    
    assertTrue(doerSkills.declares(skill));
  }
}
