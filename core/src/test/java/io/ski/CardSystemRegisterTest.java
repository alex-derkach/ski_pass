package io.ski;

import io.ski.exception.AlreadyRegisteredCardTypeException;
import io.ski.exception.UnregisteredCardTypeException;
import org.junit.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CardSystemRegisterTest extends AbstractCardSystemTest {

  private static final String UNREGISTERED_CARD_DISCRIMINATOR = "UNREGISTERED_CARD_DISCRIMINATOR";

  @Test(expected = NullPointerException.class)
  public void shouldNotRegisterDefinitionWithNullDiscriminator() {
    when(cardDefinition.getDiscriminator()).thenReturn(null);

    cardSystem.registerCardType(cardDefinition);
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotRegisterDefinitionWithNullCardFactory() {
    when(cardDefinition.getCardFactory()).thenReturn(null);

    cardSystem.registerCardType(cardDefinition);
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotRegisterDefinitionWithNullValidator() {
    when(cardDefinition.getValidator()).thenReturn(null);

    cardSystem.registerCardType(cardDefinition);
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotRegisterDefinitionWithNullPassHandler() {
    when(cardDefinition.getHandler()).thenReturn(null);

    cardSystem.registerCardType(cardDefinition);
  }

  @Test
  public void shouldSetHolidayResolverInValidatorWhenRegisterIsCalled() {
    verify(validator).setHolidayResolver(holidayResolver);
  }

  @Test(expected = UnregisteredCardTypeException.class)
  public void shouldThrowExceptionWhenCalledCreateWithUnregisteredDiscriminator() {
    cardSystem.create(UNREGISTERED_CARD_DISCRIMINATOR);
  }

  @Test(expected = AlreadyRegisteredCardTypeException.class)
  public void shouldThrowExceptionWhenCalledRegisterWithAlreadyRegisteredDefinition() {
    cardSystem.registerCardType(cardDefinition);
  }
}