package com.example.controller;

import com.example.config.CaptchaConfig;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Project: com.example.controller
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/8 20:13
 * @Description:
 */
@RestController
@RequiredArgsConstructor
public class CaptchaController {

    private final DefaultKaptcha captchaProducer;

    @GetMapping(value="/code")
    public void kaptcha(HttpSession session, HttpServletResponse response) throws IOException {

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();

        session.setAttribute(CaptchaConfig.CAPTCHA_SESSION_KEY,capText);

        try(ServletOutputStream out = response.getOutputStream()){
            BufferedImage bufferedImage = captchaProducer.createImage(capText);
            ImageIO.write(bufferedImage,"jpg",out);
            out.flush();
        }
    }
}
