package io.codex.cryptogram.flatting;

import io.codex.cryptogram.Algorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 摊平上下文
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class FlattingProvider implements Algorithm {
    private final Collection<Flatter> flatters;
    private final Properties properties;

    public FlattingProvider(Collection<Flatter> flatters, Properties properties) {
        this.flatters = flatters;
        this.properties = properties;
    }

    public String algorithm() {
        return "flatting";
    }

    public String flat(Object value) {
        if (value == null) return null;
        for (Flatter flatter : flatters) if (flatter.support(value.getClass())) return flatter.flat(value, this);
        throw new IllegalArgumentException("unsupported value type " + value.getClass());
    }

    public String valueOf(String key) {
        return properties.getProperty(key);
    }

    public String valueOf(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
