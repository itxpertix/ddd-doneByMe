package co.donebyme.matching.model.proposal;

import java.util.Date;

import co.donebyme.matching.model.Client;
import co.donebyme.matching.model.Id;
import co.vaughnvernon.mockroservices.model.DomainEvent;

public class SchedulingDenied extends DomainEvent {
  public final String proposalId;
  public final String clientId;
  public final long completionDate;
  public final long suggestedCompletionDate;
  
  public SchedulingDenied(
      final Id proposalId,
      final Client client,
      final Expectations expectations,
      final Date suggestedCompletionDate) {
    this.proposalId = proposalId.value;
    this.clientId = client.id.value;
    this.completionDate = expectations.completedBy.getTime();
    this.suggestedCompletionDate = suggestedCompletionDate.getTime();
  }
}
