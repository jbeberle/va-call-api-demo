package gov.va.claimserver.service;

import gov.va.claimserver.model.VetCallInfo;
import gov.va.claimserver.repository.VetCallRepository;
import gov.va.claimserver.service.VetCallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class VetCallServiceTests {
    private VetCallRepository vetCallRepository;

    private VetCallService vetCallService;

    @BeforeEach
    public void setup() {
        vetCallRepository = mock(VetCallRepository.class);
//        vetCallService = new VetCallService(vetCallRepository);
    }
    @Test
    void addNewCalli() {
        VetCallInfo vetCall = VetCallInfo.builder()
                .branch("Air Force")
                .email("john_joe@gmail.com")
                .service("IDME")
                .claimId("100")
                .claimType("claim")
                .claimPhase("Some phase")
                .fullName("John A. Doe")
                .screen("Screen")
                .callReason("A Call Reason")
                .callClaimDescription("A Call Description")
                .build();
//        vetCallService.addNewCall(vetCall);
    }

    @Test
    void getAllCalls() {
//        vetCallService.getCalls();
    }




}
