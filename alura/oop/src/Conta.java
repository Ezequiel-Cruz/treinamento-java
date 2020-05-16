public class Conta {
    double saldo;
    int agencia = 0;
    int numero;
    String titular;

    public void deposita(double valor) {
        this.saldo += valor;
    }
}
