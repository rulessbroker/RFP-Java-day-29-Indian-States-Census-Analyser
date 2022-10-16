package com.java;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {
	public static ArrayList<CSVStateCensus> csvStateCensuses = new ArrayList<>();
	 static ArrayList<CSVState> csvStates = new ArrayList<>();

	public int loadData(File file) throws CensusAnalyserException, CsvException, IOException {

		checkInputFile(file);
		FileReader fileReader = new FileReader(file);
		try (CSVReader csvReader = new CSVReader(fileReader)) {
			List<String[]> stateCensus = csvReader.readAll();
			String[] header = stateCensus.get(0);
			if (!header[0].equals("State") || !header[1].equals("Population"))
				throw new CensusAnalyserException("header mismatch");

			stateCensus.remove(header);
			for (String[] data : stateCensus) {
				if (data.length < 2)
					throw new CensusAnalyserException("Incorrect Delimiter");
				csvStateCensuses.add(new CSVStateCensus((data[0]), Long.parseLong(data[1].replace(",", ""))));

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return csvStateCensuses.size();
	}

	public int loadStates(File file) throws CensusAnalyserException, IOException, CsvException {
		checkInputFile(file);
		FileReader fileReader = new FileReader(file);
		try (CSVReader csvReader = new CSVReader(fileReader)) {
			List<String[]> states = csvReader.readAll();
			String[] header = states.get(0);
			if (!header[1].equals("State/ UT") || !header[2].equals("Abbreviation"))
				throw new CensusAnalyserException("header mismatch");

			states.remove(header);
			for (String[] data : states) {
				if (data.length < 2)
					throw new CensusAnalyserException("Incorrect Delimiter");
				csvStates.add(new CSVState(data[1], data[2]));
			}
		}

		return csvStates.size();
	}

	void checkInputFile(File file) throws CensusAnalyserException {
		if (!file.exists()) {
			throw new CensusAnalyserException("fine not exists");
		}
		String expectedFileType = "csv";
		int index = file.toString().lastIndexOf(".");
		String actualFileType = file.toString().substring(index + 1);
		if (!expectedFileType.equals(actualFileType))
			throw new CensusAnalyserException("file type doesn't match");
	}
}
