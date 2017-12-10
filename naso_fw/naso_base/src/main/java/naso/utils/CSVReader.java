package naso.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CSVReader {

	private static List<Object> parseCSVFile(String csvFilePath, boolean getSize, int rowNo, int columnNo) {
		ArrayList<Object> returner = new ArrayList<Object>();
		int sizeCounter = 0;
		int lineCounter = 0;
		try {
			BufferedReader input = new BufferedReader(new FileReader(csvFilePath));
			String line = null;
			if (getSize) {
				while ((line = input.readLine()) != null) {
					sizeCounter++;
				}
				returner.add(sizeCounter);
				return returner;
			} else if (rowNo > -1 && columnNo > -1) {
				while ((line = input.readLine()) != null) {
					if (lineCounter == rowNo) {
						String[] fields = parseCSVLine(line);
						returner.add(fields[columnNo]);
					}
					lineCounter++;
				}
				return returner;
			} else if (rowNo > -1) {
				while ((line = input.readLine()) != null) {
					if (lineCounter == rowNo) {
						String[] fields = parseCSVLine(line);
						for (int i = 0; i < fields.length; i++) {
							returner.add(fields[i]);
						}
					}
					lineCounter++;
				}
				return returner;
			} else if (columnNo > -1) {
				while ((line = input.readLine()) != null) {
					String[] fields = parseCSVLine(line);
					if (fields.length < (columnNo + 1)) {
						System.out.println("Column " + columnNo + " is not available for the row No: " + lineCounter);
						returner.add(null);
					} else
						returner.add(fields[columnNo]);
					lineCounter++;
				}
				return returner;
			}
			input.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	private static String[] parseCSVLine(String line) {
		Pattern pattern = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
		String[] fields = pattern.split(line, -1);
		for (int i = 0; i < fields.length; i++) {
			fields[i] = fields[i].replace("\"", "");
		}
		return fields;
	}

	public static int getSize(String csvFilePath) {
		return (Integer) parseCSVFile(csvFilePath, true, -1, -1).get(0);
	}

	public static ArrayList<String> getRecordByRow(String csvFilePath, int rowNo) {
		return (ArrayList) parseCSVFile(csvFilePath, false, --rowNo, -1);

	}

	public static ArrayList<String> getHeader(String csvFilePath) {
		return getRecordByRow(csvFilePath, 1);
	}

	public static ArrayList<String> getFooter(String csvFilePath) {
		return getRecordByRow(csvFilePath, (getSize(csvFilePath)));
	}

	public static ArrayList<String> getRecordByColumn(String csvFilePath, int columnNo) {
		return (ArrayList) parseCSVFile(csvFilePath, false, -1, --columnNo);
	}

	public static String getRecord(String csvFilePath, int rowNo, int columnNo) {
		return (String) parseCSVFile(csvFilePath, false, --rowNo, --columnNo).get(0);
	}

}
