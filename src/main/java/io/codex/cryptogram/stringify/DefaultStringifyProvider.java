package io.codex.cryptogram.stringify;

import java.util.Arrays;
import java.util.Properties;

/**
 * 缺省的串化提供器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class DefaultStringifyProvider extends StringifyProvider {

    public DefaultStringifyProvider() {
        super(Arrays.<Stringify>asList(
                new SimpleStringify(),
                new NumberStringify(),
                new StringStringify(),
                new DateStringify(),
                new EnumStringify(),
                new ArrayStringify(),
                new CollectionStringify(),
                new MapStringify(),
                new ObjectStringify()
        ), new Properties());
    }

}
