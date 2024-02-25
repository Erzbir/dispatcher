# Dispatcher

## 介绍

这是一个事件调度模型实现, 可以为应用程序提供事件机制以及异步的能力

## 使用

### 分发事件

要分发的事件必须实现 `AbstractEvent`

```java
void dispatchTest() {
    Dispatcher dispatcher = new DefaultDispatcher();
    EventDispatcher eventDispatcher = dispatcher.getEventDispatcher();
    eventDispatcher.start();
    eventDispatcher.dispatch(testEvent);
    eventDispatcher.dispatch(testEvent, filteredChannel);
    // eventDispatcher.cancel(); 结束
}
```

### 注册监听

api 模块中开放了一个 `GlobalEventChannel` 类, 可以通过过滤, 将监听注册到相应的 `EventChannel`

```java
void subscribeTest() {
    EventChannel<BotEvent> eventEventChannel = GlobalEventChannel.INSTANCE.filterInstance(TestEvent.class);
    eventEventChannel.subscribe(TestEvent.class, event -> {
        log.info("Event: {}", event);
        return StandardListenerResult.CONTINUE;
    });
}
```

### 关闭一个注册的监听

通过 `ListenerHandle` 控制

```java
void disposeTest() {
    ListenerHandle handle = GlobalEventChannel.INSTANCE.subscribe(Event.class, listener);
    handle.dispose();
}
```

当然 `Listener` 返回 `STOP` 后也会关闭这个监听