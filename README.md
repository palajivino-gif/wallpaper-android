<div align="center">

# 🎨 Wallora — Premium Wallpaper App for Android

### A production-ready, ad-monetized wallpaper app in Kotlin. Free to download, yours to publish.

Ship your own wallpaper app on Google Play in an afternoon — glassmorphic dark UI, one-tap
wallpaper setting, favorites, and **AdMob banners + interstitials already wired in**.

[![Platform](https://img.shields.io/badge/platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![minSdk](https://img.shields.io/badge/minSdk-24-10B981?style=for-the-badge)](https://developer.android.com)
[![AdMob](https://img.shields.io/badge/AdMob-Ready-EA4335?style=for-the-badge&logo=googleads&logoColor=white)](https://admob.google.com)
[![License](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)](LICENSE)

**No backend. No API keys. No monthly bills.** Every image is a local drawable, so the app
works fully offline — and costs you nothing to run.

</div>

---

<div align="center">

### 🎓 Want to build apps like this yourself — with AI?

**[androai.io](https://androai.io)** runs a **free 2-hour webinar** on developing Android apps
using AI: from idea to a published, ad-monetized app — no prior Android experience needed.

[![Join the free webinar](https://img.shields.io/badge/Join%20the%20FREE%202--hour%20webinar-androai.io-10B981?style=for-the-badge&logo=googlechrome&logoColor=white)](https://androai.io)

*This app is exactly the kind of project you'll learn to build and ship.*

</div>

---

## ✨ Why this project

Most wallpaper templates are either bare-bones demos or paid CodeCanyon downloads. Wallora is
neither: it's a complete, good-looking app you can **clone, rebrand, and monetize today**.

| | |
|---|---|
| 🖤 **Premium dark UI** | Glassmorphic cards, emerald accents, gradient scrims — designed for AMOLED |
| 💰 **Monetization built in** | Adaptive banner on Home + interstitial on every 3rd wallpaper open |
| ⚡ **Zero running cost** | Local drawables, no server, no image API, no rate limits |
| ❤️ **Favorites that persist** | SharedPreferences-backed, survives restarts |
| 🔎 **Search + categories** | Live title search and 6 mood-based category chips |
| 📥 **Set · Save · Share** | One-tap actions with scoped-storage support (Android 10+) |
| 🧱 **Clean architecture** | MVVM, ViewModel + LiveData, ViewBinding, single-source repository |
| 🚀 **Modern toolchain** | AGP 9, Kotlin 2.2, targetSdk 36, Gradle version catalog |

---

## 📱 Screens

| Home | Detail | Favorites | Settings |
|:---:|:---:|:---:|:---:|
| Hero header, search bar, category chips, staggered wallpaper grid, banner ad | Full-bleed preview with Set / Save / Share actions and a favorite toggle | Everything you hearted, in one grid, with an empty state | Version, Share App, Rate App, Privacy Policy |

> 💡 Drop your own PNGs into `docs/screenshots/` and link them here before you publish — a
> screenshot row is the single biggest install-rate lever on the Play Store listing.

---

## 🚀 Quick start

```bash
git clone https://github.com/<your-username>/wallpaper-android.git
cd wallpaper-android
./gradlew assembleDebug        # Windows: gradlew.bat assembleDebug
```

Or just open the folder in **Android Studio** (Ladybug or newer) and press ▶️ Run.

Requirements: **JDK 11+**, Android Studio with **SDK 36**, a device or emulator on **API 24+**.

It builds and runs out of the box with Google's official AdMob **test** ad units — no account
needed to try it.

---

## 💰 Make money with it (3 steps)

The whole monetization layer lives in one file: [`ads/AdsConfig.kt`](app/src/main/java/com/demo/wallpaper/ads/AdsConfig.kt).

**1 — Create an AdMob account** at [admob.google.com](https://admob.google.com), add your app,
and create one **Banner** and one **Interstitial** ad unit.

**2 — Swap the test IDs for your real ones:**

```kotlin
// app/src/main/java/com/demo/wallpaper/ads/AdsConfig.kt
object AdsConfig {
    const val APP_ID                  = "ca-app-pub-XXXXXXXX~XXXXXXXX"
    const val HOME_BANNER_AD_UNIT_ID  = "ca-app-pub-XXXXXXXX/XXXXXXXX"
    const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-XXXXXXXX/XXXXXXXX"
}
```

**3 — Update the app id in `strings.xml`** (the manifest reads it from there):

```xml
<string name="admob_app_id">ca-app-pub-XXXXXXXX~XXXXXXXX</string>
```

That's it. Ship it.

<details>
<summary><b>How the ads behave (and how to tune them)</b></summary>

- **Banner** — an *adaptive* anchored banner sized to the device width, loaded on the Home
  screen and destroyed with the fragment. See [`BannerAdController.kt`](app/src/main/java/com/demo/wallpaper/ads/BannerAdController.kt).
- **Interstitial** — preloaded in the background and shown on **every 3rd wallpaper open**,
  then immediately preloaded again. See [`InterstitialAdController.kt`](app/src/main/java/com/demo/wallpaper/ads/InterstitialAdController.kt).

Want ads more or less often? Change the modulo in `InterstitialAdController.maybeShow()`:

```kotlin
if (ad == null || openCount % 3 != 0) { ... }   // 3 → every 3rd open
```

⚠️ **Never test with your real ad unit IDs** — clicking your own live ads gets AdMob accounts
banned. Keep the test IDs during development and register your device as a test device.

</details>

---

## 🎨 Make it yours

<details open>
<summary><b>Swap the wallpapers</b></summary>

Replace `app/src/main/res/drawable/wallpaper_1.png` … `wallpaper_12.png` with your own images
(same filenames = zero code changes), or edit the catalog directly:

```kotlin
// data/WallpaperRepository.kt
Wallpaper("w13", "Midnight Sky", Categories.PREMIUM, R.drawable.your_image)
```

Titles feed the search, and the category drives the chip filter — that's all a wallpaper needs.
</details>

<details>
<summary><b>Rebrand it</b></summary>

| What | Where |
|---|---|
| App name & copy | `res/values/strings.xml` |
| Colors & accent | `res/values/colors.xml` (`accent_emerald*` is the theme accent) |
| Theme | `res/values/themes.xml` |
| Package / app id | `namespace` + `applicationId` in `app/build.gradle.kts` |
| Launcher icon | `res/mipmap-*` |
| Privacy policy URL | `privacy_policy_url` in `strings.xml` — **required by Play** |

</details>

<details>
<summary><b>Add or rename categories</b></summary>

Edit `Categories` in [`model/Wallpaper.kt`](app/src/main/java/com/demo/wallpaper/model/Wallpaper.kt) —
`ALL_ORDERED` is exactly what the chip bar renders, in that order.
</details>

---

## 🧱 Architecture

Plain MVVM, no DI framework, nothing to learn before you can edit it.

```
com.demo.wallpaper
├── WalloraApp.kt              Application — initializes the Mobile Ads SDK off the main thread
├── model/     Wallpaper, WallpaperUi, Categories
├── data/      WallpaperRepository (the catalog) · FavoriteManager (SharedPreferences)
├── viewmodel/ WallpaperViewModel — search + category + favorites → derived LiveData lists
├── adapter/   WallpaperAdapter (RecyclerView grid)
├── ui/        MainActivity · home/ · favorites/ · settings/ · WallpaperDetailActivity
├── util/      WallpaperActions — set / save-to-gallery / share
└── ads/       AdsConfig · BannerAdController · InterstitialAdController
```

`WallpaperViewModel` is shared across the Home and Favorites fragments via a `MediatorLiveData`
pipeline: change the query, the category, or a favorite, and both grids recompute themselves.

**Permissions:** `SET_WALLPAPER`, `INTERNET` (ads), and `WRITE_EXTERNAL_STORAGE` capped at
API 28 — Android 10+ saves through MediaStore with no permission prompt at all.

---

## 📋 Before you publish on Google Play

- [ ] Replace all AdMob test IDs with real ones (`AdsConfig.kt` **and** `strings.xml`)
- [ ] Change `applicationId` to your own unique package name
- [ ] Use images you have the rights to — **the placeholder wallpapers are for demo only**
- [ ] Host a real privacy policy and point `privacy_policy_url` at it
- [ ] Enable `isMinifyEnabled = true` for the release build
- [ ] Sign the release build and complete the Play Data Safety form (declare AdMob)

---

## 🗺️ Roadmap ideas

Good first contributions, and good ways to make the app earn more:

- Rewarded ads to unlock a "Premium" category
- Live/scrolling wallpaper service
- Remote catalog (Firebase / Unsplash) with Coil or Glide
- Download counters and a "Most popular" sort
- Light theme + dynamic Material You colors

---

## 🤝 Contributing

PRs are welcome — fork it, branch it, send it. Bug reports and feature ideas go in
[Issues](../../issues).

## 🎓 Learn to build apps like this with AI

This source code is free. So is the training.

**[androai.io](https://androai.io)** hosts a **2-hour live webinar** that walks you through
building Android apps with AI — designing the UI, writing the Kotlin, wiring up AdMob, and
publishing to the Play Store. Bring an idea, leave with an app.

👉 **[Reserve your free seat at androai.io](https://androai.io)**

## ⭐ Support

If this saved you a weekend of work, **star the repo** — it's free, and it's the only thing
this project asks for in return.

## 📄 License

[MIT](LICENSE) — free for personal **and commercial** use. Build it, brand it, publish it,
keep 100% of the ad revenue. Attribution appreciated, not required.

The placeholder wallpaper images are demo assets: **replace them with your own before you
publish.**

<div align="center">

**Made with 💚 for Android developers who want to ship.**

[Free 2-hour AI + Android webinar → androai.io](https://androai.io)

</div>
