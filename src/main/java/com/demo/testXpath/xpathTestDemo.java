package com.demo.testXpath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class xpathTestDemo {

    public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        /**
         * 获取NodeList
         */
        File file = new File("src/main/resources/xmldemo.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder;
        dbuilder = dbfactory.newDocumentBuilder();
        Document document = dbuilder.parse(file);
        document.getDocumentElement().normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expresion = "/class/student";
        NodeList nodeList = (NodeList)xPath.compile(expresion).evaluate(document, XPathConstants.NODESET);

        for(int i=0; i < nodeList.getLength() ; i++){
            Node nNode = nodeList.item(i);

            System.out.println("当前元素：" + nNode.getNodeName());
            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)nNode;
                System.out.println("Student roll no:" + element.getAttribute("rollno"));

                System.out.println("firstname: " + element.getElementsByTagName("firstName").item(0).getTextContent());
            }
        }

    }
}


