package co.donebyme.matching.model.proposal;

import java.util.HashSet;
import java.util.Set;

public final class Progress {
  public static Progress None = new Progress();
  public static Progress Submitted = new Progress(Spec.Submitted);
  public static Progress Resubmitted = new Progress(Spec.Resubmitted);

  protected final Set<Spec> specs;

  public boolean isAcceptable() {
    return wasSubmitted() && wasPricingVerified() && wasSchedulingVerified();
  }

  public boolean isUnacceptable() {
    return wasSubmitted() && wasPricingDenied() || wasSchedulingDenied();
  }

  public boolean wasPricingDenied() {
    return specs.contains(Spec.PricingDenied);
  }

  public boolean wasPricingVerified() {
    return specs.contains(Spec.PricingVerified);
  }

  public boolean wasSchedulingDenied() {
    return specs.contains(Spec.SchedulingDenied);
  }

  public boolean wasSchedulingVerified() {
    return specs.contains(Spec.SchedulingVerified);
  }

  public boolean wasSubmitted() {
    return specs.contains(Spec.Submitted);
  }
  
  @Override
  public int hashCode() {
    return specs.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != Progress.class) {
      return false;
    }
    
    final Progress otherProgress = (Progress) other;
    
    return this.specs.equals(otherProgress.specs);
  }

  @Override
  public String toString() {
    return "Progress[specs=" + specs + "]";
  }

  protected Progress deniedForPricing() {
    return withNewSpec(Spec.PricingDenied);
  }

  protected Progress deniedForScheduling() {
    return withNewSpec(Spec.SchedulingDenied);
  }

  protected Progress verifiedForPricing() {
    return withNewSpec(Spec.PricingVerified);
  }

  protected Progress verifiedForScheduling() {
    return withNewSpec(Spec.SchedulingVerified);
  }

  Progress() {
    this.specs = new HashSet<>();
  }

  Progress(final Spec spec) {
    this.specs = new HashSet<>();
    this.specs.add(spec);
  }

  Progress(final Set<Spec> specs) {
    this.specs = specs;
  }

  Progress withNewSpec(final Spec spec) {
    final Set<Spec> newSpecs = new HashSet<Spec>(this.specs);
    newSpecs.add(spec);
    return new Progress(newSpecs);
  }

  Progress withOnlySpec(final Spec spec) {
    return new Progress(spec);
  }
}
