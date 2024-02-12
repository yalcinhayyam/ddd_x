package com.test.ddd.repositories

import com.test.ddd.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User?, Long?>
