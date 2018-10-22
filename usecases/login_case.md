### Main Success:

1. User mengInput username dan password di form login
2. Sistem meminta token ke service iPOS AUTH di cloud berdasarkan username dan password
3. Sistem menyimpan token User
4. Sistem mengecek data perusahaan si User
5. Kalau belum ada sistem mendownload data perusahaan ke service attendance logger gateway di cloud
6. Sistem menDisplay Ready State

### Extention / Alternative:
1a: User salah mengInput username dan password

    .1 User mengulang input data login

5a. Gagal download data perusahaan

    .1 Sistem mendisplay Login State

