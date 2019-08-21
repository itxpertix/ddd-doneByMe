package co.donebyme.matching.infra.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import co.donebyme.matching.infra.API;
import co.donebyme.matching.infra.projection.ProposalView;
import co.donebyme.matching.query.ProposalQuery;

public class ProposalController {
  
  public ProposalView get(final String proposalId) {
    return new ProposalQuery().proposal(proposalId);
  }

  public List<ProposalView> getForClient(final String clientId) {
    return new ProposalQuery().proposals(clientId);
  }
  
  public void submit(
      final String clientId,
      final String summary,
      final String description,
      final List<String> keywords,
      final Date completedBy,
      final Map<Integer, String> steps,
      final long price) {
    
      API.proposal()
        .submitProposal(
          clientId,
          summary,
          description,
          keywords,
          completedBy,
          steps,
          price);
  }
}
