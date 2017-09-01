package com.ccl.rain.codegen;

/**
 * 帶版本號的實例，用於乐观锁的實現
 *
 * @author ccl
 * @date 2017/8/27.
 */
public interface VersionOfEntity {
    /**
     * 版本
     *
     * @return
     */
    Long getVersion();

    /**
     * 設置版本號
     * @param version
     */
    void setVersion(Long version);
}
