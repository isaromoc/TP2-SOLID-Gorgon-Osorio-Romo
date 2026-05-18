package org.example.Repositorios;

import org.example.Cuentas.CuentaBancaria;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCuentas {
    private final List<CuentaBancaria> cuentas;

    public RepositorioCuentas() {
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        this.cuentas.add(cuenta);
    }

    public CuentaBancaria buscarPorDni(String dni) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getIdCuenta().equals(dni))
                .findFirst()
                .orElse(null);
    }
}