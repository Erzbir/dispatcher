package com.erzbir.dispatcher.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Erzbir
 * @since 1.0.0
 */
public interface Context extends View {
    static Context empty() {
        return ContextEmpty.INSTANCE;
    }

    Context put(Object key, Object value);

    default View readOnly() {
        return this;
    }

    default Context putNonNull(Object key, Object value) {
        if (value != null) {
            return put(key, value);
        }
        return this;
    }

    Context delete(Object key);
}

class ContextEmpty implements Context {
    static final ContextEmpty INSTANCE = new ContextEmpty();

    @Override
    public Context put(Object key, Object value) {
        return this;
    }

    @Override
    public Context delete(Object key) {
        return this;
    }

    @Override
    public <T> T get(Object key) {
        throw new NoSuchElementException("Context is empty");
    }

    @Override
    public boolean hasKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Stream<Map.Entry<Object, Object>> stream() {
        return Stream.empty();
    }
}

@SuppressWarnings("unchecked")
class MapContext extends LinkedHashMap<Object, Object> implements Context {

    MapContext(Object key, Object value) {
        super(6, 1f);
        put(key, value);
    }

    MapContext(Map<Object, Object> originalToCopy) {
        super(Objects.requireNonNull(originalToCopy));
    }

    MapContext(int initialCapacity) {
        super(initialCapacity, 1.0f);
    }

    @Override
    public Context put(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public Context delete(Object key) {
        Objects.requireNonNull(key, "key");
        if (!hasKey(key)) {
            return this;
        }
        MapContext contextN = (MapContext) this.clone();
        contextN.remove(key);
        return contextN;
    }

    @Override
    public boolean hasKey(Object key) {
        return super.containsKey(key);
    }

    @Override
    public Object get(Object key) {
        Object o = super.get(key);
        if (o != null) {
            return o;
        }
        throw new NoSuchElementException("Context does not contain key: " + key);
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        Object o = super.get(key);
        if (o != null) {
            return o;
        }
        return defaultValue;
    }

    @Override
    public Stream<Map.Entry<Object, Object>> stream() {
        return entrySet().stream().map(SimpleImmutableEntry::new);
    }
}