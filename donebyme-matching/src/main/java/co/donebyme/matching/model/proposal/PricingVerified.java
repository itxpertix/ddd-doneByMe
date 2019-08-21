package co.donebyme.matching.model.proposal;

import co.donebyme.matching.model.Client;
import co.donebyme.matching.model.Id;
import co.vaughnvernon.mockroservices.model.DomainEvent;

public class PricingVerified extends DomainEvent {
  public final String proposalId;
  public final String clientId;
  public final long price;
  
  public PricingVerified(
      final Id proposalId,
      final Client client,
      final Expectations expectations) {
    this.proposalId = proposalId.value;
    this.clientId = client.id.value;
    this.price = expectations.price;
  }
}
