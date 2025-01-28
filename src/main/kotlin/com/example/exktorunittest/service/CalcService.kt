package com.example.exktorunittest.service

import org.springframework.stereotype.Service

@Service
class CalcService {
    fun add(a: Long, b: Long): Long {
        return a + b
    }
}