package com.intuitivehome.app.data
import kotlinx.coroutines.delay
class MockLlmService: LlmService {
    override suspend fun chat(prompt: String): String { delay(200); return "LLM response to: $prompt" }
}
class MockDeviceGraphService: DeviceGraphService {
    override suspend fun listDevices(): List<String> = listOf("Main Door Lock","Doorbell","Living Lights","Thermostat","Driveway PTZ")
}
class MockAccessControlService: AccessControlService {
    override suspend fun createPass(name: String, method: String): Boolean = true
}
class MockCameraService: CameraService {
    override suspend fun listCameras(): List<String> = listOf("Doorbell","Driveway PTZ","Backyard","Family Room")
}