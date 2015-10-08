package io.ski.statistics;

import io.ski.statistics.domain.PassEvent;
import io.ski.statistics.domain.PassStatus;
import io.ski.statistics.repository.PassEventRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class View {
  private Stream<PassEvent> events;

  public View(PassEventRepository passEventRepository) {
    this.events = passEventRepository.findAll().stream();
  }

  public View filterByStatus(PassStatus passStatus) {
    events = events.filter(e -> e.getPassStatus().equals(passStatus));
    return this;
  }

  public View filterStrictByRange(LocalDateTime startPoint, LocalDateTime endPoint) {
    events = events.filter(e -> e.getCreatedAt().isAfter(startPoint) && e.getCreatedAt().isBefore(endPoint));
    return this;
  }

  public Map<String, List<PassEvent>> groupByCardType() {
    return events.collect(Collectors.groupingBy(e -> e.getCard().getDiscriminator()));
  }

  public long count() {
    return events.count();
  }

  public Collection<PassEvent> collect() {
    return events.collect(Collectors.toList());
  }
}
