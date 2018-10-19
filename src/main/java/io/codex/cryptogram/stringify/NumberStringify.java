package io.codex.cryptogram.stringify;

/**
 * 数字类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class NumberStringify implements Stringify<Number> {

    public boolean support(Class<?> type) {
        return Number.class.isAssignableFrom(type);
    }

    public String stringify(Number value, StringifyProvider provider) {
        return value.toString();
    }
}
