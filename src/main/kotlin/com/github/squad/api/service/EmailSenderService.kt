package com.github.squad.api.service

import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Email
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ByteArrayResource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.net.URL
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Service
class EmailSenderService(
    private val emailSender: JavaMailSender
) {

    fun sendMail(email: Email) {
        val msg = if (email.withAttachment) createMessageWithAttachment(email) else
            createSimpleMessage(email)

        emailSender.send(msg)
    }

    private fun createSimpleMessage(email: Email): MimeMessage {
        val message: MimeMessage = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)

        setupMessage(helper, email)

        return message
    }
    private fun createMessageWithAttachment(email: Email): MimeMessage {
        val message: MimeMessage = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)
        val kotlinIconStream = URL("https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png").openStream()
        val springIconStream = URL("https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg").openStream()

        setupMessage(helper, email )
        helper.addAttachment("KotlinIcon.png", ByteArrayResource(IOUtils.toByteArray(kotlinIconStream)))
        helper.addAttachment("SpringIcon.svg", ByteArrayResource(IOUtils.toByteArray(springIconStream)))

        return message
    }

    private fun setupMessage(helper: MimeMessageHelper, email: Email) {
        helper.setTo(InternetAddress.parse("${email.toAluno}, ${email.toMentor}"))
        helper.setSubject(email.subject)
        helper.setText(email.text)
    }

}