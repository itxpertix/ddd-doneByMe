package co.donebyme.matching.infra.projection;

import co.vaughnvernon.mockroservices.messagebus.Message;
import co.vaughnvernon.mockroservices.model.DomainEvent;
import co.vaughnvernon.mockroservices.serialization.Serialization;

public abstract class Projection {
  
  @SuppressWarnings("unchecked")
  protected DomainEvent toEvent(final Message message) throws Exception {
    final Class<DomainEvent> type = (Class<DomainEvent>) Class.forName(message.type);
    final DomainEvent event = Serialization.deserialize(message.payload, type);
    return event;
  }
}
