import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import org.w3c.dom.Document;

public class EscritorXML {
    public Document document;

    public EscritorXML() {
    }

    public void setDocumentXML(Document document) {
        this.document = document;
    }

    public void exportaArquivoXML(String path) {
        try{
            File xml = new File(path);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(xml);
            transformer.transform(domSource, streamResult);
            
            JOptionPane.showMessageDialog(null, 
            "Arquivo exportado com sucesso!");
        }catch (TransformerException e) {
            JOptionPane.showMessageDialog(null, 
            "Nao foi possivel exportar o arquivo!");
        }
    }
}
