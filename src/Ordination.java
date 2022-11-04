package src;

import java.util.HashMap;
import java.util.Map;

public class Ordination {

  // * Merge Sort

  public static Map<String, String> mergeSort(int[] data) {
    if (data == null || data.length <= 0) return null;

    Map<String, String> result = new HashMap<String, String>();
    // result.put("Disordered Vector", Arrays.toString(data));

    int indexStart = 0;
    int endIndex = data.length - 1;

    double start = System.nanoTime();
    double[] deductions = sort(data, indexStart, endIndex);
    double elapsedNano = System.nanoTime() - start;
    double elapsedMilli = (elapsedNano / 1000000);
    double elapsedSeg = (elapsedMilli / 1000);

    result.put("Number Of Exchanges", Double.toString(deductions[0]));
    result.put("Number Of Comparisons", Double.toString(deductions[1]));
    // result.put("Ordered Vector", Arrays.toString(data));
    result.put("Time Spent",
     "Nanoseconds: " + elapsedNano
     + " - Milliseconds: " + elapsedMilli
     + " - Seconds: " + elapsedSeg
     );

    return result;
  }

  private static double[] sort(int[] data, int indexStart, int endIndex) {
    double[] result = new double[2];

		// Condicional que verifica a validade dos parâmetros passados.
		if (data != null && indexStart < endIndex && indexStart >= 0 &&
		 endIndex < data.length && data.length != 0) {
			int middle = ((endIndex + indexStart) / 2);

			double[] resultAux = sort(data, indexStart, middle);
      result[0] = result[0] + resultAux[0];
      result[1] = result[1] + resultAux[1];

			resultAux = sort(data, middle + 1, endIndex);
      result[0] = result[0] + resultAux[0];
      result[1] = result[1] + resultAux[1];

			resultAux = merge(data, indexStart, middle, endIndex, 0, 0);
      result[0] = result[0] + resultAux[0];
      result[1] = result[1] + resultAux[1];
		}

    return result;
	}

	private static double[] merge(int[] data, int indexStart, int middle, int endIndex, double numberOfExchanges, int numberOfComparisons) {

		int[] auxiliary = new int[data.length];
    
		//Copiando o trecho da lista que vai ser ordenada
		for (int i = indexStart; i <= endIndex; i++) {
			auxiliary[i] = data[i];
		}

		//Índices auxiliares
		int i = indexStart;
		int j = middle + 1;
		int k = indexStart;

    if (i > middle || j > endIndex) numberOfComparisons++;
    
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
      numberOfExchanges += 0.5;
      numberOfComparisons++;
		}

    if (i > middle) numberOfComparisons++;

		//Append de itens que não foram usados na Junção
		while (i <= middle) {
			data[k] = auxiliary[i];
			i++;
			k++;
      numberOfExchanges += 0.5;
      numberOfComparisons++;
		}

    if (j > endIndex) numberOfComparisons++;

		//Append de itens que não foram usados na Junção
		while (j <= endIndex) {
			data[k] = auxiliary[j];
			j++;
			k++;
      numberOfExchanges += 0.5;
      numberOfComparisons++;
		}

    double[] result = new double[2];
    result[0] = numberOfExchanges;
    result[1] = numberOfComparisons;
    return result;
	}

  // * Inserction Sort

  public static Map<String, String>  insertionSort(int[] data) {
    if (data == null || data.length <= 0) return null;

    Map<String, String> result = new HashMap<String, String>();
    // result.put("Disordered Vector", Arrays.toString(data));

    int indexStart = 0;
    double start = System.nanoTime();
    int[] deductions = insertionSort(data, indexStart, 0, 0);
    double elapsedNano = System.nanoTime() - start;
    double elapsedMilli = (elapsedNano / 1000000);
    double elapsedSeg = (elapsedMilli / 1000);

    result.put("Number Of Exchanges", Integer.toString(deductions[0]));
    result.put("Number Of Comparisons", Integer.toString(deductions[1]));
    // result.put("Ordered Vector", Arrays.toString(data));
    result.put("Time Spent",
     "Nanoseconds: " + elapsedNano
     + " - Milliseconds: " + elapsedMilli
     + " - Seconds: " + elapsedSeg
     );

    return result;
  }

  private static int[] insertionSort(int[] data, int indexStart, int numberOfExchanges, int numberOfComparisons) {
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

    return insertionSort(data, ++indexStart, numberOfExchanges, numberOfComparisons);
  }

} 
