package naso.nueral;

import java.util.ArrayList;

import naso.data.Constants;
import naso.utils.CSVReader;

public class SuitManager {
    public final String testManagerPath = Constants.TEST_SUIT_PATH;

    public static ArrayList<String> testCaseIds = null;
    static String currentTestCaseId = null;

    int testCasesCount(ArrayList<String> testCases) {
        int totalTestCases = CSVReader.getSize(testManagerPath);
        if (totalTestCases > 0) {
            return testCases.size();
        }
        return 0;
    }

    ArrayList<String> getAllTestCases() {
        return CSVReader.getRecordByColumn(testManagerPath, 1);
    }

    ArrayList<String> getAllExecutableTestCasesId() {
        int counter = 0;
        ArrayList<String> allTestCases = getAllTestCases();
        int totalNoOfTestCases = testCasesCount(allTestCases);
        ArrayList<String> allTestCasesExecutableStatus = CSVReader.getRecordByColumn(testManagerPath, 2);
        for (int caseIncrementor = 0; caseIncrementor < totalNoOfTestCases; caseIncrementor++, counter++) {
            if (allTestCasesExecutableStatus.get(caseIncrementor).equals("No")) {
                allTestCases.remove(counter);
                counter--;
            }

        }
        return allTestCases;
    }

    public int totalTestCasesCount() {
        return testCasesCount(getAllTestCases());
    }

    public int totalExecutableTestCasesCount() {
        getAllExecutableTestCasesId();
        return testCaseIds.size();
    }

    ArrayList<String> getMethodKeywords(String testCaseId) {
        ArrayList<String> methodKeywords = getMethods(testCaseId);
        // Remove the Initiator case Name
        methodKeywords.remove(0);
        // Remove the execution Status
        methodKeywords.remove(0);
        return methodKeywords;
    }

    ArrayList<String> getMethods(String testCaseId) {
        int counter = 1;
        ArrayList<String> allTestCases = getAllTestCases();
        for (String testCase : allTestCases) {
            if (testCaseId.equals(testCase)) {
                return handleNULLMethods(CSVReader.getRecordByRow(testManagerPath, counter));
            }
            counter++;
        }
        return null;
    }

    ArrayList<String> handleNULLMethods(ArrayList<String> nonNULLHandledMethods) {
        ArrayList<String> nullHandledMethods = new ArrayList<String>();
        for (String method : nonNULLHandledMethods) {
            if (method.equals("")) {
                break;
            } else {
                nullHandledMethods.add(method);
            }
        }
        return nullHandledMethods;
    }

    public void startTestExecution() {
        testCaseIds = getAllExecutableTestCasesId();
        System.out.println("startTestExecution:-------------------------" + testCaseIds);
        executeTestCases(testCaseIds);
    }

    void executeTestCases(ArrayList<String> testCases) {
        for (String testCaseId : testCases) {
            System.out.println("executeTestCases: " + testCaseId);
            executeTest(testCaseId);
        }
    }

    void executeTest(String testCaseId) {
        ArrayList<String> methods = getMethodKeywords(testCaseId);
        System.out.println("executeTest_metods: " + methods);
        executeMethods(methods);
    }

    void executeMethods(ArrayList<String> methods) {
        for (String method : methods) {
            System.out.println("\n\nexecuteMethods:" + method + "\n");
            DynamicMethodCaller.invokeMethod(method);
        }
    }
}
