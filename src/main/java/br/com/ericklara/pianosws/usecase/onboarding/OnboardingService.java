package br.com.ericklara.pianosws.usecase.onboarding;

import br.com.ericklara.pianosws.domain.dto.NewUserDTO;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;

public interface OnboardingService {
    DefaultResponse<String> newUser(NewUserDTO userDTO);
}
