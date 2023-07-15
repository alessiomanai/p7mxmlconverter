package ml.alessiomanai.p7mxmlconverter.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DecoderService {
    
    public void convertBase64Attachment(String base64String, String outputFilePath) throws IOException{
        
        byte[] decodedBytes = Base64.getDecoder().decode(base64String.getBytes());

        log.info("Save file to " + outputFilePath); 

        FileOutputStream fos = new FileOutputStream(outputFilePath);
        fos.write(decodedBytes);
        fos.flush();
        fos.close();
    }

}
