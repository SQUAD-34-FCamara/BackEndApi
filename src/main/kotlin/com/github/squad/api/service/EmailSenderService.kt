package com.github.squad.api.service

import org.thymeleaf.spring5.SpringTemplateEngine
import com.github.squad.api.model.Email
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ByteArrayResource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import java.net.URL
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Service
class EmailSenderService(
    private val emailSender: JavaMailSender,
    private var templateEngine: SpringTemplateEngine
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
        val template = "emailTemplate"
        val message: MimeMessage = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true, "UTF-8")
        val nameALuno:  String = email.nameAluno
        val linkTeeams: String? = email.linkTeams
        val data: String? = email.data
        val hora: String? = email.hora
        val nameMentor: String? = email.nameMentor
        var context: Context = Context()
        context.setVariable("nameAluno", nameALuno, )
        context.setVariable("linkTeeams", linkTeeams)
        context.setVariable("data", data)
        context.setVariable("hora", hora)
        context.setVariable("nameMentor", nameMentor)

        val html: String = templateEngine.process(template, context)
//        val kotlinIconStream = URL("https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png").openStream()

        setupMessage(helper, email )
        helper.setText(html, true)
//        helper.addAttachment("KotlinIcon.png", ByteArrayResource(IOUtils.toByteArray(kotlinIconStream)))


        return message
    }

    private fun setupMessage(helper: MimeMessageHelper, email: Email) {
        helper.setTo(InternetAddress.parse("${email.toAluno}, ${email.toMentor}"))
        helper.setSubject(email.subject)
        helper.setText(email.text)
    }

}