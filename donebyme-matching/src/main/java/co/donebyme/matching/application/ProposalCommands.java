package co.donebyme.matching.application;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.donebyme.matching.model.Client;
import co.donebyme.matching.model.Description;
import co.donebyme.matching.model.Id;
import co.donebyme.matching.model.Keywords;
import co.donebyme.matching.model.Summary;
import co.donebyme.matching.model.proposal.Expectations;
import co.donebyme.matching.model.proposal.Proposal;
import co.donebyme.matching.model.proposal.ProposalRepository;
import co.donebyme.matching.model.proposal.Step;

public class ProposalCommands {
  private final ProposalRepository repository;
  
  public ProposalCommands(final ProposalRepository repository) {
    this.repository = repository;
  }
  
  public void denyPricing(
      final String proposalId,
      final long suggestedPrice) {
    
    final Proposal proposal = repository.proposalOf(Id.fromExisting(proposalId));
    
    proposal.denyPricing(suggestedPrice);
    
    repository.save(proposal);
  }
  
  public void denyScheduling(
      final String proposalId,
      final Date suggestedCompletionDate) {
    
    final Proposal proposal = repository.proposalOf(Id.fromExisting(proposalId));
    
    proposal.denyScheduling(suggestedCompletionDate);
    
    repository.save(proposal);
  }
  
  public void submitProposal(
      final String clientId,
      final String summary,
      final String description,
      final List<String> keywords,
      final Date completedBy,
      final Map<Integer, String> steps,
      final long price) {
  
    final Proposal proposal =
        Proposal.submitFor(
            Client.from(clientId),
            Expectations.of(
                Summary.has(summary),
                Description.has(description),
                Keywords.are(keywords),
                completedBy,
                Step.from(steps),
                price));
    
    repository.save(proposal);
  }
  
  public void verifyPricing(final String proposalId) {
    final Proposal proposal = repository.proposalOf(Id.fromExisting(proposalId));
    
    proposal.verifyPricing();
    
    repository.save(proposal);
  }
  
  public void verifyScheduling(final String proposalId) {
    final Proposal proposal = repository.proposalOf(Id.fromExisting(proposalId));
    
    proposal.verifyScheduling();
    
    repository.save(proposal);
  }
}
