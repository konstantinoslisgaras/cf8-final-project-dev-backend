package solipsismal.olympiacosfcapp.dto;

import lombok.Builder;

@Builder
public record UserRegisterResponseDTO(

        String username,
        String firstname,
        String token
) {}