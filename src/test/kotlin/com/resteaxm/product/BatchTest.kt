package com.resteaxm.product

import com.resteaxm.product.User.User
import com.resteaxm.product.User.UserJdbcBatchRepository
import com.resteaxm.product.User.UserRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(value = [SpringExtension::class])
@SpringBootTest
class BatchTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userJdbcBatchRepository: UserJdbcBatchRepository

//    @BeforeEach
//    fun setUpMock() {
//        val users: MutableList<User> = mutableListOf();
//        for (i in 1..100000) {
//            users.add(
//                User(
//                    name = i.toString(),
//                    tag = "A"
//                )
//            )
//        }
//        userJdbcBatchRepository.batchInsert(users)
//    }

//    @Test
//    @DisplayName("no batch delete")
//    fun batchDeleteTest1() {
//        val findUsers: List<User> = userRepository.findByTag("A")
//        findUsers.forEach { user ->
//            userRepository.delete(user)
//        }
//    }
//
//    @Test
//    @DisplayName("batch delete1")
//    fun batchDeleteTest2() {
//        val findUsers: List<User> = userRepository.findByTag("A")
//        userRepository.deleteAll(findUsers)
//    }
//
//    @Test
//    @DisplayName("batch delete2")
//    fun batchDeleteTest3() {
//        val findUsers: List<User> = userRepository.findByTag("A")
//        userJdbcBatchRepository.batchDelete(findUsers as MutableList<User>)
//    }

    @Test
    @DisplayName("save 테스트")
    fun noBatchInsertTest1() {
        val users: MutableList<User> = mutableListOf();
        for (i in 1..10000) {
            userRepository.save(User(name = i.toString()))
        }
    }

    @Test
    @DisplayName("savaAll 테스트")
    fun noBatchInsertTest2() {
        val users: MutableList<User> = mutableListOf();
        for (i in 1..3) {
            users.add(User(name = i.toString()))
        }
        userRepository.saveAll(users)
    }


    @Test
    @DisplayName("batchUpdate()를 사용한 batch insert 테스트")
    fun batchInsertTest1() {
        val users: MutableList<User> = mutableListOf();
        for (i in 1..10) {
            users.add(User(name = i.toString()))
        }
        userJdbcBatchRepository.batchInsert1(users)
    }

    @Test
    @DisplayName("batchUpdate()를 사용하지 않은 batch insert 테스트")
    fun batchInsertTest2() {
        val users: MutableList<User> = mutableListOf();
        for (i in 1..10000) {
            users.add(User(name = i.toString()))
        }
        userJdbcBatchRepository.batchInsert2(users)
    }
}