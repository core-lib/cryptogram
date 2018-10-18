package io.codex.cryptogram.flatting;

import java.util.Arrays;
import java.util.Properties;

/**
 * 缺省的摊平
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class DefaultFlattingProvider extends FlattingProvider {

    public DefaultFlattingProvider() {
        super(Arrays.<Flatter>asList(
                new SimpleFlatter(),
                new NumberFlatter(),
                new StringFlatter(),
                new DateFlatter(),
                new EnumFlatter(),
                new ArrayFlatter(),
                new CollectionFlatter(),
                new MapFlatter(),
                new ObjectFlatter()
        ), new Properties());
    }

}
