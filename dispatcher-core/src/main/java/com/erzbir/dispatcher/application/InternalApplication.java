package com.erzbir.dispatcher.application;


import com.erzbir.dispatcher.event.EventDispatcher;
import com.erzbir.dispatcher.event.NotificationEventDispatcher;
import com.erzbir.dispatcher.event.PollingEventDispatcher;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class InternalApplication implements Application {
    private final Configuration config = new DefaultConfiguration();
    private EventDispatcher eventDispatcher;

    @Override
    public Configuration getConfiguration() {
        return config;
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        if (eventDispatcher == null) {
            eventDispatcher = switch (config.getMode()) {
                case POLL -> new PollingEventDispatcher();
                case NOTIFY -> new NotificationEventDispatcher();
            };
        }
        return eventDispatcher;
    }
}
