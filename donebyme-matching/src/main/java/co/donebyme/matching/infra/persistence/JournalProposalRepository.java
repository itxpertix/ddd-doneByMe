package co.donebyme.matching.infra.persistence;

import co.donebyme.matching.model.Id;
import co.donebyme.matching.model.proposal.Proposal;
import co.donebyme.matching.model.proposal.ProposalRepository;
import co.vaughnvernon.mockroservices.eventjournal.EventJournal;
import co.vaughnvernon.mockroservices.eventjournal.EventStream;
import co.vaughnvernon.mockroservices.eventjournal.EventStreamReader;
import co.vaughnvernon.mockroservices.eventjournal.Repository;

public class JournalProposalRepository
  extends Repository implements ProposalRepository {
  
  private final EventJournal journal;
  private final EventStreamReader reader;
  
  @Override
  public Proposal proposalOf(final Id id) {
    final EventStream stream =
        reader.streamFor(id.value);
    
    return new Proposal(toSourceStream(stream.stream), stream.streamVersion);
  }

  @Override
  public void save(final Proposal proposal) {
    journal.write(
        proposal.id().value,
        proposal.nextVersion(),
        toBatch(proposal.applied()));
  }

  protected JournalProposalRepository() {
    this.journal = EventJournal.open("donebyme-matching");
    this.reader = this.journal.streamReader();
  }
}
