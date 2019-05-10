package hrm.logic;

import java.util.ArrayList;

import hrm.dao.TuVanDao;
import hrm.entities.ungvien;

public class TuVanLogic {
	TuVanDao tvDao = new TuVanDao();

	public ArrayList<ungvien> getArrayUV(int page, String type) {
		ArrayList<ungvien> arruv = new ArrayList<>();

		arruv = tvDao.getArrayUV(page, type);
		return arruv;
	}

	public ArrayList<Integer> getListPage() {
		ArrayList<Integer> list = new ArrayList<>();
		int total = tvDao.getTotalPage();
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}

	public int getRowTotal() {
		int total = tvDao.getRowTotal();
		return total;
	}

	public Float[][] getData(int row) {
		Float data[][] = new Float[row][9];
		data = tvDao.getData(row);
		return data;
	}

	public Float[][] standardize(Float[][] data) {
		Float dataStandardize[][] = new Float[data.length][data[0].length];
		dataStandardize = tvDao.standardize(data);
		return dataStandardize;
	}

	public Float[][] weightedMatrix(Float[][] data, ArrayList<Double> arrtrongso) {
		Float dataWeightedMatrix[][] = new Float[data.length][data[0].length];
		dataWeightedMatrix = tvDao.weightedMatrix(data, arrtrongso);
		return dataWeightedMatrix;
	}

	public Float[][] idealSolution(Float[][] data) {
		Float A[][] = new Float[2][data[0].length];
		A = tvDao.idealSolution(data);
		return A;
	}

	public Double[][] distanceIdealSolution(Float[][] data, Float[][] A) {
		Double S[][] = new Double[2][data.length];
		S = tvDao.distanceIdealSolution(data, A);
		return S;
	}

	public Double[] calculateC(Double[][] S, int row) {
		Double C[] = new Double[row];
		C = tvDao.calculateC(S, row);
		return C;
	}

	public boolean checkUpdateC(Double[] C) {
		boolean msgCheck;

		if (tvDao.checkUpdateC(C)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

}
