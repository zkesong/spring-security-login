package com.zks.spring.security.login.components.db;

/**
 * Created by Kesong Zeng on 2018/8/20.
 */
public class DbContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置当前数据库。
     * @param dbType
     */
    public static void setDbType(String dbType)
    {
        CONTEXT_HOLDER.set(dbType);
    }

    /**
     * 取得当前数据源。
     * @return
     */
    public static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType()
    {
        CONTEXT_HOLDER.remove();
    }
}
