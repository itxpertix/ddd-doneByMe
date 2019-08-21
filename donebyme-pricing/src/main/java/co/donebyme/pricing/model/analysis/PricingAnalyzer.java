package co.donebyme.pricing.model.analysis;

import java.util.Date;

import co.donebyme.pricing.infra.persistence.Repositories;
import co.donebyme.pricing.model.Id;
import co.donebyme.pricing.model.PricingClassification;

// Domain Service
public class PricingAnalyzer {
  public void analyzePricing(
          final String pricedItemId,
          final PricingClassification pricingClassification,
          final Date dueDate,
          final long price) {

    final boolean verified = System.currentTimeMillis() % 2 == 0;

    final PricingAnalysis pricingAnalysis;

    if (verified) {
      pricingAnalysis = PricingAnalysis.verifyWith(pricedItemId, pricingClassification, dueDate, price);
    } else {
      pricingAnalysis = PricingAnalysis.rejectWith(pricedItemId, pricingClassification, dueDate, price, price * 2);
    }

    System.out.println("PricingAnalyzer completed with: " + (verified ? "verified" : "rejected"));

    Repositories.pricingAnalysisRepository().save(pricingAnalysis);
  }

  public void analyzeAdjustedPricing(
          final String pricedItemId,
          final PricingClassification pricingClassification,
          final Date dueDate,
          final long price) {
    PricingAnalysis pricingAnalysis = Repositories.pricingAnalysisRepository().pricingAnalysisOf(Id.fromExisting(pricedItemId));
    // pricingAnalysis...
  }
}
