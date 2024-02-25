package com.erzbir.dispatcher.event;

import com.erzbir.dispatcher.common.Context;

/**
 * @author Erzbir
 * @Data: 2024/2/3 11:42
 */
public interface EventContext extends Context {
    Event getEvent();
}
