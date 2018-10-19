package io.codex.cryptogram.stringify;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型的串化器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class DateStringify implements Stringify<Date> {
    public final static String KEY_DATE_PATTERN = "datePattern";

    public boolean support(Class<?> type) {
        return Date.class.isAssignableFrom(type);
    }

    public String stringify(Date value, StringifyProvider provider) {
        String pattern = provider.valueOf(KEY_DATE_PATTERN, "yyyy-MM-dd HH:mm:ss");
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(value);
    }
}
