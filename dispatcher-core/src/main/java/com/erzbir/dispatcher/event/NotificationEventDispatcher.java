package com.erzbir.dispatcher.event;

import lombok.extern.slf4j.Slf4j;

/**
 * 基于通知的 {@link EventDispatcher}
 *
 * @author Erzbir
 * @since 1.0.0
 */
@Slf4j
public class NotificationEventDispatcher extends AbstractEventDispatcher implements EventDispatcher {

    @Override
    protected <E extends Event> void dispatchTo(E event, EventChannel<E> channel) {
        Thread.ofVirtual()
                .name("Dispatcher-Thread")
                .start(createTask(channel, event));
    }

    private <E extends Event> Runnable createTask(EventChannel<E> channel, E event) {
        return () -> {
            try {
                if (event instanceof CancelableEvent cancelableEvent) {
                    if (cancelableEvent.isCanceled()) {
                        return;
                    }
                }
                log.debug("Dispatching event: {} to channel: {}", event, channel.getClass().getSimpleName());
                channel.broadcast(new DefaultEventContext(event));
            } catch (Throwable e) {
                log.error("Dispatching to channel: {} error: {}", channel.getClass().getSimpleName(), e.getMessage());
                Thread.currentThread().interrupt();
            }
        };
    }
}
