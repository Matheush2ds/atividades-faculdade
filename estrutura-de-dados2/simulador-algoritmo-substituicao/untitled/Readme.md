# Simulador de Algoritmos de Substituição de Páginas

Este é um simulador para a execução de algoritmos de substituição de páginas na memória RAM. O simulador opera com duas matrizes: MATRIZ RAM (representando as molduras de páginas na memória RAM) e MATRIZ SWAP (representando as páginas em SWAP). Cada matriz possui 10 linhas e 6 colunas com os seguintes campos: Número de Página (N), Instrução (I), Dado (D), Bit de Acesso R, Bit de Modificação M e Tempo de Envelhecimento (T).

## Inicialização das Matrizes

Para iniciar a simulação, as matrizes são preenchidas da seguinte forma:

- A coluna N da MATRIZ SWAP contém números sequenciais de 0 a 99.
- A coluna I da MATRIZ SWAP contém números sequenciais de 1 a 100.
- A coluna D da MATRIZ SWAP contém números aleatórios de 1 a 50.
- A coluna R da MATRIZ SWAP é inicializada com 0.
- A coluna M da MATRIZ SWAP é inicializada com 0.
- A coluna T da MATRIZ SWAP contém números aleatórios de 100 a 9999.

A MATRIZ RAM é preenchida da seguinte forma:

- Para cada linha da MATRIZ RAM, é sorteado um número de 0 a 99.
- Os dados são copiados da MATRIZ SWAP para a MATRIZ RAM, usando o número sorteado como índice da linha.

## Execução da Simulação

A simulação consiste em executar 1000 instruções para cada algoritmo de substituição de página. Os algoritmos a serem implementados são:

1. NRU (Not Recently Used)
2. FIFO (First-In-First-Out)
3. FIFO-SC (FIFO Second-Chance)
4. RELÓGIO (Clock)
5. WS-CLOCK (Working Set Clock)

A cada 10 instruções, o Bit R deve ser zerado para todas as páginas na memória RAM. Quando uma página com Bit M=1 é retirada da memória, ela deve ser salva em SWAP com Bit M=0.

## Algoritmo WS-Clock

Para a implementação do algoritmo WS-Clock, um número é sorteado para verificar o envelhecimento da página (EP), que deve estar na faixa de 100 a 9999. Se o EP for menor ou igual a T, a página ainda faz parte do conjunto de trabalho. Caso o EP seja maior que T, a página é removida do conjunto de trabalho.

## Impressão das Matrizes

No início da execução, as MATRIZ RAM e MATRIZ SWAP devem ser impressas. Ao final das 1000 instruções, ambas as matrizes devem ser impressas novamente.

## Observações

- Cada página tem 30% de chance de sofrer uma modificação quando é acessada.
- A substituição de páginas é realizada quando a instrução não está na MATRIZ RAM de acordo com o algoritmo escolhido.

Este simulador permite avaliar o desempenho dos diferentes algoritmos de substituição de página na memória RAM, considerando as características específicas de cada algoritmo e os eventos durante a execução das instruções.
