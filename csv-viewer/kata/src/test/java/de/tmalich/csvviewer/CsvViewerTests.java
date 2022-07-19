package de.tmalich.csvviewer;

import org.junit.jupiter.api.Test;

class CsvViewerTests {

	@Test
	void mainIsNullSafe() {
		CsvViewer.main(null);
	}

}
