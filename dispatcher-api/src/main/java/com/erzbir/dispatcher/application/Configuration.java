package com.erzbir.dispatcher.application;

import com.erzbir.dispatcher.event.ListenerInvoker;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface Configuration {
    ListenerInvoker getInvoker();

    void setInvoker(ListenerInvoker invoker);

    Mode getMode();

    void setMode(Mode mode);

    enum Mode {
        POLL,
        NOTIFY
    }
}
