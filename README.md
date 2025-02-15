# Sistema de Consertos de Carros em uma Oficina Mecânica 🚗🔧

## Sobre o Projeto 📚✨
Este projeto foi desenvolvido como parte do Trabalho Prático em Grupo da disciplina **Linguagem de Programação I**, ministrada pela professora **Aline Silva Costa** no curso de Sistemas de Informação do Instituto Federal de Educação Ciência e Tecnologia da Bahia - IFBA.

O objetivo é implementar um programa em **Java** com base no paradigma de **Programação Orientada a Objetos (POO)** que gerencie ordens de serviço, clientes e veículos de uma oficina mecânica. O sistema conta com funcionalidades como:
- Cadastro de clientes;
- Cadastro de veículos;
- Criação de ordens de serviço;
- Atualização do status das ordens de serviço (ABERTA, EM_ANDAMENTO, CONCLUIDA);
- Registro de valores de peças e mão-de-obra;
- Visualização de dados cadastrados.

O programa utiliza **listas** como estrutura de dados para armazenar os clientes, veículos e ordens de serviço.

## Estrutura do Projeto 🛠️📂
O projeto segue a estrutura descrita no diagrama fornecido no enunciado e possui os seguintes componentes principais:

- **Classes Entidade:**
  - Cliente
  - Veiculo
  - OrdemDeServico

- **Enumerações:**
  - StatusOrdemDeServico (ABERTA, EM_ANDAMENTO, CONCLUIDA)

- **Classes de Controle:**
  - Controle (realiza operações sobre os dados e gerencia as listas)

- **Interface com o Usuário:**
  - Classe Main (fronteira para interação com o usuário por meio de um menu no console)

## Como Baixar e Rodar o Projeto 📥🚀
Siga os passos abaixo para clonar o repositório, compilar e executar o programa.

### 1. Requisitos Prévios ✅
- **Java JDK 17 ou superior** instalado no seu computador.
- Um **IDE** (como IntelliJ IDEA, Eclipse, ou VS Code) ou um terminal com suporte para comandos `javac` e `java`.

### 2. Clonar o Repositório 🌐⬇️
Baixe o projeto para o seu computador:

```bash
# Clonar o repositório via Git
git clone https://github.com/seu-usuario/seu-repositorio.git

# Navegar para a pasta do projeto
cd sistema-oficina
```

Caso prefira, você também pode fazer o download do projeto como arquivo ZIP diretamente do repositório.

### 3. Compilar o Projeto 🖥️✔️
No terminal, compile os arquivos Java presentes na pasta `src`:

```bash
javac src/*.java -d bin
```
Isso irá compilar os arquivos e gerar os arquivos `.class` na pasta `bin`.

### 4. Executar o Programa ▶️⚙️
Rode o programa principal usando o comando abaixo:

```bash
java -cp bin Main
```

### 5. Utilizar o Sistema 🛠️📋
Após executar o programa, um menu com as opções do sistema será exibido no console. Basta seguir as instruções para utilizar as funcionalidades.

### Observação 📝❗
Para sair do programa, digite a opção `0` no menu principal.

## Funcionalidades 📋⚙️
O sistema oferece as seguintes funcionalidades por meio do menu:
1. Cadastrar Cliente
2. Cadastrar Veículo
3. Criar Ordem de Serviço
4. Atualizar Status de Ordem de Serviço
5. Registrar Valores de Peças e Mão-de-Obra
6. Visualizar Dados Cadastrados (Clientes, Veículos, Ordens de Serviço)
0. Sair

## Tecnologias Utilizadas 💻📚
- **Linguagem de programação:** Java
- **Estruturas de dados:** Listas (ArrayList)
- **Paradigma:** Programação Orientada a Objetos (POO)

## Contribuição 🤝🌟
Contribuições para melhorias são bem-vindas! Caso encontre bugs ou tenha sugestões, fique à vontade para abrir uma *issue* ou enviar um *pull request* no repositório.

---

**Autores:** 

- Gabryelle Duarte
  - GitHub: 
  - Linkedin: https://www.linkedin.com/in/gabryelleduartem/

- Hellen Santos
  - GitHub: https://github.com/sunHelen12
  - Linkedin: https://www.linkedin.com/in/helen-santos-dev/

- Maria Eduarda
  - GitHub: https://github.com/Mescxll
  - Linkedin: https://www.linkedin.com/in/maria-eduarda-santos-campos-dev/

- Thiago Ferreira
  - GitHub: https://github.com/thiagofrdev
  - Linkedin: https://www.linkedin.com/in/thiagoferreiraribeiro/

**Instituição:** Instituto Federal de Educação Ciência e Tecnologia da Bahia (IFBA) - Campus Vitória da Conquista
