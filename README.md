# Proyek Kelompok B8

Selamat datang di repositori Kelompok B8!

## Deskripsi

Proyek ini bertujuan untuk melakukan automation testing pada API dengan tools Rest Arested dan Gradle pada DummyApi.

## Anggota Kelompok

- Helsa Alika Femiani - 211524044
- Novia Nur Azizah - 211524053
- Regi Purnama - 211524057

## Cara Menjalankan Program

Untuk menjalankan program kami, ikuti langkah-langkah di bawah ini:

1. Pastikan Anda telah menginstal Java 21 dan Gradle 8.7
2. Clone repositori ini ke komputer lokal Anda menggunakan perintah `git clone https://github.com/noviazizah/AutomationAPITesting.git`.
3. Buka terminal atau command prompt, lalu pindah ke direktori proyek (`cd AutomationAPITesting`).
4. Jalankan perintah `./gradlew build` untuk build program setelah clone.
5. Setelah berhasil dibuild, jalankan perintah `./gradlew test` untuk mengenerate test script.


## Struktur Folder Project
```
/app
│   /bin
│
├── /build
│   ├── /classes
│   │   ├── /generated
│   │   ├── /reports
│   │   ├── /tests
│   │   │   ├── /test
│   │   │   │   ├── /classes
│   │   │   │   ├── /css
│   │   │   │   ├── /js
│   │   │   │   ├── /package
│   │   │   │   ├── index.html
│   │   │   ├── /test-results
│   │   │   └── /tmp
│   │
│   └── /src
│       ├── /main
│       │   ├── /java
│       │   │   └── /org
│       │   │       └── /example
│       │   │           └── App.java
│       │
│       └── /test
│           ├── /java
│           │   └── /org
│           │       └── /example
│           │           ├── ApiTestCreate.java
│           │           ├── ApiTestDelete.java
│           │           ├── ApiTestGet.java
│           │           └── ApiTestUpdate.java
│           │
│           └── build.gradle
│
└── /gradle
```
- Test script dapat diakses diakses di app/src/test/java/org/example
- Test Report Generated dapat diakses di app/build/tests/test

## Cara Berkontribusi

Kami menyambut kontribusi dari siapa saja! Jika Anda ingin berkontribusi, silakan ikuti langkah-langkah berikut:

1. Fork repositori ini.
2. Buat branch baru untuk fitur Anda (`git checkout -b fitur-baru`).
3. Lakukan perubahan yang diperlukan.
4. Commit perubahan Anda (`git commit -am 'Menambahkan fitur baru'`).
5. Push ke branch Anda (`git push origin fitur-baru`).
6. Buat permintaan tarik (pull request) baru.

