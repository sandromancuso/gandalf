package core.com.codurance.model.proposal;

import com.codurance.model.proposal.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codurance.model.proposal.ProposalId.proposalId;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProposalServiceShould {

	private static final ProposalId NEXT_PROPOSAL_ID = proposalId("11");

	private ProposalJson newProposalJson;

	@Captor ArgumentCaptor<Proposal> proposalArgument;
	@Mock Proposals proposals;

	private ProposalService proposalService;

	@Before
	public void initialise() {
		this.proposalService = new ProposalService(proposals);
		given(proposals.nextId()).willReturn(NEXT_PROPOSAL_ID);
		newProposalJson = new ProposalJson().add("clientId", "5");
	}

	@Test public void
	should_store_a_new_proposal() {
		proposalService.create(newProposalJson);

	    verify(proposals).add(proposalArgument.capture());
		assertThat(proposalArgument.getValue().id(), is(proposalId(NEXT_PROPOSAL_ID.asString())));
	}

	@Test public void
	create_a_new_id_for_a_new_proposal() {
		Proposal proposal = proposalService.create(newProposalJson);

		verify(proposals).nextId();
		assertThat(proposal.id(), is(NEXT_PROPOSAL_ID));
	}

}
