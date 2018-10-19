package io.codex.cryptogram.stringify;

/**
 * 枚举类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class EnumStringify implements Stringify<Enum<?>> {

    public boolean support(Class<?> type) {
        return type.isEnum();
    }

    public String stringify(Enum<?> value, StringifyProvider provider) {
        return value.name();
    }
}
