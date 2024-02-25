package com.erzbir.dispatcher.event;


import com.erzbir.dispatcher.common.Context;

/**
 * @author Erzbir
 * @Data: 2024/2/7 02:03
 */
public interface ListenerContext extends Context {
    EventContext getEventContext();

    Listener getListener();

    default Event getEvent() {
        return getEventContext().getEvent();
    }
}
