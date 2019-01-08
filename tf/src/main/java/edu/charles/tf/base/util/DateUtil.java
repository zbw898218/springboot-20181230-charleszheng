package edu.charles.tf.base.util;

import java.util.Date;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {

    public static long getTimeToCurrent(Date date) {
        long time = date.getTime();
        long current = System.currentTimeMillis();
        return current - time;
    }
}
