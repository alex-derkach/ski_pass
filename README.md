## Proposed solution for JavaDay Kyiv student programming contest
[![Build Status](https://travis-ci.org/alex-derkach/ski_pass.svg?branch=master)](https://travis-ci.org/alex-derkach/ski_pass)
[![Coverage Status](https://coveralls.io/repos/alex-derkach/ski_pass/badge.svg?branch=master&service=github)](https://coveralls.io/github/alex-derkach/ski_pass?branch=master)

[Task description](http://jug.ua/materials/javaday-kyiv-student-programming-contest/)

To run on Unix, execute in terminal:
```bash
mvn package \
&& java -cp "client/target/client-1.0.jar:client/target/dependency/*" io.ski.Main
```

## Description

To enable creation of specific type of card, you need to register required lifecycle objects, by providing an instance of [CardDefinition](#carddefinition) to [CardSystem.registerCardType()](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/CardSystem.java#L46) method.

### CardDefinition
It is an interface used to provide lifecycle objects, related to specific type of pass card. Methods:
* `String getDiscriminator()` - returns the unique type identifier for card
* `CardFactory<T> getCardFactory()` - returns [Factory](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/CardFactory.java), which will be used by system to create cards of this type
* `Validator<T> getValidator()` - returns [Validator](#validator) instance
* `Handler<T> getHandler()` - returns [Handler](#handler) instance

Simple example can be found [here](https://github.com/alex-derkach/ski_pass/blob/master/client/src/main/java/io/ski/cards/Season2015CardDefinition.java).

#### Validator
Instances of this [type](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/Validator.java), created in [CardDefinition](#carddefinition), are used by system to validate cards before handling, during pass (e.g. used for checking block status). Core implementors are:
* [BlockedValidator](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/validator/BlockedValidator.java) - checks blockage status of card
* [LimitedValidator](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/validator/LimitedValidator.java) - checks trip counter of card
* [NotWorkdayValidator](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/validator/NotWorkdayValidator.java) - checks if card is used on a day, other than workday
* [WorkdayValidator](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/validator/WorkdayValidator.java) - checks if card is used on a day, specifically workday
* [TimeRangeValidator](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/validator/TimeRangeValidator.java) - checks if card is used in permitted time period

#### Handler
Instances of this [type](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/card/Handler.java), created in [CardDefinition](#carddefinition), are used by system to handle card after validation, during pass (e.g. used for decrementing counter in limited cards).


### View
Obtained by [CardSystem.createEventQueryView()](https://github.com/alex-derkach/ski_pass/blob/master/core/src/main/java/io/ski/CardSystem.java#L42), is used for quering events in the system. Example usage is stated in [main method](https://github.com/alex-derkach/ski_pass/blob/master/client/src/main/java/io/ski/Main.java#L18).
