package org.example.ch02.domain.service;

import org.example.ch02.domain.vo.ParsePolicyType;
import org.example.ch02.domain.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventSearch {

    public List<Event> retrieveEvents(List<String> unparsedEvents, ParsePolicyType policyType) {
        var parsedEvents = new ArrayList<Event>();
        unparsedEvents.stream()
                .forEach(event -> {
                    parsedEvents.add(Event.parsedEvent(event, policyType));
                });

        return parsedEvents;
    }
}
