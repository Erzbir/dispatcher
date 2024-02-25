package com.erzbir.dispatcher.application;

/**
 * @author Erzbir
 * @Data: 2024/2/8 01:28
 */
public class DefaultDispatcherConfiguration implements DispatcherConfiguration {
    private Mode mode = Mode.NOTIFY;

    @Override
    public Mode getMode() {
        return mode;
    }

    @Override
    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
