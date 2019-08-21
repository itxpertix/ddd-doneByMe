package co.donebyme.pricing.infra;

import co.donebyme.pricing.infra.messaging.AllTopicSubscriber;
import co.donebyme.pricing.infra.messaging.PricingJournalPublisher;
import co.donebyme.pricing.infra.persistence.PricingJournal;

public class StartUp {
  public static void main(final String[] args) {
    PricingJournal.start();
    PricingJournalPublisher.start();
    AllTopicSubscriber.start();
  }
}
