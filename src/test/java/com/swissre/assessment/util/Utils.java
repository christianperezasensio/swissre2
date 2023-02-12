package com.swissre.assessment.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class Utils {

    public static String readData(String jsonFile) throws IOException {
        try (final InputStream inputstream = Utils.class.getResourceAsStream(jsonFile)) {
            try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requireNonNull(inputstream), UTF_8))) {
                return bufferedReader.lines().collect(joining("\n"));
            }
        }
    }

    public static String readFile(String file) {
        try {
            return readData(file);
        } catch (IOException e) {
            throw new RuntimeException("Error opening file " + file);
        }
    }
}
