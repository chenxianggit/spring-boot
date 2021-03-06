package com.cx.controller;


import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/kafka")
public class KafkaController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @ApiOperation(value="发送信息", notes="")
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
        try {
            String message = request.getParameter("message");
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("test1", "key", message);
            logger.info("发送kafka成功.");
            return "发送kafka成功";
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) {
        try {
            return "123";
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
            return "123";
        }
    }

}