package com.example.demo.repository

import com.example.demo.model.App
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AppRepository : CrudRepository<App, Long>