package co.donebyme.matching.infra.persistence;

import co.donebyme.matching.model.proposal.ProposalRepository;

// TODO: this may be provided by IoT container

public class Repositories {
  private static ProposalRepository proposal;
  
  public static ProposalRepository proposal() {
    if (proposal == null) {
      proposal = new JournalProposalRepository();
    }
    return proposal;
  }
}
