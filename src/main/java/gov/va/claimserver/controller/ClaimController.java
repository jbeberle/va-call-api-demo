package gov.va.claimserver.controller;

import gov.va.claimserver.model.VetCallInfo;
import gov.va.claimserver.repository.VetCallRepository;
import gov.va.claimserver.service.VetCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5001", "http://localhost:3001"})
public class ClaimController {

    VetCallService vetCallService;
    VetCallRepository vetCallRepository;

    @Autowired
    public ClaimController(VetCallRepository vcr) {
        this.vetCallRepository = vcr;
        this.vetCallService = new VetCallService(vcr);
    }

    @PostMapping("/vetcall")
    public ResponseEntity<?> addCall(@RequestBody VetCallInfo vetCallInfo) {
        String contentType = "application/json";
        System.out.println("vetCallInfo=");
        System.out.println(vetCallInfo);
        vetCallService.addNewCall(vetCallInfo);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(vetCallInfo);
    }

    @GetMapping(value = "/calls")
    Collection<VetCallInfo> fetchCalls() {
        Collection<VetCallInfo> calls = vetCallService.getCalls();
        return calls;
    }
}
