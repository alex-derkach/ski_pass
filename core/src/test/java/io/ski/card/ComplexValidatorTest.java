package io.ski.card;

import io.ski.util.AbstractMockitoTest;
import io.ski.support.validation.BindingResult;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ComplexValidatorTest extends AbstractMockitoTest {

  private static final Validator<Card> DUMMY_VALIDATOR = (card, bindingResult) -> {};
  private static final Validator<Card> NULL_VALIDATOR = null;
  private static final BindingResult DUMMY_BINDING_RESULT = new BindingResult();
  private static final Card DUMMY_CARD = mock(Card.class);

  @Mock
  private ComplexValidator<Card> validator;

  @Test
  public void shouldAddValidatorToCollectionWhenRegistered() {
    validator.registerValidators(DUMMY_VALIDATOR);

    assertTrue(validator.getValidators().contains(DUMMY_VALIDATOR));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowExceptionWhenRegisteringNullValidator() {
    validator.registerValidators(NULL_VALIDATOR);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldCallRegisteredValidatorWhenCalledValidate() {
    Validator spiedValidator = mock(Validator.class);
    Card card = mock(Card.class);
    BindingResult bindingResult = new BindingResult();

    validator.registerValidators(spiedValidator);
    validator.validate(card, bindingResult);

    verify(spiedValidator).validate(card, bindingResult);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldCallValidatorsInRegistrationOrderWhenCalledValidate() {
    Validator firstValidator = mock(Validator.class);
    Validator secondValidator = mock(Validator.class);

    validator.registerValidators(firstValidator, secondValidator);
    validator.validate(DUMMY_CARD, DUMMY_BINDING_RESULT);

    InOrder inOrder = inOrder(firstValidator, secondValidator);
    inOrder.verify(firstValidator).validate(DUMMY_CARD, DUMMY_BINDING_RESULT);
    inOrder.verify(secondValidator).validate(DUMMY_CARD, DUMMY_BINDING_RESULT);
    inOrder.verifyNoMoreInteractions();
  }

}