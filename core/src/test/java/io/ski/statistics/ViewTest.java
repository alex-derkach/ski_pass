package io.ski.statistics;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.type.LimitedCard;
import io.ski.card.type.UnlimitedCard;
import io.ski.statistics.domain.AuthorizedPassEvent;
import io.ski.statistics.domain.PassEvent;
import io.ski.statistics.domain.PassStatus;
import io.ski.statistics.domain.UnauthorizedPassEvent;
import io.ski.statistics.repository.PassEventRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewTest extends AbstractMockitoTest {

  private static final LocalDateTime CURRENT_TIME = LocalDateTime.now();
  private static final LocalDateTime TIME_AFTER_CURRENT = CURRENT_TIME.plusDays(1);
  private static final LocalDateTime TIME_BEFORE_CURRENT = CURRENT_TIME.minusDays(1);

  private static final List<String> ERRORS = Collections.emptyList();
  private static final String LIMITED_CARD_DISCRIMINATOR = "LIMITED";
  private static final String UNLIMITED_CARD_DISCRIMINATOR = "UNLIMITED";

  private static final int EXPECTED_AUTHORIZED_COUNT = 2;
  private static final int EXPECTED_UNAUTHORIZED_COUNT = 2;
  private static final int EXPECTED_COUNT = 4;
  private static final int EXPECTED_LIMITED_COUNT = 2;
  private static final int EXPECTED_UNLIMITED_COUNT = 2;
  private static final int EXPECTED_COUNT_FROM_TIME_BEFORE_CURRENT_TO_CURRENT_TIME = 0;
  private static final int EXPECTED_COUNT_FROM_TIME_BEFORE_CURRENT_TO_TIME_AFTER_CURRENT = 4;
  private static final int EXPECTED_COUNT_FROM_CURRENT_TO_TIME_AFTER_CURRENT_TIME = 0;

  private static PassEventRepository EVENT_REPOSITORY;
  private static List<PassEvent> EVENTS;

  private View view;

  @BeforeClass
  public static void beforeClass() {
    LimitedCard limitedCard = mock(LimitedCard.class);
    UnlimitedCard unlimitedCard = mock(UnlimitedCard.class);

    when(limitedCard.getDiscriminator()).thenReturn(LIMITED_CARD_DISCRIMINATOR);
    when(unlimitedCard.getDiscriminator()).thenReturn(UNLIMITED_CARD_DISCRIMINATOR);

    EVENTS = Arrays.asList(
        new UnauthorizedPassEvent(ERRORS, CURRENT_TIME, limitedCard),
        new AuthorizedPassEvent(CURRENT_TIME, limitedCard),
        new UnauthorizedPassEvent(ERRORS, CURRENT_TIME, unlimitedCard),
        new AuthorizedPassEvent(CURRENT_TIME, unlimitedCard)
    );

    EVENT_REPOSITORY = mock(PassEventRepository.class);
    when(EVENT_REPOSITORY.findAll()).thenReturn(EVENTS);
  }

  @Before
  public void setup() {
    view = new View(EVENT_REPOSITORY);
  }

  @Test
  public void shouldContain2AuthorizedEventWhenFilteredByAuthorized() {
    assertEquals(EXPECTED_AUTHORIZED_COUNT, view.filterByStatus(PassStatus.AUTHORIZED).count());
  }

  @Test
  public void shouldContain2AuthorizedEventWhenFilteredByUnauthorized() {
    assertEquals(EXPECTED_UNAUTHORIZED_COUNT, view.filterByStatus(PassStatus.UNAUTHORIZED).count());
  }

  @Test
  public void shouldContain4EventsWhenCalledCount() {
    assertEquals(EXPECTED_COUNT, view.count());
  }

  @Test
  public void shouldContain0EventsWhenFilteredStrictByRangeFromTimeBeforeCurrentToCurrent() {
    assertEquals(
        EXPECTED_COUNT_FROM_TIME_BEFORE_CURRENT_TO_CURRENT_TIME,
        view.filterStrictByRange(TIME_BEFORE_CURRENT, CURRENT_TIME).count()
    );
  }

  @Test
  public void shouldContain4EventsWhenFilteredStrictByRangeFromTimeBeforeCurrentToTimeAfterCurrent() {
    assertEquals(
        EXPECTED_COUNT_FROM_TIME_BEFORE_CURRENT_TO_TIME_AFTER_CURRENT,
        view.filterStrictByRange(TIME_BEFORE_CURRENT, TIME_AFTER_CURRENT).count()
    );
  }

  @Test
  public void shouldContain0EventsWhenFilteredStrictByRangeFromCurrentToTimeAfterCurrent() {
    assertEquals(
        EXPECTED_COUNT_FROM_CURRENT_TO_TIME_AFTER_CURRENT_TIME,
        view.filterStrictByRange(CURRENT_TIME, TIME_AFTER_CURRENT).count()
    );
  }

  @Test
  public void shouldReturnValidMappingWhenCalledGroupByCardType() {
    Map<String, List<PassEvent>> map = view.groupByCardType();
    Set<String> expectedKeys = new HashSet<>(Arrays.asList(LIMITED_CARD_DISCRIMINATOR, UNLIMITED_CARD_DISCRIMINATOR));

    assertEquals(map.keySet(), expectedKeys);
    assertEquals(map.get(LIMITED_CARD_DISCRIMINATOR).size(), EXPECTED_LIMITED_COUNT);
    assertEquals(map.get(UNLIMITED_CARD_DISCRIMINATOR).size(), EXPECTED_UNLIMITED_COUNT);
  }

  @Test
  public void shouldReturnValidCollectionWhenCalledCollect() {
    Collection<PassEvent> passEvents = view.collect();
    assertEquals(passEvents, EVENTS);
  }
}