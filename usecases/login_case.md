### Main Success:

1. User mengInput username dan password di form login
2. Sistem meminta token ke service iPOS AUTH di cloud berdasarkan username dan password
3. Sistem menyimpan token User
4. Sistem mengecek data perusahaan si User
5. Sistem menDisplay Ready State

### Extention / Alternative:
2a: Token tidak di dapat

    .1 Sistem menDisplay error
    .2 Sistem menDisplay login form

4a: Data perusahaan tidak ada.

    .1 sistem mendownload data perusahaan ke service attendance logger gateway di cloud

4a.1a: Data tidak di temukan.

    .1 Sistem mendisplay login form

