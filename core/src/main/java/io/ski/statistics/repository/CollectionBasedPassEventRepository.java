package io.ski.statistics.repository;

import io.ski.statistics.domain.PassEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionBasedPassEventRepository implements PassEventRepository {

  private final Collection<PassEvent> passEvents;

  public CollectionBasedPassEventRepository() {
    passEvents = new ArrayList<>();
  }

  @Override
  public void persist(PassEvent passEvent) {
    passEvents.add(passEvent);
  }

  @Override
  public Collection<PassEvent> findAll() {
    return Collections.unmodifiableCollection(passEvents);
  }
}
