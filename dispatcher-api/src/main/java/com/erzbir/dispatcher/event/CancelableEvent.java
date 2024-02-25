package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @Data: 2023/12/6 13:56
 */
public interface CancelableEvent extends Cancelable {
    boolean isCanceled();

    // must be safe
    void cancel();
}
