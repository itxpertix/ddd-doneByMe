package co.donebyme.matching.infra.projection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProposalView {
  // memory cached proposal views
  protected static Map<String,ProposalView> views = new HashMap<>();

  public static ProposalView get(String proposalId) {
    return views.get(proposalId);
  }
  
  public static List<ProposalView> getAllFor(final String clientId) {
    // there could be a different map for this kind
    // of view, but just saving time in example
    final List<ProposalView> clientProposalViews = new ArrayList<>();
    for (final ProposalView view : views.values()) {
      if (view.clientId.equals(clientId)) {
        clientProposalViews.add(view);
      }
    }
    
    return clientProposalViews;
  }
  
  public final String proposalId;
  public final String clientId;
  public final String description;
  public final String summary;
  public final long completedBy;
  public final long suggestedCompletedBy;
  public final String[] steps;
  public final long price;
  public final long suggestedPrice;
  public final String[] progress;
  
  protected ProposalView(
      final String proposalId,
      final String clientId,
      final String description,
      final String summary,
      final long completedBy,
      final long suggestedCompletedBy,
      final String[] steps,
      final long price,
      final long suggestedPrice,
      final String[] progress) {
    
    this.proposalId = proposalId;
    this.clientId = clientId;
    this.description = description;
    this.summary = summary;
    this.completedBy = completedBy;
    this.suggestedCompletedBy = suggestedCompletedBy;
    this.steps = steps;
    this.price = price;
    this.suggestedPrice = suggestedPrice;
    this.progress = progress;
  }
  
  protected ProposalView(
      final ProposalView proposalView,
      final long suggestedCompletedBy,
      final long suggestedPrice,
      final String[] newProgress) {
    this(
        proposalView.proposalId,
        proposalView.clientId,
        proposalView.description,
        proposalView.summary,
        proposalView.completedBy,
        suggestedCompletedBy,
        proposalView.steps,
        proposalView.price,
        suggestedPrice,
        newProgress);
  }
  
  protected ProposalView(
      final ProposalView proposalView,
      final String[] newProgress) {
    this(
        proposalView.proposalId,
        proposalView.clientId,
        proposalView.description,
        proposalView.summary,
        proposalView.completedBy,
        proposalView.suggestedCompletedBy,
        proposalView.steps,
        proposalView.price,
        proposalView.suggestedPrice,
        newProgress);
  }
  
  protected ProposalView withProgress(final String progress) {
    return new ProposalView(this, withNewProgress(progress));
  }
  
  protected ProposalView withSchedulingDenied(
      final long suggestedCompletedBy) {
    return new ProposalView(
        this,
        suggestedCompletedBy,
        this.suggestedPrice,
        withNewProgress("SchedulingDenied"));
  }
  
  protected ProposalView withPricingDenied(
      final long suggestedPrice) {
    return new ProposalView(
        this,
        this.suggestedCompletedBy,
        suggestedPrice,
        withNewProgress("PricingDenied"));
  }
  
  private String[] withNewProgress(final String progress) {
    final List<String> current = Arrays.asList(this.progress);
    current.add(progress);
    final String[] newProgress = new String[current.size()];
    return current.toArray(newProgress);
  }
}
