package com.bci.gestionusuarios.util;

public class Validation {
    public static boolean isEmailValid(String email) {
        // Debe seguir el formato aaaaaaa@undominio.algo
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return email.matches(emailRegex);
    }

    public static boolean isPasswordValid(String password) {
        // Debe tener una mayúscula y dos números, longitud entre 8 y 12
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9].*[0-9]).{8,12}$";
        return password.matches(passwordRegex);
    }
}
