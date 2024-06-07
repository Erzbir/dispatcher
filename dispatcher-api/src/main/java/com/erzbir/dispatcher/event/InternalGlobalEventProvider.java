package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @since 1.0.0
 */
interface InternalGlobalEventProvider {
    EventChannel<Event> getInstance();
}
