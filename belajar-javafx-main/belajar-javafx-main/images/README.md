# Folder Images

Folder ini digunakan untuk menyimpan screenshot atau gambar dokumentasi aplikasi.

## Cara Menambahkan Gambar ke README

1. **Simpan gambar di folder ini**

   - Format yang didukung: `.png`, `.jpg`, `.jpeg`, `.gif`
   - Contoh nama file: `screenshot.png`, `dashboard.jpg`, `filter.png`

2. **Tambahkan ke README.md**

   Buka file `README.md` di root project dan uncomment bagian screenshot:

   ```markdown
   ## 🖼️ Screenshot

   ![Screenshot Aplikasi](images/screenshot.png)
   ![Dashboard](images/dashboard.png)
   ![Filter Transaksi](images/filter.png)
   ```

3. **Format Markdown untuk gambar**

   ```markdown
   ![Deskripsi Gambar](images/nama-file.png)
   ```

   - `![Deskripsi Gambar]` = Teks alternatif yang muncul jika gambar tidak bisa dimuat
   - `(images/nama-file.png)` = Path relatif ke file gambar

## Tips

- Gunakan nama file yang deskriptif (contoh: `screenshot-main-window.png`)
- Kompres gambar jika ukurannya terlalu besar untuk performa yang lebih baik
- Format PNG direkomendasikan untuk screenshot
- Format JPG untuk foto dengan ukuran lebih kecil

## Contoh Screenshot yang Bisa Ditambahkan

1. **Screenshot Utama**: Tampilan utama aplikasi dengan semua fitur
2. **Dashboard**: Tampilan ringkasan keuangan
3. **Filter**: Tampilan saat menggunakan filter tanggal
4. **Add Transaction**: Tampilan form tambah transaksi
5. **Edit Transaction**: Tampilan form edit transaksi

