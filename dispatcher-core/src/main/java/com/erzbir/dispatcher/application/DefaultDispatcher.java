package com.erzbir.dispatcher.application;


import com.erzbir.dispatcher.event.EventDispatcher;
import com.erzbir.dispatcher.event.NotificationEventDispatcher;
import com.erzbir.dispatcher.event.PollingEventDispatcher;

/**
 * @author Erzbir
 * @Data: 2024/2/8 01:26
 */
public class DefaultDispatcher implements Dispatcher {
    private final DispatcherConfiguration config = new DefaultDispatcherConfiguration();
    private EventDispatcher eventDispatcher;

    @Override
    public DispatcherConfiguration getConfiguration() {
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
