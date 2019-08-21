package co.donebyme.matching.model.proposal;

import java.util.HashSet;
import java.util.Set;

public final class ProgressFunctions {
  public static boolean isAcceptable(final Progress progress) {
    return
        wasSubmitted(progress) &&
        wasPricingVerified(progress) &&
        wasSchedulingVerified(progress);
  }

  public static boolean isUnacceptable(final Progress progress) {
    return
        wasSubmitted(progress) &&
        wasPricingDenied(progress) || wasSchedulingDenied(progress);
  }

  public static boolean wasPricingDenied(final Progress progress) {
    return progress.specs.contains(Spec.PricingDenied);
  }

  public static boolean wasPricingVerified(final Progress progress) {
    return progress.specs.contains(Spec.PricingVerified);
  }

  public static boolean wasSchedulingDenied(final Progress progress) {
    return progress.specs.contains(Spec.SchedulingDenied);
  }

  public static boolean wasSchedulingVerified(final Progress progress) {
    return progress.specs.contains(Spec.SchedulingVerified);
  }

  public static boolean wasSubmitted(final Progress progress) {
    return progress.specs.contains(Spec.Submitted);
  }

  protected static Progress deniedForPricing(final Progress progress) {
    return withNewSpec(progress, Spec.PricingDenied);
  }

  protected static Progress deniedForScheduling(final Progress progress) {
    return withNewSpec(progress, Spec.SchedulingDenied);
  }

  protected static Progress submittedByClient(final Progress progress) {
    return withOnlySpec(progress, Spec.Submitted);
  }

  protected static Progress verifiedForPricing(final Progress progress) {
    return withNewSpec(progress, Spec.PricingVerified);
  }

  protected static Progress verifiedForScheduling(final Progress progress) {
    return withNewSpec(progress, Spec.SchedulingVerified);
  }

  private static Progress withNewSpec(final Progress progress, final Spec spec) {
    final Set<Spec> newSpecs = new HashSet<Spec>(progress.specs);
    newSpecs.add(spec);
    return new Progress(newSpecs);
  }

  private static Progress withOnlySpec(final Progress progress, final Spec spec) {
    final Set<Spec> newSpecs = new HashSet<Spec>();
    newSpecs.add(spec);
    return new Progress(newSpecs);
  }
}
