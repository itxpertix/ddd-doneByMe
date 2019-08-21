package co.vaughnvernon.model.anemic;

import java.util.HashMap;
import java.util.Map;

public final class DoerSkills {
  private Map<String,Skill> map = new HashMap<>();

  public void addSkill(Skill skill) {
    map.put(skill.getName(), skill);
  }

  public Skill getSkill(String skillName) {
    return map.get(skillName);
  }

  public void deleteSkill(String skillName) {
    map.remove(skillName);
  }

  public static class Skill {
    private String name;
    private long price;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public long getPrice() {
      return price;
    }

    public void setPrice(long price) {
      this.price = price;
    }
  }
}
