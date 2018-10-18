package io.codex.cryptogram.flatting;

/**
 * 枚举类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class EnumFlatter implements Flatter<Enum<?>> {

    public boolean support(Class<?> type) {
        return type.isEnum();
    }

    public String flat(Enum<?> value, FlattingProvider provider) {
        return value.name();
    }
}
