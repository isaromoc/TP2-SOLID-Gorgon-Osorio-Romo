package org.example.Cuentas;

public class CuentaCorriente extends CuentaBancaria {
    private double sobregiro;

    public CuentaCorriente(String titular, String idCuenta, double saldo, double sobregiro) {
        super(titular, idCuenta, saldo);
        this.sobregiro = sobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (saldo + sobregiro >= monto) {
            saldo -= monto;
            System.out.println("CUENTA CORRIENTE | Retirado: $" + monto);
        } else {
            System.out.println("CUENTA CORRIENTE | Límite excedido.");
        }
    }
}