package com.erzbir.dispatcher.event;

import java.util.ServiceLoader;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class GlobalEventChannel extends EventChannel<Event> {
    public static GlobalEventChannel INSTANCE = new GlobalEventChannel(Event.class);
    private final EventChannel<Event> delegate;

    private GlobalEventChannel(Class<Event> baseEventClass) {
        super(baseEventClass);
        delegate = ServiceLoader.load(InternalGlobalEventProvider.class)
                .findFirst()
                .orElseThrow()
                .getInstance();
    }

    @Override
    protected void broadcast(EventContext event) {
        delegate.broadcast(event);
    }

    @Override
    protected ListenerHandle registerListener(Class<Event> eventType, Listener<Event> listener) {
        return delegate.registerListener(eventType, listener);
    }

    @Override
    public <T extends Event> ListenerHandle subscribe(Class<T> eventType, Function<T, ListenerResult> handle) {
        return delegate.subscribe(eventType, handle);
    }

    @Override
    public <T extends Event> ListenerHandle subscribeOnce(Class<T> eventType, Consumer<T> handle) {
        return delegate.subscribeOnce(eventType, handle);
    }

    @Override
    public <T extends Event> ListenerHandle subscribeAlways(Class<T> eventType, Consumer<T> handle) {
        return delegate.subscribeAlways(eventType, handle);
    }

    @Override
    public Listener<Event> createListener(Function<Event, ListenerResult> handle) {
        return delegate.createListener(handle);
    }

    @Override
    public EventChannel<Event> filter(Predicate<Event> predicate) {
        return delegate.filter(predicate);
    }

    @Override
    public <T extends Event> EventChannel<T> filterInstance(Class<T> eventType) {
        return delegate.filterInstance(eventType);
    }

    @Override
    public Iterable<Listener<Event>> getListeners() {
        return delegate.getListeners();
    }

//    @Override
//    public <T extends Event> ListenerHandle register(Class<T> eventType, Listener<T> listener) {
//        return delegate.register(eventType, listener);
//    }
}


