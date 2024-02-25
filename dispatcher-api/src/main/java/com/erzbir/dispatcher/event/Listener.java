package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 */
public interface Listener<E extends Event> {
    ListenerResult onEvent(E event);
}