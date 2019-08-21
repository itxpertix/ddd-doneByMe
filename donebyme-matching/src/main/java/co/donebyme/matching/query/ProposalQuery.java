package co.donebyme.matching.query;

import java.util.List;

import co.donebyme.matching.infra.projection.ProposalView;

public class ProposalQuery {
  public ProposalView proposal(final String proposalId) {
    return ProposalView.get(proposalId);
  }

  public List<ProposalView> proposals(String clientId) {
    return ProposalView.getAllFor(clientId);
  }
}
