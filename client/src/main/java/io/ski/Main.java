package io.ski;

import io.ski.statistics.domain.PassStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

  private static final int CARD_COUNT = 500;
  private static final int PASS_COUNT = 20000;
  private static final Random RANDOM = new Random();
  private static final Logger LOG = LogManager.getLogger(Main.class);

  public static void main(String[] args) {

    CardSystemFactory cardSystemFactory = new CardSystemFactory();
    CardSystem cardSystem = cardSystemFactory.create();
    Turnstile turnstile = new Turnstile(cardSystem);

    List<String> types = Arrays.asList(
        "WorkdayLimited10CardDefinition",
        "WorkdayUnlimitedFirstHalfOfDayCardDefinition"
    );

    // build list of cards
    List<UserCard> cards = RANDOM
        .ints(0, types.size())
        .limit(CARD_COUNT)
        .mapToObj(number -> cardSystem.create(types.get(number)))
        .collect(Collectors.toList());

    // spam turnstile
    RANDOM
        .ints(0, cards.size())
        .limit(PASS_COUNT)
        .forEach(number -> turnstile.pass(cards.get(number)));

    LOG.info(String.format("%5d events overall", cardSystem.createEventQueryView().count()));
    LOG.info(String.format("%5d events related to validation rejection", cardSystem.createEventQueryView().filterByStatus(PassStatus.UNAUTHORIZED).count()));
    LOG.info(String.format("%5d events related to successful passing", cardSystem.createEventQueryView().filterByStatus(PassStatus.AUTHORIZED).count()));
  }
}
