package io.ski;

import io.ski.cards.Season2015CardDefinition;
import io.ski.cards.not_workday.limited.NotWorkdayLimited100CardDefinition;
import io.ski.cards.not_workday.limited.NotWorkdayLimited10CardDefinition;
import io.ski.cards.not_workday.limited.NotWorkdayLimited20CardDefinition;
import io.ski.cards.not_workday.limited.NotWorkdayLimited50CardDefinition;
import io.ski.cards.not_workday.unlimited.NotWorkdayUnlimited1DayCardDefinition;
import io.ski.cards.not_workday.unlimited.NotWorkdayUnlimited2DaysCardDefinition;
import io.ski.cards.not_workday.unlimited.NotWorkdayUnlimitedFirstHalfOfDayCardDefinition;
import io.ski.cards.not_workday.unlimited.NotWorkdayUnlimitedSecondHalfOfDayCardDefinition;
import io.ski.cards.workday.limited.WorkdayLimited100CardDefinition;
import io.ski.cards.workday.limited.WorkdayLimited10CardDefinition;
import io.ski.cards.workday.limited.WorkdayLimited20CardDefinition;
import io.ski.cards.workday.limited.WorkdayLimited50CardDefinition;
import io.ski.cards.workday.unlimited.*;
import io.ski.CardSystem;
import io.ski.card.Card;
import io.ski.card.CardDefinition;
import io.ski.repository.CardRepository;
import io.ski.repository.CollectionBasedCardRepository;
import io.ski.repository.generator.AutoIncrementationIdentifierGenerator;
import io.ski.repository.generator.IdentifierGenerator;
import io.ski.statistics.repository.CollectionBasedPassEventRepository;
import io.ski.statistics.repository.PassEventRepository;
import io.ski.support.validation.DefaultHolidayResolver;
import io.ski.support.validation.HolidayResolver;

import java.util.Arrays;
import java.util.List;

public class CardSystemFactory {

  public CardSystem create() {

    IdentifierGenerator identifierGenerator = new AutoIncrementationIdentifierGenerator();

    CardRepository cardRepository = new CollectionBasedCardRepository(identifierGenerator);
    PassEventRepository passEventRepository = new CollectionBasedPassEventRepository();

    HolidayResolver holidayResolver = new DefaultHolidayResolver();

    CardSystem cardSystem = new CardSystem(cardRepository, passEventRepository, holidayResolver);

    List<CardDefinition<? extends Card>> cardDefinitions = Arrays.asList(
        new WorkdayLimited10CardDefinition(),
        new WorkdayLimited20CardDefinition(),
        new WorkdayLimited50CardDefinition(),
        new WorkdayLimited100CardDefinition(),

        new WorkdayUnlimitedFirstHalfOfDayCardDefinition(),
        new WorkdayUnlimitedSecondHalfOfDayCardDefinition(),
        new WorkdayUnlimited1DayCardDefinition(),
        new WorkdayUnlimited2DaysCardDefinition(),
        new WorkdayUnlimited5DaysCardDefinition(),

        new NotWorkdayLimited10CardDefinition(),
        new NotWorkdayLimited20CardDefinition(),
        new NotWorkdayLimited50CardDefinition(),
        new NotWorkdayLimited100CardDefinition(),

        new NotWorkdayUnlimitedFirstHalfOfDayCardDefinition(),
        new NotWorkdayUnlimitedSecondHalfOfDayCardDefinition(),
        new NotWorkdayUnlimited1DayCardDefinition(),
        new NotWorkdayUnlimited2DaysCardDefinition(),

        new Season2015CardDefinition()
    );

    cardDefinitions.forEach(cardSystem::registerCardType);

    return cardSystem;
  }
}
