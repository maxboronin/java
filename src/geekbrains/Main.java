package geekbrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /**
         * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        replaceZeroAndOneInArray();

        /**
         * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        System.out.println("\n");
        fillEmptyArray();

        /**
         * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        System.out.println("\n");
        multiplyByTwoNumbersLessSixInArray();

        /**
         * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        System.out.println("\n");
        createQuadArrayAndFillDiags();

        /**
         * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
         */
        System.out.println("\n");
        createArrayAndSearchMinAndMaxValues();

        /**
         * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
         * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
         */
        System.out.println("\n");
        int[] arrayToCheckPartsEquals = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.\n" +
                "Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.");
        System.out.println("Массив: " + Arrays.toString(arrayToCheckPartsEquals));
        System.out.println("Результат: " + checkArrayPartsEquals( arrayToCheckPartsEquals ));

        /**
         * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
         * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
         * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
         */
        System.out.println("\n");
        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.\n" +
                "Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]\n" +
                "при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.\n");
        int[] arrayToShift1 = { 6, 1, 3, 5 };
        System.out.println("Массив: " + Arrays.toString(arrayToShift1));
        System.out.println("Сдвиг влево на 13: " + Arrays.toString(shiftArray( arrayToShift1, -13)));
        int[] arrayToShift2 = { 6, 1, 3, 5 };
        System.out.println("Массив: " + Arrays.toString(arrayToShift2));
        System.out.println("Сдвиг вправо на 13: " + Arrays.toString(shiftArray( arrayToShift2, 13)));
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static void replaceZeroAndOneInArray() {
        int[] zeroOneArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        System.out.println("Исходный массив: " + Arrays.toString(zeroOneArray));

        for(int i=0; i < zeroOneArray.length; i++){
            zeroOneArray[i] = zeroOneArray[i] == 1 ? 0: 1;
        }

        System.out.println("Результирующий массив: " + Arrays.toString(zeroOneArray));
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    private static void fillEmptyArray(){
        int[] emptyArrayToFill = new int[8];

        for (int i=0; i < emptyArrayToFill.length; i++){
            emptyArrayToFill[i] = i*3;
        }

        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");
        System.out.println("Результат: " + Arrays.toString(emptyArrayToFill));
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    private static void multiplyByTwoNumbersLessSixInArray(){
        int[] arrayToMultiply = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;");
        System.out.println("Исходный массив: " + Arrays.toString(arrayToMultiply));

        for (int i=0; i < arrayToMultiply.length; i++) {
            if(arrayToMultiply[i] < 6){
                arrayToMultiply[i] *= 2;
            }
        }

        System.out.println("Результирующий массив: " + Arrays.toString(arrayToMultiply));
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    private static void createQuadArrayAndFillDiags() {
        int[][] quadArray = new int[7][7];
        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");

        for ( int i=0; i< quadArray.length; i++){
            quadArray[i][i] = quadArray[i][quadArray.length - i - 1] = 1;
        }

        System.out.println("Результирующий массив: ");
        for ( int i=0; i< quadArray.length; i++){
            System.out.println(Arrays.toString(quadArray[i]));
        }
    }

    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    private static void createArrayAndSearchMinAndMaxValues() {
        int[] arrayToSearch = { 1, 2 -1, -10, 0, 5, 22, 33, -80};
        int min = arrayToSearch[0];
        int max = arrayToSearch[0];

        System.out.println("5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);");
        System.out.println("Массив для поиска: " + Arrays.toString(arrayToSearch));

        for ( int i=0; i < arrayToSearch.length; i++ ){
            if(min > arrayToSearch[i]){
                min = arrayToSearch[i];
            }
            if(max < arrayToSearch[i]){
                max = arrayToSearch[i];
            }
        }

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
     *
     */
    private static boolean checkArrayPartsEquals(int[] arrayToCheck) {
        for ( int cursor = 0; cursor < arrayToCheck.length; cursor++ ){
            int leftSum = 0;
            int rightSum = 0;
            for ( int i = 0; i < arrayToCheck.length; i++ ){
                if( i <= cursor ){
                    leftSum += arrayToCheck[i];
                }else{
                    rightSum += arrayToCheck[i];
                }
            }
            if(leftSum == rightSum){
                return true;
            }
        }
        return false;
    }

    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
     * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */
    private static int[] shiftArray( int[] arrayToShift, int n) {
        boolean left = n < 0;

        if(left){
            arrayToShift = reverseArray( arrayToShift );
        }

        n = Math.abs(n);

        int fullLengthInsideN = n / arrayToShift.length;
        int shiftsInsideArrayLength = n - fullLengthInsideN * arrayToShift.length;
        for(int step = 1; step <= shiftsInsideArrayLength; step++){
            int buffer = arrayToShift[arrayToShift.length - 1];
            for (int k = 0; k < arrayToShift.length - 1; k++ ){
                arrayToShift[arrayToShift.length - 1 - k] = arrayToShift[arrayToShift.length - 2 - k];
            }
            arrayToShift[0] = buffer;
        }

        if(left){
            return reverseArray( arrayToShift );
        }

        return arrayToShift;
    }

    private static int[] reverseArray(int[] arrayToReverse) {
        for(int i=0; i < arrayToReverse.length / 2; i++ ){
            int buff = arrayToReverse[i];
            arrayToReverse[i] = arrayToReverse[arrayToReverse.length - i - 1];
            arrayToReverse[arrayToReverse.length - i - 1] = buff;
        }
        return arrayToReverse;
    }

}
