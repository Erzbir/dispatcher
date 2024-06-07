package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface Disposable {
    void dispose();

    boolean isDisposed();
}
