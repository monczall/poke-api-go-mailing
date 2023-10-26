package com.pokeapigo.mailing.module.mailing;

import com.pokeapigo.mailing.module.mailing.dto.SendEmailRequest;

public interface MailingService {
    void sendEmail(SendEmailRequest emailRequest);
}
