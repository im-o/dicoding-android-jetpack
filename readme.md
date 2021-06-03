# Submission 1 : Architecture Component.  

## Kriteria Submission
### Daftar film
- Terdapat 2 (dua) halaman yang menampilkan daftar film (Movies dan TV Show) dengan jumlah minimal 10 item.
- Menerapkan ViewModel untuk menampung data Movies dan TV Show.

### Detail film
- Menampilkan poster dan informasi film pada halaman detail film.
- Menerapkan ViewModel untuk menampung detail film.

### Unit Test
- Menerapkan unit test pada semua fungsi yang digunakan untuk mendapatkan data Movie dan TV Show.

### Instrumentation Test
- Menerapkan instrumentation test untuk memastikan fitur-fitur yang ada berjalan dengan semestinya.
- Tuliskan skenario instrumentation test pada kolom Catatan atau berkas tersendiri (jangan lupa sampaikan juga di kolom Catatan agar reviewer dapat mengetahuinya) ketika Anda ingin mengumpulkan tugas ini.

Source : [Dicoding ID](https://www.dicoding.com/academies/129/tutorials/4495). 

## Berikut skenario instrumentation test :

### Menampilkan data Movie
- Memastikan RecyclerView untuk movieListRV dalam keadaan tampil.
- Gulir movieListRV ke posisi data terakhir.

### Menampilkan data detail Movie
- Memastikan RecyclerView untuk movieListRV dalam keadaan tampil.
- Memberi tindakan klik pada data pertama di movieListRV.
- Memastikan TextView untuk titleTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk descriptionTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk movieRateTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk infoGenreTV tampil dan sesuai dengan yang diharapkan.

### Menampilkan data Tv Show
- Klik TabLayout dengan teks Tv Show
- Memastikan RecyclerView untuk tvShowListRV dalam keadaan tampil.
- Gulir tvShowListRV ke posisi data terakhir.

### Menampilkan data detail Tv Show
- Klik TabLayout dengan teks Tv Show
- Memastikan RecyclerView untuk tvShowListRV dalam keadaan tampil.
- Memberi tindakan klik pada data pertama di tvShowListRV.
- Memastikan TextView untuk titleTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk descriptionTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk movieRateTV tampil dan sesuai dengan yang diharapkan.
- Memastikan TextView untuk infoGenreTV tampil dan sesuai dengan yang diharapkan.
