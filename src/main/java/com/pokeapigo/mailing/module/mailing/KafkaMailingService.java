package com.pokeapigo.mailing.module.mailing;

import com.pokeapigo.mailing.module.mailing.dto.SendEmailRequest;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
class KafkaMailingService implements MailingService {

    private final JavaMailSender mailSender;

    private final Validator validator;

    @Value("${poke-api-go.mail.senderAddress}")
    private String mailSenderAddress;

    KafkaMailingService(JavaMailSender mailSender, Validator validator) {
        this.mailSender = mailSender;
        this.validator = validator;
    }

    @Override
    public void sendEmail(SendEmailRequest emailRequest) {
        validator.validate(emailRequest);

        MimeMessage message = getMimeMessage(emailRequest);
        mailSender.send(message);
    }

    private MimeMessage getMimeMessage(SendEmailRequest emailRequest) {
        // TODO

        return null;
    }
}
