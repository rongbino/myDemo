package trong.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import scala.xml.XML;

public class Dom4jTest {
  public static void main(String[] args) {
    Document doc = DocumentHelper.createDocument();
    doc.setXMLEncoding("GB2312");
    Element root = doc.addElement("root");
    root.addAttribute("name", "name_value");
    Element el = root.addElement("element");
    el.addElement("name2");


    XMLWriter writer = new XMLWriter();
    String header = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\" ?>";
    String xml = header + doc.getRootElement().asXML();
    System.out.println(xml);
  }
}
