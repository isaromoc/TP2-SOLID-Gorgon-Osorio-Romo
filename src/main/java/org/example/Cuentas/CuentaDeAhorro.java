package org.example.Cuentas;

public class CuentaDeAhorro extends CuentaBancaria {
    public CuentaDeAhorro(String titular, String idCuenta, double saldo) {
        super(titular, idCuenta, saldo);
    }

    @Override
    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("CAJA DE AHORRO | Retirado: $" + monto);
        } else {
            System.out.println("CAJA DE AHORRO | Saldo insuficiente.");
        }
    }
}
