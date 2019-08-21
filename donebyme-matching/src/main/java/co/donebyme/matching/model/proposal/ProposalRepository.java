package co.donebyme.matching.model.proposal;

import co.donebyme.matching.model.Id;

public interface ProposalRepository {
  Proposal proposalOf(final Id id);
  void save(final Proposal proposal);
}
