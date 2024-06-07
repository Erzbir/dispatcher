package com.erzbir.dispatcher.interceptor;

import com.erzbir.dispatcher.event.EventContext;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface DispatchInterceptor extends Interceptor<EventContext> {
    @Override
    boolean intercept(EventContext target);
}
