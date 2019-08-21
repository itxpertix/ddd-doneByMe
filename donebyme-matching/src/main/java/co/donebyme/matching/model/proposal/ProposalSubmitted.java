package co.donebyme.matching.model.proposal;

import co.donebyme.matching.model.Client;
import co.donebyme.matching.model.Id;
import co.vaughnvernon.mockroservices.model.DomainEvent;

public final class ProposalSubmitted extends DomainEvent {
  public final String proposalId;
  public final String clientId;
  public final String description;
  public final String summary;
  public final String[] keywords;
  public final long completedBy;
  public final String[] steps;
  public final long price;
  
  public ProposalSubmitted(
      final Id proposalId,
      final Client client,
      final Expectations expectations) {
    this.proposalId = proposalId.value;
    this.clientId = client.id.value;
    this.summary = expectations.summary.text;
    this.description = expectations.description.text;
    this.keywords = Expectations.convert(expectations.keywords);
    this.completedBy = expectations.completedBy.getTime();
    this.steps = Expectations.convert(expectations.steps);
    this.price = expectations.price;
  }
}
