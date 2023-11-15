package com.example.datn.Exception.CustomException;

import com.example.datn.Entity.HoaTiet;

public class HoaTietNotFoundException extends Exception{
    public HoaTietNotFoundException(String message){
        super(message);
    }
}
