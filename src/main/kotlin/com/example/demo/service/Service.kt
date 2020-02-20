package com.example.demo.service

import com.example.demo.model.App
import com.example.demo.model.AppDescription
import com.example.demo.repository.AppRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
class Service {

  @Autowired
  private lateinit var repo: AppRepository

  fun create(id: Long): App {
    var app = repo.findByIdOrNull(id)
    if (app == null) {
      app = App(appId = id, name = "App$id")
    }

    if (app.description == null) {
      app.description = AppDescription(app = app)
    }
    app.description!!.name = "Desc$id"

    repo.save(app)

    return app
  }

}