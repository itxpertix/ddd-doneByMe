package co.donebyme.pricing.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class PricingClassification {
  public final List<String> taxonomy;

  public static PricingClassification is(final String...taxonomy) {
    return new PricingClassification(taxonomy);
  }

  public static PricingClassification is(final List<String> taxonomy) {
    return new PricingClassification(taxonomy);
  }

  public String[] flattened() {
    return taxonomy.toArray(new String[taxonomy.size()]);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != PricingClassification.class) {
      return false;
    }
    return taxonomy.equals(((PricingClassification) other).taxonomy);
  }

  private PricingClassification(final String...taxonomy) {
    this.taxonomy = Collections.unmodifiableList(Arrays.asList(taxonomy));
  }

  public PricingClassification(List<String> taxonomy) {
    this.taxonomy = taxonomy;
  }
}
