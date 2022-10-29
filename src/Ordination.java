package src;

public class Ordination {

  // * Merge Sort

  public static int[] mergeSort(int[] data) {
    if (data == null || data.length <= 0) return null;

    int indexStart = 0;
    int endIndex = data.length - 1;

    sort(data, indexStart, endIndex);

    return data;
  }

  private static void sort(int[] data, int indexStart, int endIndex) {

		// Condicional que verifica a validade dos parâmetros passados.
		if (data != null && indexStart < endIndex && indexStart >= 0 &&
		 endIndex < data.length && data.length != 0) {
			int middle = ((endIndex + indexStart) / 2);

			sort(data, indexStart, middle);
			sort(data, middle + 1, endIndex);

			merge(data, indexStart, middle, endIndex);
		}
	}

  /**
    * O merge consiste na junção de duas listas já ordenadas.
    * Usa um array auxiliar.
  */
	private static void merge(int[] data, int indexStart, int middle, int endIndex) {

		int[] auxiliary = new int[data.length];
    
		//Copiando o trecho da lista que vai ser ordenada
		for (int i = indexStart; i <= endIndex; i++) {
			auxiliary[i] = data[i];
		}

		//Índices auxiliares
		int i = indexStart;
		int j = middle + 1;
		int k = indexStart;

		//Junção das listas ordenadas
		while (i <= middle && j <= endIndex) {
			if (auxiliary[i] < auxiliary[j]) {
				data[k] = auxiliary[i];
				i++;
			} else {
				data[k] = auxiliary[j];
				j++;
			}
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (i <= middle) {
			data[k] = auxiliary[i];
			i++;
			k++;
		}

		//Append de itens que não foram usados na Junção
		while (j <= endIndex) {
			data[k] = auxiliary[j];
			j++;
			k++;
		}
	}

  // * Inserction Sort

  public static int[] inserctionSort(int[] data) {
    if (data == null || data.length <= 0) return null;

    int indexStart = 0;
    inserctionSort(data, indexStart);

    return data;
  }

  private static void inserctionSort(int[] data, int indexStart) {
    if(indexStart == data.length) return;
        
    for(int c = indexStart; c > 0; c--){
        if(data[c-1] > data[c]){
            int aux = data[c-1];
            data[c-1] = data[c];
            data[c] = aux;
        }
    }

    inserctionSort(data, ++indexStart);
  }

} 
