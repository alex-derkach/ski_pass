package io.ski.statistics.repository;

import io.ski.statistics.domain.PassEvent;
import io.ski.util.AbstractMockitoTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;

public class CollectionBasedPassEventRepositoryTest extends AbstractMockitoTest {

  @Mock private PassEvent passEvent;

  private CollectionBasedPassEventRepository repository;

  @Before
  public void setup() {
    repository = new CollectionBasedPassEventRepository();
  }

  @Test
  public void shouldContainPersistentEvent() {
    repository.persist(passEvent);

    assertTrue(repository.findAll().contains(passEvent));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void shouldReturnUnmodifiableCollectionWhenCalledFindAll() {
    repository.findAll().clear();
  }
}