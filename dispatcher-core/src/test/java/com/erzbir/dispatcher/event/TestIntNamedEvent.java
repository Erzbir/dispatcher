package com.erzbir.dispatcher.event;

/**
 * @author Erzbir
 * @version 1.0
 * @since 2024/6/7
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
