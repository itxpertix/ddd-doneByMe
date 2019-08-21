package co.vaughnvernon.architecture.portsadapters.model;

import java.util.UUID;

// Model: Id Value Object

public class Id {
  public final String value;

  public static Id unique() {
    return new Id(UUID.randomUUID().toString());
  }

  public Id(final String value) {
    this.value = value;
  }
}
