package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class TestStringNamedEvent extends AbstractEvent implements NameEvent {
    public TestStringNamedEvent(String source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String) source;
    }
}
