package co.donebyme.pricing.model.analysis;

import co.donebyme.pricing.model.Id;

public interface PricingAnalysisRepository {
  PricingAnalysis pricingAnalysisOf(final Id id);
  void save(final PricingAnalysis pricingAnalysis);
}
