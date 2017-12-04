package com.script972;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Для запуска введите любой текст и нажмите <Enter>");
        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
        Manipulate manipulate = new Manipulate();
        try {
            manipulate.task();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
