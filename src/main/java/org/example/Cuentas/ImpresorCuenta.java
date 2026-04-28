package org.example.Cuentas;

public class ImpresorCuenta {
    public void imprimirDetallesCuenta(CuentaBancaria cuenta) {

        System.out.println("Titular de la cuenta: " + cuenta.getTitular());
        System.out.println("ID de la cuenta: " + cuenta.getIdCuenta());
        System.out.println("Saldo actual: $" + cuenta.getSaldo());
    }
}
