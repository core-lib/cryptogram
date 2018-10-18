package io.codex.cryptogram.flatting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型的摊平器
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/17
 */
public class DateFlatter implements Flatter<Date> {
    public final static String KEY_DATE_PATTERN = "datePattern";

    public boolean support(Class<?> type) {
        return Date.class.isAssignableFrom(type);
    }

    public String flat(Date value, FlattingProvider provider) {
        String pattern = provider.valueOf(KEY_DATE_PATTERN, "yyyy-MM-dd HH:mm:ss");
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(value);
    }
}
