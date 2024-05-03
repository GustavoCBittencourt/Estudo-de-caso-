package estudoDeCaso2;

import java.util.Scanner;

class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private Cliente cliente;

    public ContaBancaria(String numeroConta, double saldoInicial, Cliente cliente) {
        this.setNumeroConta(numeroConta);
        this.saldo = saldoInicial;
        this.setCliente(cliente);
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

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
        ContaBancaria conta = new ContaBancaria(numeroConta, saldoInicial, cliente);

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
