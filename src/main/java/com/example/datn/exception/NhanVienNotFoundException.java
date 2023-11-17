package com.example.datn.exception;

// Định nghĩa một lớp ngoại lệ có tên là NhanVienNotFoundException
public class NhanVienNotFoundException extends Exception {

    // Constructor với tham số là message (thông điệp)
    public NhanVienNotFoundException(String message) {
        // Gọi constructor của lớp cha (Exception) với thông điệp được truyền vào
        super(message);
    }
}
