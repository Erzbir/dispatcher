package com.erzbir.dispatcher.interceptor;

import com.erzbir.dispatcher.event.EventContext;

/**
 * @author Erzbir
 * @Data: 2024/2/7 18:46
 */
public interface EventDispatchInterceptor extends Interceptor<EventContext> {
    @Override
    boolean intercept(EventContext target);
}
