package com.llqlv.algotasks.third.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringParserImpl implements StringParser {

    private Map<String, Map<String, Double>> types = new HashMap<>();

    private List<String> answers = new ArrayList<>();

    @Override
    public void dataParser(String toParse) {
        var strings = toParse.split("\\s");
        var firstType = strings[1];
        var secondType = strings[4];
        var firstValue = Double.parseDouble(strings[3]) / Double.parseDouble(strings[0]);
        var secondValue = 1 / firstValue;

        types.computeIfAbsent(firstType, val -> new HashMap<>()).put(secondType, firstValue);
        types.computeIfAbsent(secondType, val -> new HashMap<>()).put(firstType, secondValue);

        mixedTypes(firstType, secondType, secondValue);
        mixedTypes(secondType, firstType, firstValue);
    }

    private void mixedTypes(String typeFromAdd, String typeToAdd, double toAddValue) {
        var innerSecondMap = types.get(typeToAdd);
        for (Map.Entry<String, Double> entry : types.get(typeFromAdd).entrySet()) {
            innerSecondMap.put(entry.getKey(), entry.getValue() * toAddValue);
        }
    }

    @Override
    public void questionParser(String toParse) {
        var strings = toParse.split("\\s");

        if (types.containsKey(strings[1]) && types.get(strings[1]).containsKey(strings[4])) {
            var num = types.get(strings[1]).get(strings[4]);
            answers.add(toParse.replace("?", String.valueOf(Double.parseDouble(strings[0]) * num)));
        } else if (types.containsKey(strings[4]) && types.get(strings[4]).containsKey(strings[1])) {
            var num = types.get(strings[4]).get(strings[1]);
            answers.add(toParse.replace("?", String.valueOf(Double.parseDouble(strings[0]) / num)));
        } else {
            answers.add("Conversion not possible.");
        }
    }

    public void printAnswers() {
        answers.forEach(System.out::println);
    }

    public Map<String, Map<String, Double>> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Map<String, Double>> types) {
        this.types = types;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
