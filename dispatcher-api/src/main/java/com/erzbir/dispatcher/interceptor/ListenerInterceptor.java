package com.erzbir.dispatcher.interceptor;

import com.erzbir.dispatcher.event.ListenerContext;

/**
 * @author Erzbir
 * @Data: 2024/2/13 21:27
 */
public interface ListenerInterceptor extends Interceptor<ListenerContext> {
    @Override
    boolean intercept(ListenerContext target);
}
