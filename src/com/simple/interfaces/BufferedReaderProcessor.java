//: com/simple/interfaces/BufferedReaderProcessor.java

package com.simple.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
