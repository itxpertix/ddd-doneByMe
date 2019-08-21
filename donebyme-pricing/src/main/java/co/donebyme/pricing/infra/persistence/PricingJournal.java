package co.donebyme.pricing.infra.persistence;

import co.vaughnvernon.mockroservices.eventjournal.EventJournal;

public class PricingJournal {
  public static final EventJournal eventJournal;
  
  static {
    eventJournal = EventJournal.open("donebyme-pricing");
  }

  public static void start() { }
  
  public static void stop() {
    eventJournal.close();
  }
}
