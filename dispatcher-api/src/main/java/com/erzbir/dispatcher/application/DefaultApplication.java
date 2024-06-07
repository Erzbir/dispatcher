package com.erzbir.dispatcher.application;

import com.erzbir.dispatcher.event.EventDispatcher;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class DefaultApplication implements Application {
    public static Application INSTANCE = new DefaultApplication();
    private final Application delegate;

    public DefaultApplication() {
        delegate = ServiceLoader.load(Application.class).findFirst().orElseThrow();
    }

    @Override
    public Configuration getConfiguration() {
        return delegate.getConfiguration();
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return delegate.getEventDispatcher();
    }
}
