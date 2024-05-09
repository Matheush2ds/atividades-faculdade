# Verificador de Expressões Aritméticas

Este programa em Java utiliza uma pilha dinâmica para verificar se expressões aritméticas estão com a parametrização correta. O programa verifica se cada "abre parênteses" tem um "fecha parênteses" correspondente.

## Funcionamento
O programa solicita ao usuário que insira uma expressão aritmética contendo parênteses, colchetes e chaves. Em seguida, ele verifica se a expressão está corretamente parametrizada, ou seja, se todos os parênteses, colchetes e chaves são fechados corretamente.

O programa utiliza uma pilha dinâmica para verificar a correspondência dos parênteses. Quando encontra um "abre parênteses", "abre colchete" ou "abre chave", ele adiciona o caractere correspondente à pilha. Quando encontra um "fecha parênteses", "fecha colchete" ou "fecha chave", ele verifica se o topo da pilha contém o correspondente "abre parênteses", "abre colchete" ou "abre chave". Se o topo da pilha corresponder, o caractere é removido da pilha. Caso contrário, a expressão é considerada incorreta.

Ao percorrer toda a expressão, se a pilha estiver vazia, isso significa que todos os parênteses, colchetes e chaves foram fechados corretamente e a expressão é considerada correta. Caso contrário, se a pilha não estiver vazia, significa que algum parêntese, colchete ou chave não foi fechado corretamente, e a expressão é considerada incorreta.

## Exemplos de Uso

### Correto:
> Expressão: ((7*5)*4-(8/3))
Resultado: A expressão está corretamente parametrizada.

### Incorreto

> Expressão: ((7*5)*4-(8/3)
Resultado: A expressão está incorretamente parametrizada.


## Como Executar o Programa

- Certifique-se de ter o ambiente Java configurado em seu sistema.
- Compile o código-fonte do programa usando o comando javac:

> javac VerificadorExpressoes.java

- Execute o programa usando o comando java

> java VerificadorExpressoes



