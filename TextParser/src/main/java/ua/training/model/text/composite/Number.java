package ua.training.model.text.composite;

import ua.training.model.text.basic.Digit;
import ua.training.model.text.IComponent;
import ua.training.model.text.basic.PunctuationMark;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number extends AbstractCompositeElement {

    private String digitExp = "\\d";
    private String punctuationExp = "\\.";
    private String regExp = digitExp + "|" + punctuationExp;

    public Number(String number) {
        super(number);
    }

    @Override
    public void parse() {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            String element = matcher.group();
            if (element.matches(digitExp)) {
                addDigit(element);
            } else if (element.matches(punctuationExp)) {
                addPunctuationMark(element);
            }
        }
        for (IComponent component : components) {
//            System.out.println("\t\t" + component);
            component.parse();
        }
    }

    private void addDigit(String letter) {
        components.add(new Digit(letter));
    }

    private void addPunctuationMark(String mark) {
        components.add(new PunctuationMark(mark));
    }
}