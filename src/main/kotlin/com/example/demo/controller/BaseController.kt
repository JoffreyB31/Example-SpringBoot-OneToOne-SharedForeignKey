package com.example.demo.controller

import com.example.demo.model.App
import com.example.demo.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional


@RestController
class BaseController {

  @Autowired
  private lateinit var service: Service

  @Transactional
  @RequestMapping("/{id}")
  fun index(@PathVariable(name = "id") id: Long): App {
    return service.create(id)
  }

}