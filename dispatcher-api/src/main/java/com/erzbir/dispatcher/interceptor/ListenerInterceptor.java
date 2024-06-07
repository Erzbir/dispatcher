package com.erzbir.dispatcher.interceptor;

import com.erzbir.dispatcher.event.ListenerContext;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface ListenerInterceptor extends Interceptor<ListenerContext> {
    @Override
    boolean intercept(ListenerContext target);
}
