package co.donebyme.profile.model.doer.skills;

import co.donebyme.profile.model.Money;

public final class Rate implements Comparable<Rate> {
  public enum Type { Hourly, Flat };

  public final Money money;
  public final Type type;

  public static Rate flatRateOf(final long amount) {
    return new Rate(Type.Flat, Money.of(amount));
  }

  public static Rate flatRateOf(final Money money) {
    return new Rate(Type.Flat, money);
  }

  public static Rate hourlyRateOf(final long amount) {
    return new Rate(Type.Hourly, Money.of(amount));
  }

  public static Rate hourlyRateOf(final Money money) {
    return new Rate(Type.Hourly, money);
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != getClass()) {
      return false;
    }
    final Rate otherRate = (Rate) other;
    return this.type == otherRate.type && this.money.equals(otherRate.money);
  }

  @Override
  public int hashCode() {
    return 31 * this.type.hashCode() * this.money.hashCode();
  }

  @Override
  public String toString() {
    return "Rate[type=" + this.type + ", money=" + money + "]";
  }

  @Override
  public int compareTo(final Rate other) {
    final int typeCompare = type.compareTo(other.type);
    if (typeCompare != 0) return typeCompare;
    if (money.equals(other.money)) return (int) (money.value - other.money.value);
    return 0;
  }

  private Rate(final Type type, final Money money) {
    this.type = type;
    this.money = money;
  }
}
