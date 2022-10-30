package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

  public static Map<String, String>  inserctionSort(int[] data) {
    if (data == null || data.length <= 0) return null;

    Map<String, String> result = new HashMap<String, String>();
    result.put("Disordered Vector", Arrays.toString(data));

    int indexStart = 0;
    int[] deductions = inserctionSort(data, indexStart, 0, 0);

    result.put("Number Of Exchanges", Integer.toString(deductions[0]));
    result.put("Number Of Comparisons", Integer.toString(deductions[1]));
    result.put("Ordered Vector", Arrays.toString(data));

    return result;
  }

  private static int[] inserctionSort(int[] data, int indexStart, int numberOfExchanges, int numberOfComparisons) {
    if(indexStart == data.length) {
      int[] result = new int[2];
      result[0] = numberOfExchanges;
      result[1] = numberOfComparisons;
      return result;
    }
        
    for(int index = indexStart; index > 0; index--){
      numberOfComparisons++;
      if(data[index - 1] > data[index]){
          int auxiliary = data[index - 1];
          data[index - 1] = data[index];
          data[index] = auxiliary;
          numberOfExchanges++;
      }
    }

    return inserctionSort(data, ++indexStart, numberOfExchanges, numberOfComparisons);
  }

} 
