package io.ski;

import io.ski.cards.workday.limited.WorkdayLimited10CardDefinition;
import io.ski.cards.workday.unlimited.WorkdayUnlimitedFirstHalfOfDayCardDefinition;
import io.ski.statistics.domain.PassStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

  public static final int CARD_COUNT = 500;
  public static final int PASS_COUNT = 20000;
  public static final Random RANDOM = new Random();

  public static void main(String[] args) {
    CardSystemFactory cardSystemFactory = new CardSystemFactory();
    CardSystem cardSystem = cardSystemFactory.create();
    Turnstile turnstile = new Turnstile(cardSystem);

    List<String> types = Arrays.asList(
        WorkdayLimited10CardDefinition.CARD_DISCRIMINATOR,
        WorkdayUnlimitedFirstHalfOfDayCardDefinition.CARD_DISCRIMINATOR
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

    System.out.printf("%d events overall\n", cardSystem.createEventQueryView().count());
    System.out.printf("%d events related to validation rejection\n", cardSystem.createEventQueryView().filterByStatus(PassStatus.UNAUTHORIZED).count());
    System.out.printf("%d events related to successful passing\n", cardSystem.createEventQueryView().filterByStatus(PassStatus.AUTHORIZED).count());
  }
}
