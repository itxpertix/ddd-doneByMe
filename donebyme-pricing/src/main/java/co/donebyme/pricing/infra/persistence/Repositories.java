package co.donebyme.pricing.infra.persistence;

import co.donebyme.pricing.model.analysis.PricingAnalysisRepository;

public class Repositories {
  private static PricingAnalysisRepository pricingAnalysisRepository;
  public static PricingAnalysisRepository pricingAnalysisRepository() {
    if (pricingAnalysisRepository == null) {
      pricingAnalysisRepository = new JournalPricingAnalysisRepository();
    }
    return pricingAnalysisRepository;
  }
}
