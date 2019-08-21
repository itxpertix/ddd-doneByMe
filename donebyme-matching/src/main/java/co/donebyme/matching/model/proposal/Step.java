package co.donebyme.matching.model.proposal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import co.donebyme.matching.model.Description;

public final class Step {
  public final int sequence;
  public final Description description;

  public static Set<Step> copyAllOf(final Set<Step> existingTasks) {
    final Set<Step> copy = new TreeSet<Step>();
    
    for (final Step each : existingTasks) {
      copy.add(Step.ordered(each.sequence, each.description));
    }
    
    return copy;
  }
  
  public static Set<Step> from(final Map<Integer, String> expectations) {
    final Set<Step> steps = new HashSet<Step>();
    
    for (final int sequence : expectations.keySet()) {
      final String text = expectations.get(sequence);
      steps.add(Step.ordered(sequence, Description.has(text)));
    }
    
    return steps;
  }
  
  public static Step ordered(final int sequence, final Description description) {
    return new Step(sequence, description);
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(sequence) + description.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Step.class) {
      return false;
    }
    
    final Step otherStep = (Step) other;
    
    return this.sequence == otherStep.sequence &&
        this.description.equals(otherStep.description);
  }

  @Override
  public String toString() {
    return "Step[sequence=" + sequence + " description=" + description + "]";
  }

  private Step(final int sequence, final Description description) {
    this.sequence = sequence;
    this.description = description;
  }
}
