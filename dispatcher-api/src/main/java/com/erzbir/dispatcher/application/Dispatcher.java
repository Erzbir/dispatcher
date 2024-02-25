package com.erzbir.dispatcher.application;


import com.erzbir.dispatcher.event.EventDispatcher;

/**
 * @author Erzbir
 * @Data: 2024/2/8 00:41
 */
public interface Dispatcher {
    DispatcherConfiguration getConfiguration();

    EventDispatcher getEventDispatcher();
}