package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            int[] array;
            array = new int[0];
            return array;
        }
        else {
            int last = inputArray[inputArray.length - 1];
            for (int i = inputArray.length - 1; i > 0; i--) {
                inputArray[i] = inputArray[i - 1];
            }
            inputArray[0] = last;
            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1){
            return inputArray[0];
        }
        int max1 = -1, max2 = -1, min1 = -1, min2 = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (max1 == -1 || inputArray[max1] < inputArray[i])
                max1 = i;
            if (min1 == -1 || inputArray[min1] > inputArray[i])
                min1 = i;
        }
        for (int i = 0; i < inputArray.length; i++){
            if (i != max1 && (max2 == -1 || inputArray[max2] < inputArray[i]))
                max2 = i;
            if (i != min1 && (min2 == -1 || inputArray[min2] > inputArray[i]))
                min2 = i;
        }
        if (inputArray[max1] * inputArray[max2] > inputArray[min1] * inputArray[min2])
            return inputArray[max1] * inputArray[max2];
        else
            return inputArray[min1] * inputArray[min2];
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.isEmpty()){
            return 0;
        }
        input = input.toLowerCase();
        int count = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b'){
                count++;
            }
        }
        return Math.floorDiv((100 * count ), input.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null ) {
            return false;
        }
        if (input.isEmpty()){
            return true;
        }
        int count = 0;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) == input.charAt(input.length() - i - 1)) {
                count++;
            }
        }
        if (count == input.length() / 2) {
            return true;
        } else{

            return false;
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.isEmpty()){
            return "";
        }
        StringBuilder result = new StringBuilder("");
        int count = 0;
        int i = 0;
        while (i < input.length()){
            char value = input.charAt(i);
            while (i < input.length() && value == input.charAt(i) ) {
                count++;
                i++;
            }
            result.insert(result.length(), value);
            result.insert(result.length(), count);
            count = 0;
        }
        return result.toString();

    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутацией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
       if (one == null || two == null || one.isEmpty() || two.isEmpty() || one.length() != two.length()){
           return false;
       }
       int[] chArr = new int[256];
       for (int i = 0; i < one.length(); i++){
           chArr[one.charAt(i)]++;
       }
       for (int i = 0; i < two.length(); i++){
           chArr[two.charAt(i)]--;
       }
       for (int i = 0; i < 256; i++){
           if (chArr[i] != 0)
               return false;
       }
       return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.isEmpty()){
            return false;
        }
       boolean[] symbArr = new boolean[256];
       for (int i = 0; i < s.length(); i++){
           if (symbArr[s.charAt(i)]){
               return false;
           }
           symbArr[s.charAt(i)] = true;
       }
       return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null){
            m = new int[][]{{}, {}};
        }
        for (int i = 0; i < m.length; i++){
            for (int j = i + 1; j < m[i].length; j++){
                int temp = m[i][j];
                m[i][j] = m [j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (separator == null){
            separator = ' ';
        }
        StringBuilder result = new StringBuilder("");
        if (inputStrings == null || inputStrings.length == 0){
            return result.toString();
        }
        for (int i = 0; i < inputStrings.length - 1; i++){
            result.insert(result.length(), inputStrings[i]);
            result.insert(result.length(), separator);
        }
        result.insert(result.length(), inputStrings[inputStrings.length - 1]);
        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-префикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < inputStrings.length; i++){
            if (inputStrings[i].startsWith(prefix))
                res++;
        }
        return res;
    }
}
