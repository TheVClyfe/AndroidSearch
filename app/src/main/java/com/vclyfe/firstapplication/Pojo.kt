package com.vclyfe.firstapplication

import com.google.gson.annotations.SerializedName

data class Pojo(@SerializedName("name") val name: String, @SerializedName("email") val email: String)