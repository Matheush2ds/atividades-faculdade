# Comparação de Desempenho entre Árvores AVL e Rubro-Negra

Este é um projeto simples em Java feito na faculdade de Ciências da Computação, na matéria de Estrutura de Dados 2 que visa comparar o desempenho das árvores AVL e Rubro-Negra. As árvores serão preenchidas com dados provenientes de um arquivo contendo 100.000 números inteiros. Além disso, serão realizadas operações adicionais com 50.000 números aleatórios, incluindo inserção e remoção com base em condições específicas.

## Enunciado

### Parte 1: Preenchimento das Árvores

1. **Leitura de Dados:** Os dados a serem utilizados estão contidos em um arquivo, sendo o mesmo arquivo para ambas as árvores. O arquivo consiste em 100.000 números inteiros.

2. **Preenchimento da Árvore AVL:** Medir o tempo necessário para inserir todos os dados na árvore AVL.

3. **Preenchimento da Árvore Rubro-Negra:** Medir o tempo necessário para inserir todos os dados na árvore Rubro-Negra.

### Parte 2: Operações Adicionais

1. **Sorteio de Números:** Realizar o sorteio aleatório de 50.000 números inteiros no intervalo de -9999 a 9999.

2. **Inserção e Remoção:** Para cada número sorteado, se for múltiplo de 3, inserir esse número nas duas árvores. Se for múltiplo de 5, remover esse número apenas da árvore Rubro-Negra. Caso não seja nem múltiplo de 3 ou 5, contar quantas vezes esse número aparece nas duas árvores.

### Observações

1. As operações e a contagem devem ser realizadas com os mesmos conjuntos de números em ambas as árvores.

2. Marcar o tempo de execução para a inserção e operações adicionais em ambas as árvores.

3. Fazer uma comparação entre os tempos de execução das árvores AVL e Rubro-Negra.

## Execução do Projeto

1. **Leitura do Arquivo:**
   - Utiliza-se um método para ler os 100.000 números inteiros de um arquivo chamado `numbers.txt`.

2. **Preenchimento das Árvores:**
   - Os números do arquivo são inseridos nas árvores AVL e Rubro-Negra, e os tempos de inserção são registrados.

3. **Operações Adicionais:**
   - São sorteados 50.000 números aleatórios.
   - Com base nas condições especificadas, as operações de inserção, remoção e contagem são realizadas nas árvores.

4. **Comparativo de Desempenho:**
   - Os tempos de execução para inserção e operações adicionais são comparados entre as árvores AVL e Rubro-Negra.

## Execução do Código

1. Execute a classe `TreeComparison` para iniciar o programa.
2. Os resultados serão exibidos no console, incluindo tempos de execução e resultados das operações.
