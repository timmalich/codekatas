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
        List<String> formattedLines = new ArrayList<>();

        List<Integer> columnSizes = calculateColumnSizes();

        formatHeader(formattedLines, columnSizes);
        formatData(formattedLines, columnSizes);

        return formattedLines;
    }

    private List<Integer> calculateColumnSizes() {
        List<Integer> bla = new ArrayList<>();

        for (String line : lines) {
            String[] columns = line.split(SEPERATOR);
            for (int i = 0; i < columns.length; i++) {
                String column = columns[i];
                if (bla.size() == i) {
                    bla.add(column.length());
                } else {
                    bla.set(i, Math.max(bla.get(i), column.length()));
                }
            }
        }
        return bla;
    }

    private void formatHeader(List<String> formattedLines, List<Integer> columnSizes) {
        String line = lines.get(0);
        String[] columns = line.split(SEPERATOR);
        StringBuilder header = new StringBuilder();
        StringBuilder headerSeperator = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            String column = columns[i];
            header.append(CELL_BORDER);
            header.append(column);
            headerSeperator.append(CELL_BORDER);
            headerSeperator.append(MINUS.repeat(columnSizes.get(i)));
        }
        header.append(CELL_BORDER);
        headerSeperator.append(CELL_BORDER);
        formattedLines.add(header.toString());
        formattedLines.add(headerSeperator.toString());
    }

    private void formatData(List<String> formattedLines, List<Integer> columnSizes) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] columns = line.split(SEPERATOR);
            StringBuilder values = new StringBuilder();
            for (int j = 0; j < columns.length; j++) {
                String column = columns[j];
                values.append(CELL_BORDER);
                values.append(column);
                int width = columnSizes.get(j);
                values.append(" ".repeat(width - column.length()));
            }
            values.append(CELL_BORDER);
            formattedLines.add(values.toString());
        }
    }
}
