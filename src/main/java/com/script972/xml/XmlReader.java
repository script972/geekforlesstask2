package com.script972.xml;

import com.script972.entity.Receipt;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {

    private String fileName = "res.xml";

    public List<Receipt> readFile() throws IOException, SAXException, ParserConfigurationException {

        org.jdom2.Document jdomDocument = createJDOMusingDOMParser(fileName);
        Element root = jdomDocument.getRootElement();
        List<Element> listReceipt = root.getChildren("person");

        List<Receipt> students = new ArrayList<Receipt>();
        for (Element receiptEl : listReceipt) {
            Receipt receipt = new Receipt();
            receipt.setName(receiptEl.getChildText("name"));
            receipt.setTown(receiptEl.getChildText("town"));
            receipt.setPassportSer(receiptEl.getChildText("passportSer"));;
            receipt.setNumber(Integer.parseInt(receiptEl.getChildText("number")));
            receipt.setTake(receiptEl.getChildText("take"));
            receipt.setHome(receiptEl.getChildText("home"));
            receipt.setLandlord(receiptEl.getChildText("landlord"));
            receipt.setSumm(receiptEl.getChildText("sum"));
            receipt.setDateEpire(receiptEl.getChildText("dateExpire"));
            students.add(receipt);
        }

        for (Receipt student : students) {
            System.out.println(student.toString());
        }
        return students;
    }



    private org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }

}
