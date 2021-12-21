package com.example.weatherapplication.framework

import java.io.IOException

class BaseApiException(val text: String? = null) : Exception()

class NoInternetException : IOException()