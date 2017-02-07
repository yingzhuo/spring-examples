package com.github.yingzhuo.examples.scala.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/"))
class ScalaController {

    @GetMapping(path = Array("/greeting"))
    def greeting(): String = "Hello, This is a Scala Controller :)"

}
