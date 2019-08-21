package co.donebyme.pricing.application;

import java.util.Date;

import co.donebyme.pricing.model.PricingClassification;
import co.donebyme.pricing.model.analysis.PricingAnalyzer;

// Application Service
public class PricingVerification {
  private PricingAnalyzer pricingAnalyzer = new PricingAnalyzer();

  public void verifyPricing(final String pricedItemId, final String[] taxonomy, final Date dueDate, final long price) {
    pricingAnalyzer.analyzePricing(pricedItemId, PricingClassification.is(taxonomy), dueDate, price);
  }

  public void verifyAdjustedPricing(final String pricedItemId, final String[] taxonomy, final Date dueDate, final long price) {
    pricingAnalyzer.analyzeAdjustedPricing(pricedItemId, PricingClassification.is(taxonomy), dueDate, price);
  }
}
