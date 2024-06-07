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
    private EventDispatcher eventDispatcher = new PollingEventDispatcher();

    @Override
    public Configuration getConfiguration() {
        return config;
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        if (eventDispatcher == null) {
            switch (config.getMode()) {
                case POLL -> {
                    if (!(eventDispatcher instanceof PollingEventDispatcher)) {
                        eventDispatcher = new PollingEventDispatcher();
                    }
                }
                case NOTIFY -> {
                    if (!(eventDispatcher instanceof NotificationEventDispatcher)) {
                        eventDispatcher = new NotificationEventDispatcher();
                    }
                }
            }
        }
        return eventDispatcher;
    }
}
