package com.erzbir.dispatcher.event;

import com.erzbir.dispatcher.interceptor.Interceptor;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface ListenerInvoker {
    ListenerResult invoke(ListenerContext listenerContext);

    void addInterceptor(Interceptor<ListenerContext> interceptor);
}