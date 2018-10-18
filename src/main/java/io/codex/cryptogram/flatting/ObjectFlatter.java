package io.codex.cryptogram.flatting;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义对象类型摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class ObjectFlatter implements Flatter<Object> {

    public boolean support(Class<?> type) {
        return true;
    }

    public String flat(Object value, FlattingProvider provider) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            PropertyDescriptor[] properties = Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor property : properties) {
                String name = property.getName();
                if ("class".equals(name)) continue;
                Method method = property.getReadMethod();
                Object val = method.invoke(value);
                map.put(name, val);
            }
            return provider.flat(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
