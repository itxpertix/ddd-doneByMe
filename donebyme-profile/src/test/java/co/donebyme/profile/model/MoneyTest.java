package co.donebyme.profile.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoneyTest {

  @Test
  public void testThatMoneyScales() {
    final Money money1 = Money.of(1234599);
    assertEquals("12345.99", money1.scaledBy(2));
    final Money money2 = Money.of(1234567995);
    assertEquals("1234567.995", money2.scaledBy(3));
  }
}
