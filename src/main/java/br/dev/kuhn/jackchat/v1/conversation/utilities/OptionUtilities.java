package br.dev.kuhn.jackchat.v1.conversation.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionUtilities {
    public static Map<String, String> createOption(String title, String value) {
        Map<String, String> option = new HashMap<>();

        option.put("title", title);
        option.put("value", value);

        return option;
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, String>> createOptions(Map<String, String>... options) {
        return new ArrayList<>(Arrays.asList(options));
    }
}
