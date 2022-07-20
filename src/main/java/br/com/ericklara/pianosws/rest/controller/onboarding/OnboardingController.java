package br.com.ericklara.pianosws.rest.controller.onboarding;

import br.com.ericklara.pianosws.domain.dto.NewUserDTO;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.usecase.onboarding.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onboard")
public class OnboardingController {

    private final OnboardingService onboardingService;

    @Autowired
    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponse<String>> newUser(@RequestBody NewUserDTO userDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(onboardingService.newUser(userDTO));
    }
}
