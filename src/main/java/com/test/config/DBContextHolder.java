package com.test.config;

public class DBContextHolder {

    /**
     * 动态数据源key holder
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static final String DB_TYPE_PRIMARY = "dataSourceKeyPrimary";
    public static final String DB_TYPE_SECONDARY = "dataSourceKeySecondary";

    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            db = DB_TYPE_PRIMARY;// 默认是主库
        }
        return db;
    }

    /**
     * 设置本线程的dbtype
     */
    public static void setDbType(String str) {
        contextHolder.set(str);
    }

    /**
     * 清理连接类型
     */
    public static void clearDBType() {
        contextHolder.remove();
    }
}