package co.donebyme.profile.model;

public final class Money {
  public final long value;

  public static Money of(final Money money) {
    return new Money(money);
  }

  public static Money of(final long value) {
    return new Money(value);
  }

  public static Money none() {
    return new Money();
  }

  public Money(final Money money) {
    this.value = money.value;
  }

  public Money(final long value) {
    this.value = value;
  }

  public Money() {
    this.value = 0;
  }

  public Money add(final Money money) {
    return new Money(this.value + money.value);
  }

  public Money divideBy(final int factor) {
    return new Money(this.value / factor);
  }

  public Money multiplyBy(final int factor) {
    return new Money(this.value * factor);
  }

  public Money subtract(final Money money) {
    return new Money(this.value - money.value);
  }

  public String scaledBy(final int scale) {
    final String textVaule = String.valueOf(value);
    if (textVaule.length() < scale) {
      throw new IllegalStateException("Value cannot be scaled by " + scale);
    } else if (textVaule.length() == scale) {
      return "0." + textVaule;
    }
    final int position = textVaule.length() - scale;
    final String left = textVaule.substring(0, position);
    final String right = textVaule.substring(position);
    return left + "." + right;
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != getClass()) {
      return false;
    }
    return this.value == ((Money) other).value;
  }

  @Override
  public int hashCode() {
    return (int) ((31 * value) + value);
  }

  @Override
  public String toString() {
    return "Money[value=" + value + "]";
  }
}
