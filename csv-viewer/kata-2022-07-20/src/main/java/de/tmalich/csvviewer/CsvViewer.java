package de.tmalich.csvviewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvViewer {

    List<String> lines;
    String csvPath;

    static final String CELL_BORDER = "|";

    static final String SEPERATOR = ";";

    static final String MINUS = "-";

    public static void main(String args[]) throws IOException {
        CsvViewer viewer = new CsvViewer(args);
        viewer.load();
    }

    public CsvViewer(String[] args) {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException();
        }
        csvPath = args[0];
    }

    public void load() throws IOException {
        lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        }
    }

    protected List<String> getFormattedLines() {
        String line = lines.get(0);
        String[] columns = line.split(SEPERATOR);
        List<String> formattedLines = new ArrayList<>();
        StringBuilder header = new StringBuilder();
        StringBuilder headerSeperator = new StringBuilder();
        for (String column : columns) {
            header.append(CELL_BORDER);
            header.append(column);
            headerSeperator.append(CELL_BORDER);
            headerSeperator.append(MINUS.repeat(column.length()));
        }
        header.append(CELL_BORDER);
        headerSeperator.append(CELL_BORDER);
        formattedLines.add(header.toString());
        formattedLines.add(headerSeperator.toString());

        return formattedLines;
    }
}
