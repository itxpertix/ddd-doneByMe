package co.donebyme.matching.model.proposal;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import co.donebyme.matching.model.Description;
import co.donebyme.matching.model.Keywords;
import co.donebyme.matching.model.Summary;

public final class Expectations {
  public final Description description;
  public final Date completedBy;
  public final Keywords keywords;
  public final Date suggestedCompletedBy;
  public final Summary summary;
  public final Set<Step> steps;
  public final long price;
  public final long suggestedPrice;

  public static Expectations of(
      final Summary summary,
      final Description description,
      final Keywords keywords,
      final Date completedBy,
      final Set<Step> steps,
      final long price) {
    
    return new Expectations(summary, description, keywords, completedBy, steps, price);
  }

  public Expectations withAdjusted(final Date suggestedCompletedBy) {
    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, steps, price, price);
  }

  public Expectations withAdjusted(final long suggestedPrice) {
    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, steps, price, suggestedPrice);
  }

  public Expectations withNew(final Summary summary) {
    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, steps, price, suggestedPrice);
  }

  public Expectations withNew(final Description description) {
    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, steps, price, suggestedPrice);
  }

  public Expectations withNew(final Step step) {
    final Set<Step> newSteps = new HashSet<Step>();
    newSteps.add(step);
    newSteps.addAll(steps);

    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, newSteps, price, suggestedPrice);
  }

  public Expectations withRefined(final Keywords keywords) {
    return new Expectations(summary, description, keywords, completedBy, suggestedCompletedBy, steps, price, suggestedPrice);
  }
  
  @Override
  public int hashCode() {
    return summary.hashCode() + description.hashCode() + completedBy.hashCode() + steps.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Expectations.class) {
      return false;
    }
    
    final Expectations otherExpectations = (Expectations) other;
    
    return this.summary.equals(otherExpectations.summary) &&
        this.description.equals(otherExpectations.description) &&
        this.keywords.equals(otherExpectations.keywords) &&
        this.completedBy.equals(completedBy) &&
        this.steps.equals(otherExpectations.steps);
  }

  @Override
  public String toString() {
    return "Expectations[summary=" + summary +
        " description=" + description +
        " completedBy=" + completedBy +
        " steps=" + steps + "]";
  }

  protected static String[] convert(final Keywords keywords) {
    return keywords.orderedTaxonomy.toArray(new String[keywords.orderedTaxonomy.size()]);
  }

  protected static String[] convert(final Set<Step> steps) {
    final String[] plainSteps = new String[steps.size()];
    int idx = 0;
    for (final Step step : steps) {
      plainSteps[idx] = "" + step.sequence + "=" + step.description;
    }
    return plainSteps;
  }

  protected static Keywords convertToKeywords(final String[] keywords) {
    return Keywords.are(keywords);
  }

  protected static Set<Step> convertToSteps(final String[] plainSteps) {
    final Set<Step> steps = new HashSet<Step>();
    for (final String plainStep : plainSteps) {
      final String[] parts = plainStep.split("=");
      steps.add(Step.ordered(Integer.parseInt(parts[0]), Description.has(parts[1])));
    }
    return steps;
  }

  private Expectations(
      final Summary summary,
      final Description description,
      final Keywords keywords,
      final Date completedBy,
      final Set<Step> steps,
      final long price) {
    
    this.summary = summary;
    this.description = description;
    this.keywords = keywords;
    this.completedBy = completedBy;
    this.suggestedCompletedBy = completedBy;
    this.steps = steps;
    this.price = price;
    this.suggestedPrice = price;
  }

  private Expectations(
      final Summary summary,
      final Description description,
      final Keywords keywords,
      final Date completedBy,
      final Date suggestedCompletedBy,
      final Set<Step> steps,
      final long price,
      final long suggestedPrice) {
    
    this.summary = summary;
    this.description = description;
    this.keywords = keywords;
    this.completedBy = completedBy;
    this.suggestedCompletedBy = suggestedCompletedBy;
    this.steps = steps;
    this.price = price;
    this.suggestedPrice = suggestedPrice;
  }
}
