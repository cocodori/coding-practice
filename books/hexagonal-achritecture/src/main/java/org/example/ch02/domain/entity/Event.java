package org.example.ch02.domain.entity;

import org.example.ch02.domain.policy.RegexEventParser;
import org.example.ch02.domain.policy.SplitEventParser;
import org.example.ch02.domain.vo.Activity;
import org.example.ch02.domain.vo.EventId;
import org.example.ch02.domain.vo.ParsePolicyType;
import org.example.ch02.domain.vo.Protocol;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private OffsetDateTime timestamp;
    private EventId id;
    private Protocol protocol;
    private Activity activity;

    public Event(OffsetDateTime timestamp, EventId id, Protocol protocol, Activity activity) {
        this.timestamp = timestamp;
        this.id = id;
        this.protocol = protocol;
        this.activity = activity;
    }

    public static Event parsedEvent(String unparsedEvent, ParsePolicyType policy) {
        switch (policy) {
            case REGEX:
                return new RegexEventParser().parseEvent(unparsedEvent);
            case SPLIT:
                return new SplitEventParser().parseEvent(unparsedEvent);
            default:
                throw new IllegalArgumentException(unparsedEvent);
        }
    }

    @Override
    public int compareTo(Event event) {
        return timestamp.compareTo(event.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Event) {
            Event event = (Event) o;
            return (event.timestamp.equals(this.timestamp)
                    && event.id.equals(this.id)
                    && event.protocol.equals(this.protocol)
                    && event.activity.equals(this.activity)
            );
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, id, protocol, activity) + 31;
    }
}
