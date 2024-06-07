package com.erzbir.dispatcher.event;

import com.erzbir.dispatcher.interceptor.Interceptor;
import com.erzbir.dispatcher.interceptor.ListenerInterceptor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2024/2/7 02:46
 */
public sealed interface ListenerInvoker {
    ListenerResult invoke(ListenerContext listenerContext);
}

@Slf4j
final class BaseListenerInvoker implements ListenerInvoker {

    @SuppressWarnings("unchecked")
    @Override
    public ListenerResult invoke(ListenerContext listenerContext) {
        Event event = listenerContext.getEvent();
        return listenerContext.getListener().onEvent(event);
    }
}

@Slf4j
final class InterceptorInvoker implements ListenerInvoker {
    private ListenerInvoker listenerInvoker;
    private List<Interceptor<ListenerContext>> listenerInterceptors;
    private InterceptProcessor interceptProcessor;

    public InterceptorInvoker(List<Interceptor<ListenerContext>> listenerInterceptors) {
        this.listenerInvoker = new BaseListenerInvoker();
        this.listenerInterceptors = listenerInterceptors;
        this.interceptProcessor = new DefaultInterceptProcessor();
    }

    @Override
    public ListenerResult invoke(ListenerContext listenerContext) {
        if (!intercept(listenerContext)) {
            return StandardListenerResult.TRUNCATED;
        }
        return listenerInvoker.invoke(listenerContext);
    }


    private boolean intercept(ListenerContext listenerContext) {
        return interceptProcessor.intercept(listenerContext, listenerInterceptors);
    }

}