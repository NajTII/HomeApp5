# Intuitive Home — Android App (v0.2)

Android-first, AI-native smart home app scaffold (Kotlin + Jetpack Compose + Hilt).  
**This build lets you paste your own API keys *inside the app* (Settings tab).**

## What’s in v0.2
- Tabs: Home, Rooms, Routines, Events, Access, Cameras, Talk, **Settings (with key entry)**.
- DataStore persistence for GPT-5 endpoint/key, WhatsApp token, sample RTSP URL.
- DI (Hilt), Retrofit/Moshi ready, Navigation, Material 3.
- Mock services you can swap for real integrations.

## How to build an APK
1) Open in Android Studio (Giraffe/Koala+).  
2) *Build* → *Build Bundle(s) / APK(s)* → *Build APK(s)*.  
3) Find APK at `app/build/outputs/apk/debug/app-debug.apk` and install on your phone.

## Next steps (when you provide keys)
- Wire GPT-5 chat client: read endpoint/key from DataStore.
- ONVIF/RTSP live tiles: read RTSP URL from Settings and render stream (ExoPlayer).
- WhatsApp/SMS OTP: add provider client using token from Settings.
- Access policies: family/trusted (face+geo), others (time window + owner OTP).
- E2E: add SRTP/TLS settings and secure enclave storage for device keys.