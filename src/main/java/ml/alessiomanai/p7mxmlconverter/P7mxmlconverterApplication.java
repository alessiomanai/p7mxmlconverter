package ml.alessiomanai.p7mxmlconverter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;
import ml.alessiomanai.p7mxmlconverter.service.ConverterService;
import ml.alessiomanai.p7mxmlconverter.service.DecoderService;

@Log4j2
@SpringBootApplication
public class P7mxmlconverterApplication implements CommandLineRunner {

	@Autowired
	ConverterService converterService;

	@Autowired
	DecoderService decoderService;

	@Value("${args.input.error}")
	private String argsNotFound;


	public static void main(String[] args) {
		SpringApplication.run(P7mxmlconverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(args.length < 3){
			throw new RuntimeException(argsNotFound);
		}

		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

		if(isWindows){
			throw new Exception("Not compatible with windows");
		}

		converterService.convertP7m(args[0], args[1]);

		String attachment = converterService.returnAttachment(args[1]);

        decoderService.convertBase64Attachment(attachment, args[2]);

		log.info("Done");
	}

}
