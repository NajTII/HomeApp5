package com.intuitivehome.app.data
interface LlmService { suspend fun chat(prompt: String): String }
interface DeviceGraphService { suspend fun listDevices(): List<String> }
interface AccessControlService { suspend fun createPass(name: String, method: String): Boolean }
interface CameraService { suspend fun listCameras(): List<String> }