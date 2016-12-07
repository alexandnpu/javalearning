package com.logbackLearning;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhengchao on 2016/11/8.
 */
public class AlexGzipEncoder extends PatternLayoutEncoder {

    private GZIPOutputStream gzipOutputStream;
    private int counter = 0;
    private static int MAX_COUNT = 500;

    @Override
    public void init(OutputStream os) throws IOException {
        super.init(os);
        this.gzipOutputStream = new GZIPOutputStream(outputStream);
    }

    @Override
    public void doEncode(ILoggingEvent event) throws IOException {
        String txt = layout.doLayout(event);
        byte[] bytes = convertToBytes(txt);
        gzipOutputStream.write(bytes);
        this.counter += bytes.length;
        if (this.counter > MAX_COUNT) {
            gzipOutputStream.finish();
            gzipOutputStream.flush();
            gzipOutputStream = new GZIPOutputStream(outputStream);
            this.counter = 0;
        }
    }

    private byte[] convertToBytes(String s) {
        if (super.getCharset() == null) {
            return s.getBytes();
        } else {
            try {
                return s.getBytes(super.getCharset().name());
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException("An existing charset cannot possibly be unsupported.");
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        try {
            this.gzipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeOutputStream() {
        if (this.gzipOutputStream == null) {
            return;
        }
        try {
            this.gzipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}