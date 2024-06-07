package com.erzbir.dispatcher.event;


/**
 * @author Erzbir
 * @since 1.0.0
 */
public class GlobalEventChannelProviderImpl implements InternalGlobalEventProvider {
    @Override
    public EventChannel<Event> getInstance() {
        return EventChannelDispatcher.INSTANCE;
    }
}
