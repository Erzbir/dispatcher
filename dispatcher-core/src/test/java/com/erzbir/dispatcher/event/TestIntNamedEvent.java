package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public class TestIntNamedEvent extends AbstractEvent implements NameEvent {
    public TestIntNamedEvent(Integer source) {
        super(source);
    }

    @Override
    public Integer getSource() {
        return (Integer) source;
    }
}
