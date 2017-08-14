package statistics_collector;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StatisticCollector {
    /**
     * finds all *.csv files and reads it
     */
    public void findAndReadFile() {
        String[] fileNames = findAllCsvFiles();
        List<String> unitedList = new LinkedList<>();
        Handler handler = new Handler();
        for (int i = 0; i < fileNames.length; i++) {
            new ReaderOfFiles().run(fileNames[i], unitedList);
        }
        handler.informationHandlingInList(unitedList);
        writeInFile(unitedList);
    }

    /**
     * Writes information from list to output.csv file
     *
     * @param unitedList list with information from all files
     */
    private void writeInFile(List<String> unitedList) {
        String projectPath = new File("").getAbsolutePath();
        File filePath = new File(projectPath + "\\src\\main\\java\\statistics_collector\\output");
        File statisticFile = new File(projectPath +
                "\\src\\main\\java\\statistics_collector\\output\\output.csv");
        filePath.mkdirs();
        if (statisticFile.exists()) {
            statisticFile.delete();
        }
        try {
            statisticFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "D:\\JavaCore\\EJC\\src\\main\\java\\statistics_collector\\output\\output.csv"))) {
            writer.write("\"user\";\"URL\";\"time\"\n");
            for (int i = 0; i < unitedList.toArray().length; i++) {
                writer.write(unitedList.toArray()[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds information from one list to united one
     *
     * @param listToUnite list, which need to be added to united one
     * @param listUnited list with information from all files
     */
    public synchronized void uniteAllArraysInOne(List<String> listToUnite, List<String> listUnited) {
        listUnited.addAll(listToUnite);
    }

    /**
     * Finds all names of *.csv files
     *
     * @return array with all names of *.csv files
     */
    private String[] findAllCsvFiles() {
        File file = new File("D:\\JavaCore\\EJC\\src\\main\\java\\statistics_collector\\csv_files");
        MyFileFilter fileFilter = new MyFileFilter();
        File[] filesList = file.listFiles(fileFilter);
        String[] fileNames = new String[filesList.length];
        for (int i = 0; i < filesList.length; i++) {
            fileNames[i] = filesList[i].getName();
        }
        return fileNames;
    }

    private class ReaderOfFiles extends Thread {
        public void run(String fileName, List<String> unitedList) {
            readFile(fileName, unitedList);
        }

        /**
         * Reads files and adds information in lists
         *
         * @param fileName name of *.csv file
         * @param unitedList list with all information from files
         */
        private void readFile(String fileName, List unitedList) {
            List<String> list = new ArrayList<>();
            String currentLine;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(
                        "D:\\JavaCore\\EJC\\src\\main\\java\\statistics_collector\\csv_files\\" + fileName));
                reader.readLine();
                while ((currentLine = reader.readLine()) != null) {
                    currentLine = currentLine.replaceFirst(currentLine.substring(0, currentLine.indexOf(';')),
                            currentLine.substring(currentLine.lastIndexOf(';') + 1));
                    currentLine = currentLine.substring(0, currentLine.lastIndexOf(';'));
                    list.add(currentLine);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            uniteAllArraysInOne(list, unitedList);
        }
    }

    private class MyFileFilter implements FileFilter {
        public boolean accept(File pathname) {
            return pathname.isFile() && pathname.getName().endsWith(".csv");
        }
    }
}
