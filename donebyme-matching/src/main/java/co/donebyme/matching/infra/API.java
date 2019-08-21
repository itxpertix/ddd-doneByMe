package co.donebyme.matching.infra;

import co.donebyme.matching.application.ProposalCommands;
import co.donebyme.matching.infra.persistence.Repositories;

public class API {
  private static ProposalCommands proposal;
  public static ProposalCommands proposal() {
    if (proposal == null) {
      proposal = new ProposalCommands(Repositories.proposal());
    }
    return proposal;
  }
}
