package com.sample.io.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class DataSetUtils {

	private static final int RULES_INDEX = 0;

	public static List<String> retrieveRulesFromDataSet(List<String> dataSet) {
		return Arrays.asList(dataSet.get(RULES_INDEX).split(StringUtils.SPACE));
	}

	public static List<String> retrieveDataFromDataSet(List<String> dataSet) {
		return dataSet.subList(RULES_INDEX + 1, dataSet.size());
	}

	public static Integer[][] generateMatrixFromList(List<String> dataList, int numberOfRow, int numberOfColumn) {
		Integer[][] matrix = new Integer[numberOfRow][numberOfColumn];
		int i = 0,j = 0;
		for (String row : dataList) {
			for (String col : row.split(StringUtils.SPACE)) {
					matrix[i][j] = new Integer(col);
				j++;
			}
			i++;
			j = 0;
		}
		return matrix;
	}
}
