# A11-final-project-testing

Repository ini bertujuan untuk melakukan pengujian terhadap website Swag Labs https://www.saucedemo.com/ dan API pada website DummyAPI https://dummyapi.io/

## Build With
Automation Testing pada project ini menggunakan library berikut:
 <ul>
    <li>JUnit</li>
    <li>Cucumber</li>
    <li>Selenium</li>
    <li>WebDriverManager</li>
    <li>RestAssured</li>
 </ul>
 
# Getting Started
## Pre-requisites
Sebelum menjalankan project ini, perlu disiapkan environment yang sesuai.
<ul>
  <li>Java 17+</li>
  <li>Apache Maven 3.8.0+</li>
  <li>Web Browser</li>
</ul>

## Struture Project Test
Berikut ini merupakan struktur project beserta penjelasannya
```
{nama_proyek}
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───automation
│   │               └───test
│   └───test
│       ├───java
│       │   ├───helper
│       │   ├───Model
│       │   │   ├───apitesting
│       │   │   └───webtesting
│       │   ├───runner
│       │   ├───stepdefinitions
│       │   │   ├───apitesting
│       │   │   └───webtesting
│       │   └───testlogic
│       │       ├───apitesting
│       │       │   └───request
│       │       └───webtesting
│       └───resources
│           ├───features
│           └───JSONSchemaData
└───testreport
```
<ul>
 <li>package helper berisi property supporting project yaitu untuk inisiasi web driver untuk menjalankan browser.</li>
 <li>package model berisi struktur objek yang digunakan dan dipisahkan antara model apitesting dan webtesting</li>
 <li>package runner digunakan untuk menjalankan automation testing</li>
 <li>package steps berisi step definitions yang akan dijalankan dari scenario pengujian yang didefinisikan pada .feature</li>
 <li>package testlogic berisi konfigurasi untuk menjalankan test dengan cucumber.</li>
 <li>package resources berisi feature-feature yang merupakan scenario pengujian yang akan dilakukan.</li>
 <li>pacakge JSONSchemaData berisi objek json untuk User</li>
 <li>packagae testreport berisi generated test report dari test yang dijalankan.</li>
</ul>

## Run Automation Test
1. Clone repository dengan git
   ```
   git clone https://github.com/salsabilamp3/A11-final-project-testing.git
   ```
2. Jalankan perintah berikut untuk menginstall artifak yang didefinisikan
   ```
   mvn clean install
   ```
3. Jalankan perintah berikut pada terminal untuk menjalankan semua test
   ```
   mvn test
   ```
   Untuk menjalankan test berdasarkan nama scenario dapat menjalankan perintah berikut. (Pastikan menjalankan perintah dengan command prompt)
   ```
   mvn test -Dcucumber.filter.name="namaScenario"
   ```
   Untuk menjalankan test berdasarkan tags dapat menjalankan perintah berikut. (Pastikan menjalankan perintah dengan command prompt)
   ```
   mvn test -Dcucumber.filter.tags="namaTag"
   ```

## Test Cases
Pembuatan test case meliputi test web (menu, end to end) dan api

### A. Web Testing

#### Login
```
1. Pemeriksaan login berhasil dengan menggunakan kredensial yang valid.
2. Pemeriksaan login gagal dengan menggunakan username yang tidak terdaftar di database.
3. Pemeriksaan login gagal dengan tidak mengisikan password.
```

#### Menu
```
1. Pemeriksaan menampilkan menu
2. Pemeriksaan menutup menu
3. Pemeriksaan menekan logout
```

#### Dashboard
```
1. Pemeriksaan menambahkan produk saat cart kosong
2. Pemeriksaan menambahkan produk saat ada satu produk ditambahkan ke cart
3. Pemeriksaan menambahkan produk saat ada lebih dari satu produk di cart
```

#### Detail Produk
```
1. Pemeriksaan detail produk dengan menekan gambar produk
2. Pemeriksaan detail produk dengan menekan nama produk
3. Pemeriksaan menambahkan produk pada halaman detail produk
```

#### Cart
```
1. Pemeriksaan menampilkan cart yang kosong
2. Pemeriksaan menampilkan cart yang berisi minimal 1 item
3. Pemeriksaan melanjutkan checkout saat cart kosong
```

#### Checkout
```
1. Pemeriksaan cancel checkout tanpa mengisi form
2. Pemeriksaan continue checkout tanpa mengisikan form dengan data yang valid
3. Pemeriksaan continue checkout dengan mengisikan form dengan data yang valid
```

#### End To End Testing
```
1. Melakukan checkout produk
```

### B. API Testing

#### Create
```
1. Pemeriksaan menambah user tanpa menambah app-id
2. Pemeriksaan menambah user dengan data yang valid
3. Pemeriksaan menambah user dengan email yang sudah terdaftar
4. Pemeriksaan menambah user tanpa mengisikan firstName
5. Pemeriksaan menambah user dengan invalid length firstName
```

#### Delete
```
1. Pemeriksaan delete user tanpa menambahkan app-id
2. Pemeriksaan delete user dengan app-id yang salah
3. Pemeriksaan delete dengan id yang valid namun sudah terhapus
4. Pemeriksaan delete dengan format id yang salah
5. Pemeriksaan delete tanpa menambahkan id pada parameter
```

#### Update
```
1. Pemeriksaan update dengan semua field valid
2. Pemeriksaan update dengan title yang valid
3. Pemeriksaan update gender user dengan ""
4. Pemeriksaan update user email
5. Pemeriksaan update user title yang tidak ada id nya
```

#### Get
```
1. Pemeriksaan get user tanpa menambahkan app-id
2. Pemeriksaan get user dengan app-id yang salah
3. Pemeriksaan get user dengan id yang terdaftar
4. Pemeriksaan get user dengan id yang tidak terdaftar
5. Pemeriksaan get user dengan format id yang tidak sesuai
```

## Author
[Amelia Dewi Agustiani](https://github.com/ameliadewi19) (211524002)

[Salsabila Maharani Putri](https://github.com/salsabilamp3) (211524026)

[Raka Mahardika Maulana](https://github.com/Rakamhrdka17) (211524056)

_Mahasiswa D4 Teknik Informatika Politeknik Negeri Bandung_
