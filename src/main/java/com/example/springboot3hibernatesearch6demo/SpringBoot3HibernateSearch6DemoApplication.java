package com.example.springboot3hibernatesearch6demo;

import com.example.springboot3hibernatesearch6demo.config.Indexer;
import com.example.springboot3hibernatesearch6demo.demo.DemoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SpringBoot3HibernateSearch6DemoApplication {

  public static void main(String[] args) {

    final var context = SpringApplication.run(SpringBoot3HibernateSearch6DemoApplication.class,
        args);

    if ("always".equals(context.getEnvironment().getProperty("app.reset-with-demo-data"))) {

      log.warn("正在初始化测试数据...");

      ((DemoService) context.getBean("datasourceDemoService")).run();

      log.warn("测试数据初始化完成！");
    }
  }

  @Bean
  @SneakyThrows
  public ApplicationRunner buildIndex(Indexer indexer) {

    return (ApplicationArguments args) ->
        indexer.indexPersistedData("com.example.springboot3hibernatesearch6demo.model.Plant");
  }
}
