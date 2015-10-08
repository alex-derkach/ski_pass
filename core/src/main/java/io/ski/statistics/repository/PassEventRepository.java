package io.ski.statistics.repository;

import io.ski.statistics.domain.PassEvent;

import java.util.Collection;

public interface PassEventRepository {
  void persist(PassEvent passEvent);
  Collection<PassEvent> findAll();
}
