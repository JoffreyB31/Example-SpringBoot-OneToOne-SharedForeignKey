package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.repository.Temporal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty


@Entity
data class AppDescription(
    @NotEmpty
    var name: String = "",

    @OneToOne(optional = false)
    @JoinColumn(name = "app_id")
    @MapsId
    @JsonIgnore
    val app: App? = null

) {
  @Id
  @Column(unique = true, nullable = false, insertable = false)
  @JsonIgnore
  val id: Long? = null

  override fun toString(): String {
    return "AppDescription(id=$id)"
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AppDescription

    if (id != other.id) return false
    if (name != other.name) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + name.hashCode()
    return result
  }
}