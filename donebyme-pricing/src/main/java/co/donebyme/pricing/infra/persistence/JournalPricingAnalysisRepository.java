package co.donebyme.pricing.infra.persistence;

import co.donebyme.pricing.model.Id;
import co.donebyme.pricing.model.analysis.PricingAnalysis;
import co.donebyme.pricing.model.analysis.PricingAnalysisRepository;
import co.vaughnvernon.mockroservices.eventjournal.EventJournal;
import co.vaughnvernon.mockroservices.eventjournal.EventStream;
import co.vaughnvernon.mockroservices.eventjournal.EventStreamReader;
import co.vaughnvernon.mockroservices.eventjournal.Repository;

public class JournalPricingAnalysisRepository
  extends Repository implements PricingAnalysisRepository {
  
  private final EventJournal journal;
  private final EventStreamReader reader;
  
  @Override
  public PricingAnalysis pricingAnalysisOf(final Id id) {
    final EventStream stream =
        reader.streamFor(id.value);
    
    return new PricingAnalysis(toSourceStream(stream.stream), stream.streamVersion);
  }

  @Override
  public void save(final PricingAnalysis pricingAnalysis) {
    journal.write(
        pricingAnalysis.id().value,
        pricingAnalysis.nextVersion(),
        toBatch(pricingAnalysis.applied()));
  }

  JournalPricingAnalysisRepository() {
    this.journal = PricingJournal.eventJournal;
    this.reader = this.journal.streamReader();
  }
}
