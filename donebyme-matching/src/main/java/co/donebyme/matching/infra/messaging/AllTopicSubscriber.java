package co.donebyme.matching.infra.messaging;

import java.util.Date;

import co.donebyme.matching.infra.API;
import co.vaughnvernon.mockroservices.messagebus.Message;
import co.vaughnvernon.mockroservices.messagebus.MessageBus;
import co.vaughnvernon.mockroservices.messagebus.MessageExchangeReader;
import co.vaughnvernon.mockroservices.messagebus.Subscriber;
import co.vaughnvernon.mockroservices.messagebus.Topic;

public class AllTopicSubscriber implements Subscriber {
  private static AllTopicSubscriber instance;
  
  private final Topic allTopic;
  
  public static AllTopicSubscriber start() {
    	if (instance == null) {
    		instance = new AllTopicSubscriber();
    	}
    	return instance;
  }
  
  @Override
  public void handle(final Message message) {
    final MessageExchangeReader reader = MessageExchangeReader.from(message);
    switch (message.type) {
    case "co.donebyme.pricing.model.analysis.PricingVerified":
      API.proposal().verifyPricing(
              reader.payloadStringValue("originatorId"));
      break;
    case "co.donebyme.pricing.model.analysis.PricingRejected":
      API.proposal().denyPricing(
              reader.payloadStringValue("originatorId"),
              reader.payloadLongValue("suggestedPrice"));
      break;
    case "co.donebyme.scheduling.model.availability.SchedulingVerified":
      API.proposal().verifyScheduling(
              reader.payloadStringValue("originatorId"));
      break;
    case "co.donebyme.scheduling.model.availability.SchedulingRejected":
      API.proposal().denyScheduling(
              reader.payloadStringValue("originatorId"),
              new Date(reader.payloadLongValue("suggestedCompletedBy")));
      break;
    }
  }
  
  private AllTopicSubscriber() {
    final MessageBus messageBus = MessageBus.start("donebyme");
    this.allTopic = messageBus.openTopic("all");
    
    allTopic.subscribe(this);
  }
}
