/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.ModelMahasiswa;
import java.util.List;

/**
 *
 * Interface untuk mengelola operasi CRUD pada mahasiswa
 */
public interface MahasiswaController {
    public void addMhs(ModelMahasiswa mhs); // Menambahkan mahasiswa baru
    public ModelMahasiswa getMhs(int id); // Mendapatkan data mahasiswa berdasarkan ID
    public void updateMhs(ModelMahasiswa mhs); // Memperbarui data mahasiswa
    public void deleteMhs(int id); // Menghapus mahasiswa berdasarkan ID
    public List<ModelMahasiswa> getAllMahasiswa(); // Mendapatkan semua data mahasiswa
    public List<ModelMahasiswa> searchMahasiswa(String keyword); // Mencari mahasiswa berdasarkan kata kunci
}
