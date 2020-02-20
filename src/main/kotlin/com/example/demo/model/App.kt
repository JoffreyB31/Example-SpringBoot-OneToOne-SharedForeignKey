package com.example.demo.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty


@Entity
data class App(

    @Id
    @Column(name = "app_id", unique = true, nullable = false, insertable = false)
    val appId: Long = 0,

    @NotEmpty
    var name: String = "",

    @OneToOne(mappedBy = "app", cascade = [CascadeType.ALL], orphanRemoval = true)
    var description: AppDescription? = null

) {

  @CreationTimestamp
  @Column(updatable = false)
  val created: Date = Date()

  @UpdateTimestamp
  val updated: Date = Date()

}