package com.ccl.rain.codegen;

/**
 * @author ccl
 * @date 2017/8/27.
 */
public interface LogStorageService {
    /**
     * 保存日誌
     *
     * @param logMetadata
     */
    void saveLog(LogMetadata logMetadata);
}
