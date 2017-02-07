package com.github.yingzhuo.examples.scala

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigJackson {

    @Autowired(required = false)
    def configObjectMapper(objectMapper: ObjectMapper): Unit = {
        objectMapper match {
            case null => ;
            case x => x.registerModule(DefaultScalaModule)
        }
    }

}
