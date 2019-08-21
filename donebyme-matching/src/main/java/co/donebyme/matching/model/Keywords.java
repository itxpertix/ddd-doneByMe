package co.donebyme.matching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Keywords {
  public final List<String> orderedTaxonomy;

  public static Keywords are(final String...keywords) {
    return new Keywords(keywords);
  }

  public static Keywords are(final List<String> keywords) {
    return new Keywords(keywords);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Keywords.class) {
      return false;
    }
    return orderedTaxonomy.equals(((Keywords) other).orderedTaxonomy);
  }

  private Keywords(final String...keywords) {
    this.orderedTaxonomy = Collections.unmodifiableList(Arrays.asList(keywords));
  }

  private Keywords(List<String> keywords) {
    this.orderedTaxonomy = keywords;
  }
}
