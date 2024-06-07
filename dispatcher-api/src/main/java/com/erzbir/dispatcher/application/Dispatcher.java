package com.erzbir.dispatcher.application;


import com.erzbir.dispatcher.event.EventDispatcher;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface Dispatcher {
    DispatcherConfiguration getConfiguration();

    EventDispatcher getEventDispatcher();
}