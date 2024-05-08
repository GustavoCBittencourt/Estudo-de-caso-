import java.util.Scanner;

class Conta {
    protected String numeroConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(String numeroConta, double saldoInicial, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo disponível: " + saldo);
    }
}

class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double saldoInicial, Cliente cliente, double limiteChequeEspecial) {
        super(numeroConta, saldoInicial, cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, double saldoInicial, Cliente cliente, double taxaRendimento) {
        super(numeroConta, saldoInicial, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public void calcularRendimento() {
        saldo += saldo * taxaRendimento;
        System.out.println("Rendimento aplicado com sucesso.");
    }
}

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema Bancário");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();
        ContaCorrente conta = new ContaCorrente(numeroConta, saldoInicial, cliente, 500); // Definindo um limite de cheque especial de 500

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirSaldo();
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nosso sistema bancário. Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
