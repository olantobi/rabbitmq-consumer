package com.liferon.rabbitmqconsumer;

import com.google.gson.Gson;
import com.liferon.rabbitmqconsumer.dto.MailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    //@Autowired
    //MailServiceImpl mailServiceImpl;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public void receiveMessage(String message) {
        logger.info("Received (String) " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        logger.info("Received (No String) " + strMessage);
        processMessage(strMessage);
    }

    private void processMessage(String message) {
        try {
            Gson gson = new Gson();
            MailDTO mailDTO = gson.fromJson(message, MailDTO.class);
            //ValidationUtil.validateMailDTO(mailDTO);
            //mailServiceImpl.sendMail(mailDTO, null);
            System.out.println("This is my message: "+mailDTO);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
