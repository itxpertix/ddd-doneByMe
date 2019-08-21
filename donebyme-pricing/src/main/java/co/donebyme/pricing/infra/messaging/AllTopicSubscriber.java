package co.donebyme.pricing.infra.messaging;

import co.donebyme.pricing.infra.API;
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
    case "co.donebyme.matching.model.proposal.ProposalSubmitted":
      API.pricingVerification().verifyPricing(
              reader.stringValue("proposalId"),
              reader.stringArrayValue("keywords"),
              reader.dateValue("completedBy"),
              reader.longValue("price"));
      break;
    case "co.donebyme.matching.model.proposal.ProposalResubmitted":
      API.pricingVerification().verifyAdjustedPricing(
              reader.stringValue("proposalId"),
              reader.stringArrayValue("keywords"),
              reader.dateValue("completedBy"),
              reader.longValue("price"));
      break;
    }
  }
  
  private AllTopicSubscriber() {
    final MessageBus messageBus = MessageBus.start("donebyme");
    this.allTopic = messageBus.openTopic("all");
    
    allTopic.subscribe(this);
  }
}
