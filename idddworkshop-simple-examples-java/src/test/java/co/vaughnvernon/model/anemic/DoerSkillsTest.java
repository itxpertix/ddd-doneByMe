package co.vaughnvernon.model.anemic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import co.vaughnvernon.model.anemic.DoerSkills.Skill;

public class DoerSkillsTest {

  @Test
  public void testThatAnemicModelSucks() {
    DoerSkills doerSkills = new DoerSkills();
    Skill skill = new Skill();
    skill.setName("window-washing");
    skill.setPrice(10000);
    doerSkills.addSkill(skill);
    assertNotNull(doerSkills.getSkill("window-washing"));
    doerSkills.deleteSkill("window-washing");
    assertNull(doerSkills.getSkill("window-washing"));
  }
}
