package com.java;

import static org.junit.Assert.*;

import org.junit.Test;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class StateCensusAnalyserTest {
	static final String PATH = System.getProperty("user.dir");
	static final String CSV_FILE_PATH = PATH.concat("//src//com//resources//Indian_States_Census.csv");
	static final String INCORRECT_FILE_PATH = PATH.concat("//src//com//resources//Indian_StatesCensus.csv");
	static final String INCORRECT_TYPE_FILE_PATH = PATH.concat("//src//com//resources//Indian_StatesCensus.csv");
	static final String INCORRECT_DELIMITER_FILE_PATH = PATH
			.concat("//src//com//resources//Indian_States_Census_Incorrect_Delimiter.csv");
	static final String INCORRECT_HEADER_FILE_PATH = PATH
			.concat("//src//com//resources//Indian_States_Census_Incorrect_header.csv");
	static StateCensusAnalyser stateCensusAnalyser;

	@BeforeAll
	static void initialize() {
		stateCensusAnalyser = new StateCensusAnalyser();
	}

	@Test
	void givenCSVFile_ShouldMatch_NumberOfRecords() throws IOException, CsvException, CensusAnalyserException {
		StateCensusAnalyser.csvStateCensuses.clear();
		int countOfRecords = stateCensusAnalyser.loadData(new File(CSV_FILE_PATH));
		Assertions.assertEquals(29, countOfRecords);
	}

	@Test
	void givenCSVFileIncorrectPath_ShouldThrowException() {
		File file = new File(INCORRECT_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	void givenCSVFileIncorrectType_ShouldThrowException() {
		File file = new File(INCORRECT_TYPE_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	void givenCSVFileIncorrectDelimiter_ShouldThrowException() {
		File file = new File(INCORRECT_DELIMITER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	void givenCSVFileIncorrectHeader_ShouldThrowException() {
		File file = new File(INCORRECT_HEADER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

}
