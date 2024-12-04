/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author M
 */
public class ModelTabelMahasiswa extends AbstractTableModel{

    private List<ModelMahasiswa> mahasiswaList;
    private List<ModelMahasiswa> originalMahasiswaList; // Menyimpan data asli mahasiswa untuk kebutuhan pencarian
    private String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};

    public ModelTabelMahasiswa(List<ModelMahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        this.originalMahasiswaList = new ArrayList<>(mahasiswaList); // Simpan daftar asli mahasiswa
    }

    @Override
    public int getRowCount() {
        return mahasiswaList.size(); // Jumlah baris sesuai dengan jumlah data mahasiswa
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelMahasiswa mahasiswa = mahasiswaList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNpm();
            case 2:
                return mahasiswa.getNama();
            case 3:
                return mahasiswa.getSemester();
            case 4:
                return mahasiswa.getIpk();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        this.originalMahasiswaList = new ArrayList<>(mahasiswaList); // Update daftar asli saat data diperbarui
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }

    // Metode pencarian mahasiswa berdasarkan keyword (contoh: nama atau NPM)
    public void searchMahasiswa(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            // Jika keyword kosong, tampilkan data asli
            mahasiswaList = new ArrayList<>(originalMahasiswaList);
        } else {
            List<ModelMahasiswa> filteredList = new ArrayList<>();
            for (ModelMahasiswa mahasiswa : originalMahasiswaList) {
                if (mahasiswa.getNama().toLowerCase().contains(keyword.toLowerCase()) ||
                    mahasiswa.getNpm().toLowerCase().contains(keyword.toLowerCase())) {
                    filteredList.add(mahasiswa);
                }
            }
            mahasiswaList = filteredList;
        }
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}
