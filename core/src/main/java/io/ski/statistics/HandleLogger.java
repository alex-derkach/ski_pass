package io.ski.statistics;

import io.ski.card.Card;
import io.ski.card.event.PostHandleListener;
import io.ski.statistics.domain.AuthorizedPassEvent;
import io.ski.statistics.repository.PassEventRepository;

import java.time.LocalDateTime;

public class HandleLogger implements PostHandleListener {

  private final PassEventRepository passEventRepository;

  public HandleLogger(PassEventRepository passEventRepository) {
    this.passEventRepository = passEventRepository;
  }

  @Override
  public void postHandle(Card card) {
    LocalDateTime now = LocalDateTime.now();
    AuthorizedPassEvent event = new AuthorizedPassEvent(now, card);
    passEventRepository.persist(event);
  }
}
