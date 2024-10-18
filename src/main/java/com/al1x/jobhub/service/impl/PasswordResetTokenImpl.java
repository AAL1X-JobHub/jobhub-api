package com.al1x.jobhub.service.impl;

import com.al1x.jobhub.exception.ResourceNotFoundException;
import com.al1x.jobhub.integration.notification.email.dto.Mail;
import com.al1x.jobhub.integration.notification.email.service.EmailService;
import com.al1x.jobhub.model.entity.PasswordResetToken;
import com.al1x.jobhub.model.entity.User;
import com.al1x.jobhub.repository.PasswordResetTokenRepository;
import com.al1x.jobhub.repository.UserRepository;
import com.al1x.jobhub.service.PasswordResetTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordResetTokenImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Transactional
    @Override
    public void createAndSendPasswordResetToken(String email) throws Exception {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con correo " + email + " no fue encontrado"));

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(UUID.randomUUID().toString());
        passwordResetToken.setUser(user);
        passwordResetToken.setExpiration(10);
        passwordResetTokenRepository.save(passwordResetToken);

        Map<String, Object> model = new HashMap<>();
        String resetUrl = "http://localhost:4200/#/forgot/" + passwordResetToken.getToken();
        model.put("user", user.getEmail());
        model.put("resetUrl", resetUrl);

        Mail mail = emailService.createMail(
                user.getEmail(),
                "Restablecer Contraseña",
                model,
                mailFrom
        );

        emailService.sendEmail(mail,"email/password-reset-template");
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Token de restablecimiento de contraseña no encontrado"));
    }

    @Override
    public void removeResetToken(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.delete(passwordResetToken);
    }

    @Override
    public boolean isValidToken(String token) {
        return passwordResetTokenRepository.findByToken(token)
                .filter(t->!t.isExpired())
                .isPresent();
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
                .filter(t->!t.isExpired())
                .orElseThrow(() -> new ResourceNotFoundException("Token invalido o expirado"));

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        passwordResetTokenRepository.delete(resetToken);
    }
}