# Solução para o Problema dos Filósofos Glutões em Java com Threads

## Objetivo
Desenvolver um programa em Java utilizando Threads para solucionar o problema dos Filósofos Glutões. O problema consiste em garantir que cinco filósofos possam alternar entre as tarefas de pensar e comer sem ficarem travados.

## Abra a pasta SRC

## O Problema do Jantar dos Filósofos
O Jantar dos Filósofos, proposto por Dijkstra em 1965, é um problema clássico de sincronização. Ele descreve uma situação em que cinco filósofos estão sentados em uma mesa redonda para jantar. Cada filósofo tem um prato com espaguete e um garfo à sua frente. O objetivo é garantir que os filósofos possam comer sem ficarem travados.

## Definição do Problema

- Há cinco filósofos em torno de uma mesa.
- Um garfo é colocado entre cada filósofo.
- Cada filósofo deve alternar entre refletir e comer.
- Para comer, um filósofo deve possuir dois garfos (à esquerda e à direita).
- Os garfos só podem ser pegos por um filósofo e não podem estar em uso por outros.
- Após comer, o filósofo deve liberar os garfos para que outros possam usá-los.
- Um filósofo pode segurar um garfo assim que estiver disponível, mas só começa a comer quando ambos estão sob sua posse.
