package com.test.ddd.controllers

//import com.test.ddd.models.A
import com.test.ddd.models.IEntity
import com.test.ddd.models.User
import com.test.ddd.services.UserService
import com.test.ddd.utilities.TypeFinder
import jakarta.persistence.Entity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class IndexController(@Autowired private val userService: UserService) {
    @GetMapping("/hello")
    fun helloWorld(): String {
        return "Hello, World!"
    }

    @GetMapping("/users")
    fun users(): MutableList<User?> {
        return userService.getAll()
    }
    @PostMapping("/users")
    fun create(@RequestBody userInput: UserInput): User {
        return userService.create(userInput.email, userInput.username)
    }

    @GetMapping("/reflect")
    fun reflect(): List<String> {
        val type = TypeFinder.find(IEntity::class.java).first()//.getDeclaredConstructor().newInstance("axc")
        // println(instance.constructors.first().newInstance("dqwd") as IEntity)
        val instance = type.constructors.first().newInstance("dqwd") as IEntity
        println(instance.id)
        // val data = A("as")
        return TypeFinder.find(IEntity::class.java).map { it.simpleName }
    }

    fun test(){
        X().x(
            object : IEntity {
                override val id: String = "exampleId"
                override fun call() {
                    
                }
            }
        )
    }
}

class X {
    fun x(entity: IEntity):String{
        return entity.id;
    }
}


data class UserInput(val email:String, val username: String);

class CC(override val id: String) : IEntity {
    override fun call() {
        TODO("Not yet implemented")
    }
}


interface IService

    class FooService(@Autowired private val repository: JpaRepository<String,String>):IService

