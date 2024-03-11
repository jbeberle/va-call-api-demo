package gov.va.claimserver.service;

import gov.va.claimserver.model.VetCallEntity;
import gov.va.claimserver.model.VetCallInfo;
import gov.va.claimserver.repository.VetCallRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetCallService {
    VetCallRepository vetCallRepository;

    public VetCallService() {

    }

    public VetCallService(VetCallRepository vetCallRepository) {
        this.vetCallRepository = vetCallRepository;
    }

    public void addNewCall(VetCallInfo vetCallInfo) {
        vetCallRepository.save(VetCallEntity.builder()
                .service(vetCallInfo.getService())
                .email(vetCallInfo.getEmail())
                .branch(vetCallInfo.getBranch())
                .channel(vetCallInfo.getChannel())
                .fullName(vetCallInfo.getFullName())
                .description(vetCallInfo.getDescription())
                .screen(vetCallInfo.getScreen())
                .callReason(vetCallInfo.getCallReason())
                .callClaimDescription(vetCallInfo.getCallClaimDescription())
                .claimId(vetCallInfo.getClaimId())
                .claimType(vetCallInfo.getClaimType())
                .claimPhase(vetCallInfo.getClaimPhase())
                .build());
    }

    public List<VetCallInfo> getCalls() {
        List<VetCallEntity> vetCallEntities = (List<VetCallEntity>) this.vetCallRepository.findAll();
        List<VetCallInfo> vetCalls = vetCallEntities.stream().map((vetCallEntity -> {
                    return VetCallInfo.builder()
                            .id(vetCallEntity.getId().toString())
                            .service(vetCallEntity.getService())
                            .email(vetCallEntity.getEmail())
                            .branch(vetCallEntity.getBranch())
                            .screen(vetCallEntity.getScreen())
                            .channel(vetCallEntity.getChannel())
                            .fullName(vetCallEntity.getFullName())
                            .description(vetCallEntity.getDescription())
                            .callReason(vetCallEntity.getCallReason())
                            .callClaimDescription(vetCallEntity.getCallClaimDescription())
                            .claimId(vetCallEntity.getClaimId())
                            .claimType(vetCallEntity.getClaimType())
                            .claimPhase(vetCallEntity.getClaimPhase())
                            .build();
                }))
                .collect(Collectors.toList());
        return vetCalls;
    }
}
