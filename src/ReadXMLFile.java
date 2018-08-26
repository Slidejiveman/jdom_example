import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/** Opens and XML file and displays its contents.
 * this is an example of what JDOM2 does.
 * URL: https://www.mkyong.com/java/how-to-read-xml-file-in-java-jdom-example/ **/
public class ReadXMLFile {
    public static void main(String[] args) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("C:\\Users\\rdnot\\OneDrive\\Work\\2018_BG&O_Learning\\jacorb\\jdom_example\\src\\company.xml");

        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("staff");

            for (int i = 0; i < list.size(); i++) {
                Element node = (Element) list.get(i);

                System.out.println("First Name : " + node.getChildText("firstname"));
                System.out.println("Last Name : " + node.getChildText("lastname"));
                System.out.println("Nickname : " + node.getChildText("nickname"));
                System.out.println("Salary : " + node.getChildText("salary"));
            }
        } catch (IOException ioEx) {
            System.err.println(ioEx.getMessage());
        } catch (JDOMException jEx) {
            System.err.println(jEx.getMessage());
        }
    }
}
