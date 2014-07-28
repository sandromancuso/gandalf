package com.codurance;

import com.codurance.controllers.MainController;
import com.codurance.controllers.ProjectEstimationController;
import com.codurance.page_objects.ProjectEstimationsPage;

import static spark.Spark.get;

public class Gandalf {

	private MainController mainController;
	private ProjectEstimationController projectEstimationController;

	public Gandalf(MainController mainController, ProjectEstimationController projectEstimationController) {
		this.mainController = mainController;
		this.projectEstimationController = projectEstimationController;
	}

	public void run() {
		initialiseRoutes();
	}

	private void initialiseRoutes() {
		initialiseMainRoutes();
		initialiseProjectEstimationsRoutes();
	}

	private void initialiseProjectEstimationsRoutes() {
		get(ProjectEstimationsPage.URL, (request, response) -> {
			return projectEstimationController.displayProjectEstimations(request, response);
		});

	}

	private void initialiseMainRoutes() {
		get("/",(request, response) -> {
			return mainController.displayMainPage(request, response);
		});
	}
}
