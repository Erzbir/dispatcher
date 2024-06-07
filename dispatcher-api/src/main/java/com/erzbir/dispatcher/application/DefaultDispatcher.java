package com.erzbir.dispatcher.application;

import com.erzbir.dispatcher.event.EventDispatcher;

import java.util.ServiceLoader;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class DefaultDispatcher implements Dispatcher {
    private final Dispatcher delegate;

    public DefaultDispatcher() {
        delegate = ServiceLoader.load(Dispatcher.class).findFirst().orElseThrow();
    }

    @Override
    public DispatcherConfiguration getConfiguration() {
        return delegate.getConfiguration();
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return delegate.getEventDispatcher();
    }
}
