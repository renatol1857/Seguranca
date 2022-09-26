package com.renatol.seguranca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renatol.seguranca.model.local.CodErro;
import com.renatol.seguranca.repositories.local.CodErroRepository;

@SpringBootApplication
public class SegurancaApplication implements CommandLineRunner{
	
	@Autowired
	CodErroRepository codErroRepository;
	Logger logger = LoggerFactory.getLogger(SegurancaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SegurancaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Iniciando carga tabela de erros....");
		int iCont = 0;

		String userDirectory = new File("").getAbsolutePath();
		String path = userDirectory.concat("\\error.txt");
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();

		while (true) {
			if ( linha == null )
				break;	
			if (linha.length() > 0 && !linha.startsWith("#")) {
				String[] msg = linha.split(";");
				if (msg.length == 3) {
					iCont++;
					CodErro codErro = new CodErro(msg[0], msg[1], msg[2]);
					codErroRepository.save(codErro);
				}
			}
			linha = buffRead.readLine();
		}
		buffRead.close();
		logger.info("Finalizou carga tabela de erros. Registros [" + iCont + "]");
	}

}
