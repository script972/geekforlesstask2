package com.script972;

import com.script972.dao.ReceiptDAO;
import com.script972.xml.XmlReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Manipulate {
    public void task() throws ParserConfigurationException, SAXException, IOException {
        XmlReader xmlReader=new XmlReader();
        ReceiptDAO receiptDAO=new ReceiptDAO();
        receiptDAO.insertAll(xmlReader.readFile());
    }
}
