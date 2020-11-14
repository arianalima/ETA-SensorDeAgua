# ETA-SensorDeAgua
Repo para cadeira de Revisão de Programação da Especialização em Testes Ágeis. 

Atividade:
Criar um conjunto de testes unitários usando o JorgeUnit.jar (mesmo sem a classe do Sensor pronta).

Requisitos:
=========================

- Sensor que mede nivel de agua continuamente
-  Valor atual do nivel da agua
- tem um alto-falante (estado desligado, ligado)
- tem alarme visual (desligado, piscando, ligado)
- flag: Tem informacao para parar de encher

1- O sensor passa a informacao do percentual da cisterna (0 - 100%)

2- Se abaixo de 20%: emite sinal sonoro e luminoso ligado
   
3- Se abaixo de 50%: Apenas sinal luminoso piscando

4- Se 100%: nao permite mais a entrada de agua (flag)
