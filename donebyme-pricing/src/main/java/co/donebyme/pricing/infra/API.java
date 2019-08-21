package co.donebyme.pricing.infra;

import co.donebyme.pricing.application.PricingVerification;

public class API {
  private static PricingVerification pricingVerification;
  public static PricingVerification pricingVerification() {
    if (pricingVerification == null) {
      pricingVerification = new PricingVerification();
    }
    return pricingVerification;
  }
}
