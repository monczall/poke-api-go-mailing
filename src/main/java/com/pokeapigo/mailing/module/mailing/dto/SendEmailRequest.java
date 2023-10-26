package com.pokeapigo.mailing.module.mailing.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record SendEmailRequest(
        @Email
        @NotBlank(message = "{mailing.email.notBlank}")
        @Size(min = 5, message = "{mailing.email.rangeMin}")
        @Size(max = 320, message = "{mailing.email.rangeMax}")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{mailing.email.invalidFormat}")
        String recipientAddress,
        @NotBlank(message = "{mailing.subject.notBlank}")
        @Size(min = 5, message = "{mailing.subject.rangeMin}")
        @Size(max = 75, message = "{mailing.subject.rangeMax}")
        String subject,
        @NotBlank(message = "{mailing.body.notBlank}")
        @Length(min = 5, message = "{mailing.body.rangeMin}")
        String body
) {
}
