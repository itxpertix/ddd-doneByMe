package co.donebyme.matching.model.proposal;

import static org.junit.Assert.*;
import org.junit.Test;

import static co.donebyme.matching.model.proposal.ProgressFunctions.*;

public class ProgressTest {

  @Test
  public void testObjectProgression() throws Exception {
    final Progress acceptable =
        Progress.Submitted
          .verifiedForPricing()
          .verifiedForScheduling();
    
    assertTrue(acceptable.isAcceptable());
  }

  @Test
  public void testFunctionProgression() throws Exception {
    final Progress progress = Progress.Submitted;
    
    final Progress submitted =
        submittedByClient(progress);

    final Progress submittedVerifiedPricing =
        verifiedForPricing(submitted);

    final Progress submittedVerifiedPricingScheduling =
        verifiedForScheduling(submittedVerifiedPricing);

    assertTrue(isAcceptable(submittedVerifiedPricingScheduling));
  }

  @Test
  public void testComposedFunctionProgression() throws Exception {
    final Progress progress = Progress.Submitted;
    
    final Progress acceptable =
        verifiedForScheduling(
            verifiedForPricing(
                submittedByClient(progress)));

    assertTrue(isAcceptable(acceptable));
  }
}
