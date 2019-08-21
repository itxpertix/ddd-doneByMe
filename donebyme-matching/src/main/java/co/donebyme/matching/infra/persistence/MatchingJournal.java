package co.donebyme.matching.infra.persistence;

import co.vaughnvernon.mockroservices.eventjournal.EventJournal;

public class MatchingJournal {
  public static final EventJournal eventJournal;
  
  static {
    eventJournal = EventJournal.open("donebyme-matching");
  }

  public static void start() { }
  
  public static void stop() {
    eventJournal.close();
  }
}
