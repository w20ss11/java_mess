package pack180104_mess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Jama.Matrix;

public class Arraystest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] ds = new double[][]{{2,2},{4,4}};
		double[][] ds1 = new double[][]{{2,2},{2,2}};
		System.out.println(Arrays.toString(ds[0]));
		Matrix matrix = new Matrix(ds);
		System.out.println(matrix.toString());
		Matrix matrix1 = new Matrix(ds1);
//		matrix = matrix1.arrayLeftDivide(matrix);
//		matrix = matrix.minus(matrix1);
//		matrix =matrix.times(0.5);
		matrix.set(0, 1, 100);
		matrix.set(0, 0, 99);
		System.out.println(matrix.getRowDimension());
		System.out.println(matrix.getColumnDimension());
		
//		System.out.println(Arrays.deepToString(matrix.getMatrix(0, 0, 0, matrix.getColumnDimension()).getArray()));

		ArrayList<String> list = null;
//		System.out.println(list.toString());
		list = new ArrayList<>();
		list.add("aaa");
		System.out.println(list.toString());
		list.clear();
		System.out.println(list.toString());
		
//		double[] ds3 = new double[]{2.0,4.0};
//		System.out.println(Arrays.deepToString(mathUtil.getAverage(ds3)));
		
	}

}
