package com.erzbir.dispatcher.event;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Erzbir
 * @since 1.0.0
 */
@Slf4j
class DefaultEventApplicationTest {

    @Test
    void dispatch() throws InterruptedException {
        PollingEventDispatcher eventDispatcher = new PollingEventDispatcher();
        EventChannel<NameEvent> eventEventChannel = GlobalEventChannel.INSTANCE.filterInstance(NameEvent.class);
        eventDispatcher.start();
        eventEventChannel.subscribe(NameEvent.class, event -> {
            log.info("TestEvent: {}", event.getSource());
            return StandardListenerResult.CONTINUE;
        });
        EventChannel<Event> filter = GlobalEventChannel.INSTANCE.filter(event -> event instanceof TestEvent);
        ListenerHandle subscribe = filter.subscribe(Event.class, event -> {
            if (event instanceof TestEvent) {
                log.info(((TestEvent) event).getName());
            }
            return StandardListenerResult.CONTINUE;
        });
        GlobalEventChannel.INSTANCE.filter(event -> true).subscribe(TestEvent.class, event -> {
            log.info("1234r432");
            return StandardListenerResult.CONTINUE;
        });
        eventDispatcher.dispatch(new TestIntNamedEvent(1), eventEventChannel);
        eventDispatcher.dispatch(new TestStringNamedEvent("nidwoq"), GlobalEventChannel.INSTANCE);
        eventDispatcher.dispatch(new TestStringNamedEvent("assas"), eventEventChannel);
        eventDispatcher.dispatch(new TestIntNamedEvent(32), eventEventChannel);
        eventDispatcher.dispatch(new TestEvent(this), GlobalEventChannel.INSTANCE);
        eventDispatcher.dispatch(new TestEvent(this), filter);

    }


}