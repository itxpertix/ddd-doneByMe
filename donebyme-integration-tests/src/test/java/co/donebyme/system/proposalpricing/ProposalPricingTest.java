package co.donebyme.system.proposalpricing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.donebyme.matching.infra.persistence.Repositories;
import co.donebyme.matching.model.Client;
import co.donebyme.matching.model.Description;
import co.donebyme.matching.model.Keywords;
import co.donebyme.matching.model.Summary;
import co.donebyme.matching.model.proposal.Expectations;
import co.donebyme.matching.model.proposal.Proposal;
import co.donebyme.matching.model.proposal.Step;
import co.vaughnvernon.mockroservices.messagebus.Message;
import co.vaughnvernon.mockroservices.messagebus.MessageBus;
import co.vaughnvernon.mockroservices.messagebus.Subscriber;

public class ProposalPricingTest {
  private boolean received;
  
  @Test
  public void testProposalPricingVerified() {
    // full circle implementation

    received = false;

    Subscriber subscriber = new Subscriber() {
      @Override
      public void handle(Message message) {
        received = true;
        switch (message.type) {
        case "co.donebyme.pricing.model.analysis.PricingVerified":
          System.out.println("Round Trip: PricingVerified");
          break;
        case "co.donebyme.pricing.model.analysis.PricingRejected":
          System.out.println("Round Trip: PricingRejected");
          break;
        }
      }
    };
    
    MessageBus
      .start("donebyme")
      .openTopic("all")
      .subscribe(subscriber);
    
    final Proposal proposal = Proposal.submitFor(client(), expectations());
    
    Repositories.proposal().save(proposal);
    
    Proposal existing = Repositories.proposal().proposalOf(proposal.id());

    assertNotNull(existing);
    
    pause();
    
    assertTrue(received);
  }

  @Before
  public void setUp() {
    co.donebyme.matching.infra.StartUp.main(new String[] {});
    co.donebyme.pricing.infra.StartUp.main(new String[] {});
  }

  private Client client() {
    return Client.from("12345");
  }
  
  private Expectations expectations() {
    return
        Expectations.of(
            Summary.has("A summary"),
            Description.has("A description"),
            Keywords.are("#windows", "#washing", "#indoor", "#outdoor", "#extra-tall"),
            new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000)),
            Collections.singleton(Step.ordered(1, Description.has("Step 1"))),
            1995);
  }

  private void pause() {
    try { Thread.sleep(1000); } catch (Exception e) { }
  }
}
