# Guion para Video Corto: Algoritmo de Dijkstra con Mapa de Colombia (3 minutos)

## Introducción (0:00 - 0:20)
"Hola, hoy explico un proyecto: algoritmo de Dijkstra adaptado al mapa de Colombia. De Cali a Cartagena, encuentra todos los caminos, los ordena con burbuja para el menor, usa LinkedList en listas de adyacencia. Código comentado simple."

## Estructura del Proyecto (0:20 - 0:30)
"Archivos: Grafo.java (clase grafo con LinkedList), Dijkstra.java (algoritmo modificado), grafo.dot (visualización)."

## Grafo.java (0:30 - 1:00)
"Grafo.java: Grafo no dirigido con pesos. Mapa con clave=nodo, valor=LinkedList<Arista>. Constructor vacío. agregarNodo: crea LinkedList si no existe. agregarArista: conecta bidireccional con peso. Clase Arista: destino y peso."

## Dijkstra.java (1:00 - 2:20)
"Dijkstra.java: Clase Camino (ruta y distancia). encontrarTodosLosCaminos: DFS recursivo, explora profundidad, backtracking para todos caminos. dfs: recursión, marca visitado, explora no visitados. ordenarCaminosPorDistancia: burbuja, compara e intercambia. calcularCaminoMasCorto: Dijkstra original, cola prioridad con Comparator::method reference. main: crea grafo Colombia, agrega nodos/ciudades, aristas con distancias km, encuentra caminos Cali-Cartagena, ordena, imprime todos y menor."

## Ejecución y Visualización (2:20 - 2:50)
"Ejecutar: javac Grafo.java Dijkstra.java, java Dijkstra. Salida: caminos ordenados. Visualizar: grafo.dot en Graphviz online."

## Conclusión (2:50 - 3:00)
"Proyecto muestra adaptación Dijkstra a rutas reales. DFS para caminos, burbuja ordenar, LinkedList adyacencia. ¡Like y suscribete!"

## Notas
- Habla rápido pero claro.
- Muestra código en pantalla.
- Ejecuta y muestra salida.
- Duración exacta: 3 minutos.
