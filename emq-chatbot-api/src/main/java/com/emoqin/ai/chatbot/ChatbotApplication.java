package com.emoqin.ai.chatbot;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Aerol
 * @Date 2023/3/3
 * @Version 1.0
 */
@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ChatbotApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }


    @Resource
    private Environment env;

    @Override
    public void run(String... args) {
        final String port = env.getProperty("local.server.port");

        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "项目端口: \t{} \n\t" +
                            "swagger: \t{} \n\t" +
                            "swagger: \t{} \n" +
                            "----------------------------------------------------------",
                    port,
                    "暂无",
                    "暂无");
        });
    }
}
