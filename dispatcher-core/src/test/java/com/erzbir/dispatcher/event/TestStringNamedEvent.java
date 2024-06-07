package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @version 1.0
 * @since 2024/6/7
 */
public class TestStringNamedEvent extends AbstractEvent implements NameEvent{
    public TestStringNamedEvent(String source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String) source;
    }
}
