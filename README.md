# Desafio Banco

Desafio do Bootcamp Santander 2024 - Backend com Java da [DIO](https://www.dio.me/en).


#### Autora:
[Beatriz Miranda Aguiar](https://github.com/BeatrizMirandaAguiar)

## Estrutura do projeto

O projeto conta com 3 pacotes, onde:

- `cartao` : contém 4 classes
   Cartao: classe pai
   Credito: classe filha com o extra do double de limite
   Debito: classe filha com todas funcionalidades herdadas
   Multiplo: classe filha com métodos similares à classe Credito
- `conta` : contém 4 classes
   Conta: classe pai com métodos mais genéricos
   ContaCorrente: classe filha com o diferencial do limite nas operações de saque e de transferência
   ContaPoupança: classe filha que aplica todas as funcionalidades da classe pai, mas usa apenas o valor do saldo (não possui limite)
   ContaSalario: classe filha cujas operações restringem-se à saque e extrato, apenas
- `user` : contém 1 classe
   Cliente: classe que possui as informações pessoais dos clientes do banco
- `defaut` : contém 2 classes
   Banco: classe que métodos como abertura de conta e outros auxiliares
   Main: classe que corre o teste

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
