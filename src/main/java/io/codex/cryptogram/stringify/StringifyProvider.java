package io.codex.cryptogram.stringify;

import io.codex.cryptogram.Algorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 串化提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class StringifyProvider implements Algorithm {
    private final Collection<Stringify> stringifies;
    private final Properties properties;

    public StringifyProvider(Collection<Stringify> stringifies, Properties properties) {
        this.stringifies = stringifies;
        this.properties = properties;
    }

    public String algorithm() {
        return "stringify";
    }

    public String flat(Object value) {
        if (value == null) return null;
        for (Stringify stringify : stringifies)
            if (stringify.support(value.getClass())) return stringify.stringify(value, this);
        throw new IllegalArgumentException("unsupported value type " + value.getClass());
    }

    public String valueOf(String key) {
        return properties.getProperty(key);
    }

    public String valueOf(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
