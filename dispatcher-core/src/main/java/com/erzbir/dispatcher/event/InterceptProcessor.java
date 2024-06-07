package com.erzbir.dispatcher.event;

import com.erzbir.dispatcher.interceptor.Interceptor;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2024/3/12 14:15
 */
public interface InterceptProcessor {
    <E> boolean intercept(E target, List<Interceptor<E>> interceptors);
}

class DefaultInterceptProcessor implements InterceptProcessor {
    public <E> boolean intercept(E target, List<Interceptor<E>> interceptors) {
        boolean flag = true;
        for (Interceptor<E> interceptor : interceptors) {
            flag = interceptor.intercept(target);
        }
        return flag;
    }
}