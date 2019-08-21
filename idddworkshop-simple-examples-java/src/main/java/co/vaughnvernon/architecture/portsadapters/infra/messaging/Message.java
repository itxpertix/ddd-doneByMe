package co.vaughnvernon.architecture.portsadapters.infra.messaging;

public class Message {
  public final String id;
  public final String payload;
  public final String type;

  public Message(final String id, final String type, final String payload) {
    this.id = id;
    this.type = type;
    this.payload = payload;
  }
}
