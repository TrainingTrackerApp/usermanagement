package in.capgemini.trainingtracker.main;

import in.capgemini.trainingtracker.util.DBUtil;
import in.capgemini.trainingtracker.util.UtilMenu;

public class StartUpMain {

	public static void main(String[] args) {
		UtilMenu dbUtil = new UtilMenu();
		dbUtil.start();

	}

}
