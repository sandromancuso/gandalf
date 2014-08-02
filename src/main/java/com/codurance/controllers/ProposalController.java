package com.codurance.controllers;

import com.codurance.model.proposal.ProposalId;
import com.codurance.view.ProjectEstimatePage;
import com.codurance.view.ProjectEstimatesPage;
import spark.Request;
import spark.Response;

public class ProposalController extends BaseController {
	public String displayProjectEstimates(Request request, Response response) {
		ProjectEstimatesPage page = new ProjectEstimatesPage();
		return display(page.template(), page.model());
	}

	public String displayEstimateWithMatching(ProposalId proposalId) {
		ProjectEstimatePage page = new ProjectEstimatePage();
		return display(page.template(), page.model());
	}
}
