package com.erzbir.dispatcher.application;

/**
 * @author Erzbir
 * @Data: 2024/2/8 00:38
 */
public interface DispatcherConfiguration {

    Mode getMode();

    void setMode(Mode mode);

    enum Mode {
        POLL,
        NOTIFY
    }
}
