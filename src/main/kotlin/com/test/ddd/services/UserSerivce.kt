package com.test.ddd.services

import com.test.ddd.models.User
import com.test.ddd.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService(@Autowired private val userRepository: UserRepository) {
    //    @AutowiredÏ
    //    private val userRepository: UserRepository? = null

    fun getAll(): MutableList<User?> {
        return userRepository.findAll()
    }

    @Transactional
    fun create(email: String, username: String): User {
        val user = User(email = email, username = username)
        return userRepository.save(user)
    }
}
