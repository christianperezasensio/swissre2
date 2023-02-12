package com.swissre.assessment.util;

import org.junit.jupiter.api.Test;

import static com.swissre.assessment.util.Utils.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilsTest {

    @Test
    void readFileCheck() {
        assertEquals("Test input", readFile("/fileReader-input.txt"));
    }

    @Test
    void readFileThrowsException() {
        assertThrows(RuntimeException.class, () -> readFile("/non-existing-file.txt"));
    }

}
