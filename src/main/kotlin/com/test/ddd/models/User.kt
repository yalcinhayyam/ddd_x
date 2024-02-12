package com.test.ddd.models

import jakarta.persistence.*

@Entity
@Table(name = "\"user\"") // Use double quotes to specify the table name
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val email: String,

    val username: String
)

interface IEntity {
    val id:String
    fun call()
}

class A(override val id: String) : IEntity
class B(override val id: String) : IEntity

