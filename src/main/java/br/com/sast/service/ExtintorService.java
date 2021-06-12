package br.com.sast.service;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.common.io.Files;
import com.opencsv.CSVWriter;

import br.com.sast.dto.ExtintorFiltroDTO;
import br.com.sast.model.Extintor;
import br.com.sast.repository.ExtintorRepository;
import br.com.sast.util.ConfigCamposCSV;

@Service
public class ExtintorService {

	@Autowired
	private ExtintorRepository extintorRepository;
	
	//@Autowired
	//private ConfigCamposCSV recuperaAtributosClasse;

	public Extintor salvaExtintor(Extintor extintor) {

		Extintor retornoExtintor = this.extintorRepository.save(extintor);

		return retornoExtintor;
	}

	public List<Extintor> listaExtintores() {
		return this.extintorRepository.findAll();
	}

	public Extintor alteraExtintor(Short id, Extintor extintor) {

		extintor.setId(id);

		Extintor extintorRetorno = this.extintorRepository.save(extintor);

		return extintorRetorno;

	}

	public void deletaExtintor(Short id) {

		this.extintorRepository.deleteById(id);

	}

	public Extintor buscaExtintorPorId(Short id) {
		return this.extintorRepository.findById(id).get();
	}

	public List<Extintor> filtroExtintor(ExtintorFiltroDTO dto) {
		return this.extintorRepository.filtroExtintor(dto);
	}

	@SuppressWarnings("rawtypes")
	public void exportarCSV(HttpServletResponse response) {

		response.setContentType("text/csv");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=extintores_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Extintor> extintores = this.extintorRepository.findAll();

		try {
			
			ConfigCamposCSV atributosClasse = new ConfigCamposCSV();

			ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			String[] csvHeader = { "Identificador", "Patrimonio", "Lacre", "Inmetro", "Tipo", "LTKG", "Data Recarga", "Dias Vencimento", "Data Vencimento", "Localização" };

			csvWriter.writeHeader(csvHeader);

			for (Extintor extintor : extintores) {
				csvWriter.write(extintor, atributosClasse.getAtributosClasse(Extintor.class));
			}

			csvWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
