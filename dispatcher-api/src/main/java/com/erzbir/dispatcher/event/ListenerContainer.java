package com.erzbir.dispatcher.event;

/**
 * 监听器容器
 *
 * @author Erzbir
 * @Data: 2023/12/6 11:35
 */
public interface ListenerContainer<E extends Event> {
    Iterable<Listener<E>> getListeners();
}
