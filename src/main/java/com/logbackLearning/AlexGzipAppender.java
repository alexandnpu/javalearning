package com.logbackLearning;

import ch.qos.logback.core.rolling.RollingFileAppender;

/**
 * Created by zhengchao on 2016/11/9.
 */
public class AlexGzipAppender extends RollingFileAppender {

    protected void closeOutputStream() {
        AlexGzipEncoder encoder = (AlexGzipEncoder) this.encoder;
        encoder.closeOutputStream();

        super.closeOutputStream();
    }
}
