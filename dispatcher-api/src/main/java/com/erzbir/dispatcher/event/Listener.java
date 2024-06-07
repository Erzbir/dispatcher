package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface Listener<E extends Event> {
    ListenerResult onEvent(E event);
}