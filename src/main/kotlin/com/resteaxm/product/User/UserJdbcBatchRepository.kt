package com.resteaxm.product.User

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.PreparedStatement

@Repository
class UserJdbcBatchRepository {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun batchInsert1(users: List<User>): IntArray {
        return jdbcTemplate.batchUpdate(
            "insert into user (name) values (?)",
            object: BatchPreparedStatementSetter {
                override fun setValues(ps: PreparedStatement, i: Int) {
                    ps.setString(1, users[i].name)
                }

                override fun getBatchSize() = users.size
            })
    }

    fun batchDelete(users: List<User>): IntArray {
        return jdbcTemplate.batchUpdate(
            "delete from user where id = ?",
            object: BatchPreparedStatementSetter {
                override fun setValues(ps: PreparedStatement, i: Int) {
                    ps.setLong(1, users[i].id!!)
                }
                override fun getBatchSize() = users.size
            })
    }

    fun batchInsert2(users: List<User>) {
        val sql = "insert into user (name) values (?) ".trimIndent()

        val ds = jdbcTemplate.dataSource
        val connection: Connection = ds!!.connection
        connection.autoCommit = false
        val ps = connection.prepareStatement(sql)

        val batchSize: Int = 1000
        var count: Int = 0

        users.forEach { user ->
            ps.setString(1, user.name)
            ps.addBatch()
            count += 1

            if (count % batchSize == 0 || count == users.size) {
                ps.executeBatch()
                ps.clearBatch()
            }
        }
        connection.commit()
        ps.close()
    }

    fun batchDelete(users: MutableList<User>) {
        val sql = " delete from user where id=? ".trimIndent()

        val ds = jdbcTemplate.dataSource
        val connection: Connection = ds!!.connection
        connection.autoCommit = false
        val ps = connection.prepareStatement(sql)

        val batchSize: Int = 1000
        var count: Int = 0

        users.forEach { user ->
            ps.setLong(1, user.id!!)
            ps.addBatch()
            count += 1

            if (count % batchSize == 0 || count == users.size) {
                ps.executeBatch()
                ps.clearBatch()
            }
        }
        connection.commit()
        ps.close()
    }
}