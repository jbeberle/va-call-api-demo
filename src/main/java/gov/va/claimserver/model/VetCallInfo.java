package gov.va.claimserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VetCallInfo {
    private String id;
    private String channel;
    private String fullName;
    private String description;
    private String email;
    private String service;
    private String branch;
    private String screen;
    private String callReason;
    private String callClaimDescription;
    private String claimId;
    private String claimType;
    private String claimPhase;
}
