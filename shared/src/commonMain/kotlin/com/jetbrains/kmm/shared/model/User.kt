package com.jetbrains.kmm.shared.model

import kotlinx.serialization.SerialName

data class User(
    @SerialName("limit")
    val limit: Int,
    @SerialName("skip")
    val skip: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("users")
    val users: List<UserX>
)

data class UserX(
    @SerialName("age")
    val age: Long?,
    @SerialName("birthDate")
    val birthDate: String?,
    @SerialName("bloodGroup")
    val bloodGroup: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("gender")
    val gender: String?,
    @SerialName("height")
    val height: String?,
    @SerialName("id")
    val id: Long,
    @SerialName("image")
    val image: String?,
    @SerialName("lastName")
    val lastName: String?,
    @SerialName("phone")
    val phone: String?,
    @SerialName("users")
    val weight: String?
)

data class Address(
    val address: String,
    val city: String,
    val coordinates: Coordinates,
    val postalCode: String,
    val state: String
)

data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)

data class Company(
    val address: Address,
    val department: String,
    val name: String,
    val title: String
)

data class Hair(
    val color: String,
    val type: String
)

data class Coordinates(
    val lat: Double,
    val lng: Double
)