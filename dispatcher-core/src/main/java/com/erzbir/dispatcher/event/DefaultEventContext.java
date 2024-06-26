package com.erzbir.dispatcher.event;


import com.erzbir.dispatcher.common.Context;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class DefaultEventContext implements EventContext {
    private final Event event;
    private final DefaultContextDelegate contextDelegate = new DefaultContextDelegate();

    public DefaultEventContext(Event event) {
        this.event = event;
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public Context put(Object key, Object value) {
        return contextDelegate.put(key, value);
    }

    @Override
    public Context delete(Object key) {
        return contextDelegate.delete(key);
    }

    @Override
    public <T> T get(Object key) {
        return contextDelegate.get(key);
    }

    @Override
    public boolean hasKey(Object key) {
        return contextDelegate.hasKey(key);
    }

    @Override
    public int size() {
        return contextDelegate.size();
    }

    @Override
    public Stream<Map.Entry<Object, Object>> stream() {
        return contextDelegate.stream();
    }
}
