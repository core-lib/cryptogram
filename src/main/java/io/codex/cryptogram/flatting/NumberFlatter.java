package io.codex.cryptogram.flatting;

/**
 * 数字类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class NumberFlatter implements Flatter<Number> {

    public boolean support(Class<?> type) {
        return Number.class.isAssignableFrom(type);
    }

    public String flat(Number value, FlattingProvider provider) {
        return value.toString();
    }
}
