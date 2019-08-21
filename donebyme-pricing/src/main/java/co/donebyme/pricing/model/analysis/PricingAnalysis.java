package co.donebyme.pricing.model.analysis;

import java.util.Date;
import java.util.List;

import co.donebyme.pricing.model.Id;
import co.donebyme.pricing.model.PricingClassification;
import co.vaughnvernon.mockroservices.model.DomainEvent;
import co.vaughnvernon.mockroservices.model.SourcedEntity;

public class PricingAnalysis extends SourcedEntity<DomainEvent> {
  private Id id;
  private Date dueDate;
  private long price;
  private PricingClassification pricingClassification;
  private long suggestedPrice;
  // private Set<PriceHistory> priceHistory

  public static PricingAnalysis verifyWith(
          final String pricedItemId,
          final PricingClassification pricingClassification,
          final Date dueDate,
          long price) {
    return new PricingAnalysis(Id.fromExisting(pricedItemId), pricingClassification, dueDate, price);
  }

  public static PricingAnalysis rejectWith(
          final String pricedItemId,
          final PricingClassification pricingClassification,
          final Date dueDate,
          long price,
          long suggestedPrice) {
    return new PricingAnalysis(Id.fromExisting(pricedItemId), pricingClassification, dueDate, price, suggestedPrice);
  }

  public Id id() {
    return id;
  }

  protected void when(final PricingVerified e) {
    id = Id.fromExisting(e.originatorId);
    pricingClassification = PricingClassification.is(e.taxonomy);
    dueDate = new Date(e.dueDate);
    price = e.price;
    suggestedPrice = e.price;
  }

  protected void when(final PricingRejected e) {
    id = Id.fromExisting(e.originatorId);
    pricingClassification = PricingClassification.is(e.taxonomy);
    dueDate = new Date(e.dueDate);
    price = e.price;
    suggestedPrice = e.suggestedPrice;
  }

  public PricingAnalysis(final List<DomainEvent> events, final int streamVersion) {
    super(events, streamVersion);
  }

  private PricingAnalysis(Id id, final PricingClassification pricingClassification, final Date dueDate, final long price) {
    apply(new PricingVerified(id.value, pricingClassification, dueDate, price));
  }

  private PricingAnalysis(Id id, final PricingClassification pricingClassification, final Date dueDate, final long price, final long suggestedPrice) {
    apply(new PricingRejected(id.value, pricingClassification, dueDate, price, suggestedPrice));
  }
}
