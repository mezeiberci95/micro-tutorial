package com.bercus.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudelentCustomer = fraudCheckService.isFraudulentCustomer(customerId);

        log.info("Fraud check request fpr customer id {}", customerId);
        return new FraudCheckResponse(isFraudelentCustomer);
    }
}
