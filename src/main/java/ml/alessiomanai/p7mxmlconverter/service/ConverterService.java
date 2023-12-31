package ml.alessiomanai.p7mxmlconverter.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ConverterService {

    public void convertP7m(String inputFile, String tempFile) throws CMSException, IOException  {

        InputStream is = getFileFromResourceAsStream(inputFile);

        CMSSignedData cms = new CMSSignedData(is); 

        FileOutputStream fos = new FileOutputStream(tempFile);

        cms.getSignedContent().write(fos);

        log.info("Corventing file " + inputFile + " to " + tempFile);

    }

    public String returnAttachment(String tempFile) throws SAXException, IOException, ParserConfigurationException {

        log.info("Reading file " + tempFile);

        InputStream is = getFileFromResourceAsStream(tempFile);

        String output = printInputStream(is).toString();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();

        doc = builder.parse(new InputSource(new StringReader(output)));

        return doc.getElementsByTagName("Attachment").item(0).getTextContent();

    }

    private InputStream getFileFromResourceAsStream(String fileName) throws FileNotFoundException {

        InputStream inputStream = new FileInputStream(fileName);

        return inputStream;

    }

    private StringBuilder printInputStream(InputStream is) {

        StringBuilder output = new StringBuilder();

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

}
