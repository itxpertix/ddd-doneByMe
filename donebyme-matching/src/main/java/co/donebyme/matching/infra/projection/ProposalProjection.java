package co.donebyme.matching.infra.projection;

import co.donebyme.matching.model.proposal.PricingDenied;
import co.donebyme.matching.model.proposal.PricingVerified;
import co.donebyme.matching.model.proposal.ProposalSubmitted;
import co.donebyme.matching.model.proposal.SchedulingDenied;
import co.donebyme.matching.model.proposal.SchedulingVerified;
import co.vaughnvernon.mockroservices.messagebus.Message;
import co.vaughnvernon.mockroservices.messagebus.MessageBus;
import co.vaughnvernon.mockroservices.messagebus.Subscriber;
import co.vaughnvernon.mockroservices.messagebus.Topic;
import co.vaughnvernon.mockroservices.model.DomainEvent;

public class ProposalProjection extends Projection implements Subscriber {
  public ProposalProjection() {
    final MessageBus messageBus = MessageBus.start("donebyme");
    final Topic topic = messageBus.openTopic("all");
    topic.subscribe(this);
  }

  @Override
  public void handle(final Message message) {
    try {
      final DomainEvent event = toEvent(message);
      if (event instanceof PricingDenied) project((PricingDenied) event);
      if (event instanceof PricingVerified) project((PricingVerified) event);
      if (event instanceof ProposalSubmitted) project((ProposalSubmitted) event);
      if (event instanceof SchedulingDenied) project((SchedulingDenied) event);
      if (event instanceof SchedulingVerified) project((SchedulingVerified) event);
    } catch (Exception e) {
      // TODO: handle
    }
  }
  
  private void project(final PricingDenied event) {
    final ProposalView view = ProposalView.views.get(event.proposalId);
    ProposalView.views.put(event.proposalId, view.withPricingDenied(event.suggestedPrice));
  }
  
  private void project(final PricingVerified event) {
    final ProposalView view = ProposalView.views.get(event.proposalId);
    ProposalView.views.put(event.proposalId, view.withProgress("PricingVerified"));
  }
  
  private void project(final ProposalSubmitted event) {
    ProposalView.views.put(
        event.proposalId,
        new ProposalView(
            event.proposalId,
            event.clientId,
            event.summary,
            event.description,
            event.completedBy,
            event.completedBy,
            event.steps,
            event.price,
            event.price,
            new String[0]));
  }
  
  private void project(final SchedulingDenied event) {
    final ProposalView view = ProposalView.views.get(event.proposalId);
    ProposalView.views.put(event.proposalId, view.withSchedulingDenied(event.suggestedCompletionDate));
  }
  
  private void project(final SchedulingVerified event) {
    final ProposalView view = ProposalView.views.get(event.proposalId);
    ProposalView.views.put(event.proposalId, view.withProgress("SchedulingVerified"));
  }
}
