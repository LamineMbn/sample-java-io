package com.sample.io.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

	public static Stream<String> fileToStream(String fileName) throws IOException, URISyntaxException {
		Path pathToFile = Paths.get(FileUtils.class.getClassLoader().getResource(fileName).toURI());
		return Files.lines(pathToFile);
	}

	public static List<String> fileToList(String fileName) throws IOException, URISyntaxException {
		Path pathToFile = Paths.get(FileUtils.class.getClassLoader().getResource(fileName).toURI());
		return fileToStream(fileName).collect(Collectors.toList());
	}

	public static void writeFile(List<String> elementsToWrite, String fileName) throws IOException {
		File fout = new File(fileName);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		elementsToWrite.forEach(conf -> {
			try {
				bw.write(conf);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		bw.close();
	}
}
