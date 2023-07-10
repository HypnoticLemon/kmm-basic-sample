package com.jetbrains.kmm.shared.cache

import com.jetbrains.kmm.shared.model.User
import com.jetbrains.kmm.shared.model.UserX

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllUser()
        }
    }

    internal fun createUser(userList: User) {
        dbQuery.transaction {
            userList.users.forEach { user ->
                insertUser(user)
            }
        }
    }

    private fun insertUser(user: UserX) {
        dbQuery.insertUser(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            age = user.age,
            gender = user.gender,
            email = user.email,
            phone = user.phone,
            birthDate = user.birthDate,
            image = user.image,
            bloodGroup = user.bloodGroup,
            height = user.height,
            weight = user.weight,
        )
    }

    internal fun getAllUser(): List<UserX> {
        return dbQuery.selectAllUserInfo(::mapUserSelecting).executeAsList()
    }

    private fun mapUserSelecting(
        id: Long,
        firstName: String,
        lastName: String?,
        age: Long?,
        gender: String?,
        email: String?,
        phone: String?,
        birthDate: String?,
        image: String?,
        bloodGroup: String?,
        height: String?,
        weight: String?,
    ): UserX {
        return UserX(
            id = id,
            firstName = firstName,
            lastName = lastName,
            age = age,
            gender = gender,
            email = email,
            phone = phone,
            birthDate = birthDate,
            image = image,
            bloodGroup = bloodGroup,
            height = height,
            weight = weight
        )
    }
}