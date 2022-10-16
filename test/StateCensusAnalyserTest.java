
import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import com.java.CensusAnalyserException;
import com.java.StateCensusAnalyser;
import com.opencsv.exceptions.CsvException;

public class StateCensusAnalyserTest {

	static final String CENSUS_FILE_PATH = "//src//com//resources//Indian_States_Census.csv";
	static final String CENSUS_INCORRECT_FILE_PATH = ("//src//com//resources//Indian_StatesCensus.csv");
	static final String CENSUS_INCORRECT_TYPE_FILE_PATH = ("//src//com//resources//Indian_StatesCensus.pde");
	static final String CENSUS_INCORRECT_DELIMITER_FILE_PATH = ("//src//com//resources//Indian_States_Census_Incorrect_Delimiter.csv");
	static final String CENSUS_INCORRECT_HEADER_FILE_PATH = ("//src//com//resources//Indian_States_Census_Incorrect_header.csv");
	static final String CSV_STATES_FILE_PATH = ("//src//com//resources//Indian_state_codes.csv");
	static final String CSV_STATES_INCORRECT_FILE_PATH = ("//src//com//resources//Indian_statecode.csv");
	static final String CSV_STATES_INCORRECT_TYPE_FILE_PATH = ("//src//com//resources//Indian_state_codes.pdf");
	static final String CSV_STATES_INCORRECT_DELIMITER_FILE_PATH = ("//src//com//resources//Indian_state_codes_Incorrect_Delimeter.csv");
	static final String CSV_STATES_INCORRECT_HEADER_FILE_PATH =("//src//com//resources//Indian_state_codes_incorrect_header.csv");
	static StateCensusAnalyser stateCensusAnalyser;

	@BeforeAll
	public static void initialize() {
		stateCensusAnalyser = new StateCensusAnalyser();
	}

	@Test
	public void givenCSVFile_ShouldMatch_NumberOfRecords() throws IOException, CsvException, CensusAnalyserException {
		StateCensusAnalyser.csvStateCensuses.clear();
		int countOfRecords = stateCensusAnalyser.loadData(new File(CENSUS_FILE_PATH));
		Assertions.assertEquals(29, countOfRecords);
	}

	@Test
	public void givenCSVFileIncorrectPath_ShouldThrowException() {
		File file = new File(CENSUS_INCORRECT_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	public void givenCSVFileIncorrectType_ShouldThrowException() {
		File file = new File(CENSUS_INCORRECT_TYPE_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	public void givenCSVFileIncorrectDelimiter_ShouldThrowException() {
		File file = new File(CENSUS_INCORRECT_DELIMITER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	@Test
	public void givenCSVFileIncorrectHeader_ShouldThrowException() {
		File file = new File(CENSUS_INCORRECT_HEADER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadData(file));
	}

	// ****************************************
	@Test
	public void givenCSVStateFile_ShouldMatch_NumberOfRecords() throws IOException, CsvException, CensusAnalyserException {
		StateCensusAnalyser.csvStateCensuses.clear();
		int countOfRecords = stateCensusAnalyser.loadStates(new File(CSV_STATES_FILE_PATH));
		Assertions.assertEquals(36, countOfRecords);
	}

	@Test
	public void givenCSVStateFileIncorrectPath_ShouldThrowException() {
		File file = new File(CSV_STATES_INCORRECT_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadStates(file));
	}

	@Test
	public void givenCSVStateFileIncorrectType_ShouldThrowException() {
		File file = new File(CSV_STATES_INCORRECT_TYPE_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadStates(file));
	}

	@Test
	public void givenCSVStateFileIncorrectDelimiter_ShouldThrowException() {
		File file = new File(CSV_STATES_INCORRECT_DELIMITER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadStates(file));
	}

	@Test
	public void givenCSVStateFileIncorrectHeader_ShouldThrowException() {
		File file = new File(CSV_STATES_INCORRECT_HEADER_FILE_PATH);
		Assertions.assertThrows(CensusAnalyserException.class, () -> stateCensusAnalyser.loadStates(file));
	}

}
