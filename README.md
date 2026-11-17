# Cálculo de Área e Perímetro de um Triângulo — Programação Orientada a Eventos

## 1. Sobre o projeto

Este projeto apresenta uma implementação em Java para calcular a área e o perímetro de um triângulo, utilizando conceitos do **paradigma de programação orientada a eventos**.

O programa apresenta uma interface gráfica que permite ao usuário informar os três lados de um triângulo e realizar os cálculos por meio de um botão.

Diferentemente de uma implementação baseada exclusivamente em uma sequência de instruções, nesta abordagem a execução das operações é determinada pela ocorrência de eventos, como o clique do usuário no botão "Calcular".

O objetivo é demonstrar como um programa pode responder às ações realizadas pelo usuário, utilizando componentes gráficos, eventos e mecanismos de tratamento de exceções.

## 2. Paradigma de programação orientada a eventos

A programação orientada a eventos é um paradigma no qual o fluxo de execução do programa é determinado pela ocorrência de eventos.

Um evento representa uma ação ou acontecimento que pode ser identificado e tratado pelo sistema, como:

- Clique em um botão.
- Digitação em um campo de texto.
- Seleção de uma opção.
- Movimento do mouse.
- Pressionamento de uma tecla.

Nesse paradigma, o programa permanece preparado para identificar e responder aos eventos gerados pelo usuário ou pelo próprio sistema.

Em Java, a programação orientada a eventos pode ser implementada por meio da biblioteca Swing, que disponibiliza componentes gráficos e mecanismos para tratamento de eventos.

Entre seus principais conceitos estão:

- **Evento:** representa uma ação ou acontecimento que ocorre durante a execução do programa.
- **Listener:** mecanismo responsável por escutar e identificar a ocorrência de determinados eventos.
- **Event Handler:** trecho de código responsável por executar uma ação quando um evento acontece.
- **Componentes gráficos:** elementos da interface utilizados para interação com o usuário.
- **Callback:** função ou trecho de código executado em resposta a um evento.

Neste projeto, o evento principal é o clique no botão "Calcular". Quando o usuário realiza essa ação, o programa captura os valores informados, verifica a validade do triângulo e apresenta os resultados na interface gráfica.

## 3. Funcionalidades

O programa realiza as seguintes operações:

1. Apresenta uma janela gráfica para interação com o usuário.
2. Disponibiliza três campos de texto para informar os lados do triângulo.
3. Disponibiliza um botão para iniciar os cálculos.
4. Captura o evento de clique no botão.
5. Obtém os valores informados nos campos de texto.
6. Verifica se os lados atendem às condições de existência de um triângulo.
7. Calcula o perímetro e a área utilizando a fórmula de Heron.
8. Apresenta os resultados na própria interface gráfica.
9. Identifica entradas inválidas e apresenta uma mensagem de erro.

## 4. Regras matemáticas utilizadas

### 4.1. Condição de existência de um triângulo

Para que três segmentos formem um triângulo, é necessário que:

- `a > 0`, `b > 0` e `c > 0`;
- `a < b + c`;
- `b < a + c`;
- `c < a + b`.

Se todas essas condições forem satisfeitas, o triângulo é considerado válido.

### 4.2. Cálculo do perímetro

O perímetro corresponde à soma dos três lados:

`P = a + b + c`

### 4.3. Cálculo da área — Fórmula de Heron

Primeiramente, calcula-se o semiperímetro:

`s = (a + b + c) / 2`

Em seguida, aplica-se a fórmula de Heron:

`A = √[s × (s - a) × (s - b) × (s - c)]`

## 5. Tecnologias utilizadas

- **Linguagem:** Java.
- **Gerenciamento e construção:** Apache Maven.
- **Interface gráfica:** biblioteca Java Swing.
- **Janela principal:** classe `JFrame`.
- **Campos de entrada:** classe `JTextField`.
- **Botão de ação:** classe `JButton`.
- **Exibição de informações:** classe `JLabel`.
- **Organização dos componentes:** classe `JPanel` e `GridLayout`.
- **Tratamento de eventos:** `ActionListener`.
- **Tratamento de exceções:** `NumberFormatException`.
- **Cálculos matemáticos:** classe `Math`.

## 6. Estrutura do projeto

O projeto segue a estrutura convencional de aplicações Java com Maven:

```
projeto-triangulo-eventos/
│
├── src/
│   └── main/
│       └── java/
│           └── Principal.java
│
├── pom.xml
├── .gitignore
├── README.md
└── LICENSE
```

**Descrição dos arquivos:**

- `Principal.java`: contém a implementação do programa, a interface gráfica e o tratamento dos eventos.
- `pom.xml`: arquivo de configuração do Maven, responsável pelo gerenciamento e pela construção do projeto.
- `.gitignore`: define os arquivos e diretórios que não devem ser versionados pelo Git.
- `README.md`: apresenta a documentação do projeto.
- `LICENSE`: informa os termos de licenciamento do projeto.

## 7. Organização do código

A implementação utiliza componentes da biblioteca Swing para construir a interface gráfica e tratar as ações realizadas pelo usuário.

### 7.1. Criação da janela

```
JFrame janela = new JFrame("Calculo do Triangulo");
```

Cria a janela principal da aplicação, responsável por apresentar os componentes gráficos e permitir a interação com o usuário.

### 7.2. Criação dos campos de entrada

```
JTextField campoA = new JTextField(8);
JTextField campoB = new JTextField(8);
JTextField campoC = new JTextField(8);
```

Cria três campos de texto que permitem ao usuário informar os valores correspondentes aos lados do triângulo.

### 7.3. Criação do botão

```
JButton botao = new JButton("Calcular");
```

Cria um botão que será utilizado pelo usuário para iniciar o processamento dos dados informados.

### 7.4. Criação da área de resultado

```
JLabel resultado = new JLabel("Informe os tres lados.");
```

Cria um componente responsável por apresentar mensagens e os resultados dos cálculos na interface gráfica.

### 7.5. Organização dos componentes

```
JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));
```

Cria um painel para organizar os componentes da interface utilizando o gerenciador de layout `GridLayout`.

Os componentes são distribuídos em linhas e colunas, facilitando a organização dos campos de entrada, rótulos e botão.

### 7.6. Tratamento do evento de clique

```
botao.addActionListener(e -> {
    // Instrucoes executadas quando o botao for acionado
});
```

Este é um dos principais trechos do programa.

O método `addActionListener()` registra um listener para o botão. Quando o usuário clica nele, o código definido na expressão lambda é executado.

A variável `e` representa o evento recebido pelo listener.

Esse mecanismo permite que o programa execute as operações somente quando o usuário realizar a ação correspondente.

### 7.7. Leitura e conversão dos valores

```
double a = Double.parseDouble(campoA.getText());
double b = Double.parseDouble(campoB.getText());
double c = Double.parseDouble(campoC.getText());
```

Obtém os conteúdos dos campos de texto e converte os valores para o tipo `double`, permitindo realizar as operações matemáticas.

### 7.8. Validação do triângulo

```
boolean valido
        = a > 0 && b > 0 && c > 0
        && a < b + c
        && b < a + c
        && c < a + b;
```

Verifica se os três lados são positivos e atendem às condições matemáticas de existência de um triângulo.

O resultado é armazenado na variável `valido`, que determina se os cálculos poderão ser realizados.

### 7.9. Cálculo e apresentação dos resultados

```
double p = a + b + c;
double s = p / 2;
double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
```

Calcula o perímetro, o semiperímetro e a área do triângulo.

Os resultados são apresentados na interface por meio do componente `JLabel`:

```
resultado.setText(
    String.format(
        "<html>Perimetro: %.2f<br>Area: %.2f</html>", p, area
    )
);
```

O método `setText()` atualiza o conteúdo do componente. A utilização de HTML permite apresentar os resultados em linhas separadas.

### 7.10. Tratamento de exceções

```
catch (NumberFormatException erro) {
    resultado.setText("Informe valores numericos validos!");
}
```

O bloco `catch` captura erros que ocorrem quando o usuário informa um conteúdo que não pode ser convertido para o tipo numérico `double`.

Assim, o programa apresenta uma mensagem de orientação em vez de encerrar inesperadamente a execução.

### 7.11. Configuração da janela

```
janela.add(painel);
janela.setSize(400, 220);
janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
janela.setLocationRelativeTo(null);
janela.setVisible(true);
```

Configura a janela principal:

- Adiciona o painel com os componentes gráficos.
- Define as dimensões da janela.
- Determina que a aplicação será encerrada quando a janela for fechada.
- Centraliza a janela na tela.
- Torna a interface visível.

## 8. Como executar o projeto

### Pré-requisitos

Para executar o projeto, é necessário ter instalado:

- Java JDK.
- Apache Maven.
- Ambiente gráfico compatível com Java Swing.
- Git (opcional, para clonar o repositório).

### Clonar o repositório

```
git clone URL_DO_REPOSITORIO
```

Acesse o diretório do projeto:

```
cd NOME_DO_PROJETO
```

### Compilar o projeto

Execute o comando:

```
mvn clean compile
```

O Maven realizará a limpeza dos arquivos de compilação anteriores e compilará os arquivos-fonte do projeto.

### Executar o programa

Considerando que a classe `Principal` não possui declaração de pacote, o programa poderá ser executado com:

```
mvn exec:java -Dexec.mainClass="Principal"
```

Esse comando utiliza o plugin Exec do Maven.

Caso o plugin ainda não esteja configurado no projeto, será necessário adicioná-lo ao `pom.xml`.

**Observação:** como o projeto utiliza Swing, a execução precisa ocorrer em um ambiente que ofereça suporte a interface gráfica. Em ambientes sem monitor ou servidor gráfico, a janela não poderá ser apresentada normalmente.

## 9. Exemplo de execução

### Exemplo 1 — Triângulo válido

**Interface apresentada:**

```
       Calculo do Triangulo

Lado A: [ 3       ]
Lado B: [ 4       ]
Lado C: [ 5       ]

[ Calcular ]

Perimetro: 12.00
Area: 6.00
```

**Resultado:** o programa identifica que os valores formam um triângulo válido e apresenta o perímetro e a área.

### Exemplo 2 — Triângulo inválido

**Valores informados:**

```
Lado A: 2
Lado B: 3
Lado C: 8
```

**Resultado apresentado na interface:**

```
Triangulo invalido!
```

### Exemplo 3 — Entrada inválida

**Valores informados:**

```
Lado A: abc
Lado B: 4
Lado C: 5
```

**Resultado apresentado na interface:**

```
Informe valores numericos validos!
```

## 10. Conceitos de programação demonstrados

Este projeto permite estudar e identificar os seguintes conceitos:

- Paradigma de programação orientada a eventos.
- Eventos e listeners.
- Event handlers.
- Expressões lambda.
- Interfaces gráficas.
- Biblioteca Java Swing.
- Componentes `JFrame`, `JPanel`, `JTextField`, `JButton` e `JLabel`.
- Gerenciamento de layout com `GridLayout`.
- Método `addActionListener()`.
- Atualização dinâmica de componentes gráficos.
- Tratamento de exceções com `try/catch`.
- Conversão de tipos com `Double.parseDouble()`.
- Entrada e saída de dados por interface gráfica.
- Operações matemáticas.

## 11. Considerações finais

A implementação demonstra a aplicação do paradigma orientado a eventos na resolução de um problema matemático.

Ao utilizar uma interface gráfica, o programa deixa de depender exclusivamente de uma sequência fixa de instruções e passa a responder às ações realizadas pelo usuário.

O clique no botão "Calcular" representa o evento que desencadeia o processamento dos dados, enquanto o `ActionListener` é responsável por identificar essa ação e executar as operações correspondentes.

Este projeto também servirá como referência para comparar diferentes paradigmas de programação, permitindo observar como o mesmo problema pode ser resolvido por abordagens distintas, como programação estruturada, funcional, concorrente e orientada a objetos.