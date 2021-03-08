package geekbrains;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main{
    //Символы для отображения игрового поля
    private static final char pureValue = (char) 183;
    private static final char humanValue = 'X';
    private static final char aiValue = 'O';

    //Данные для модели поля
    private static final int humanModel = 1;
    private static final int aiModel = 2;

    //Размер поля
    private static final int mapDimension = 5;
    //Количество фишек для победы
    private static final int lengthForWin = 4;

    //Мрдель игрового поля
    private static int[][] mapModel;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        initMapModel();
        showMap();
        System.out.println(playGame());
    }

    private static String playGame() throws Exception{
        do{
            turnHuman();
            showMap();
            if(checkWin(1)){
                return "Поздравляем! Вы выиграли!";
            }
            turnAi();
            showMap();
            if(checkWin(2)){
                return "Комп выиграл!";
            }
        }while(!checkForDraw());
        return "Боевая ничья!";
    }

    /**
     * Проверка на ничью
     * Достаточно тупая - если некуда ходить, значит ничья
     * @return
     */
    private static Boolean checkForDraw(){
        for(int x=1; x <= mapDimension; x++){
            for (int y=1; y <= mapDimension; y++){
                if(isFieldFree(x, y)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ход компа
     */
    private static void turnAi() throws Exception{
        findBestTurnForAi();
        System.out.println("Комп походил");
    }

    /**
     * Ход человека
     */
    private static void turnHuman() throws Exception{
        System.out.println("Ваш ход");
        int x, y;
        Boolean checkInput = false;
        do {
            x = inputCoord("Введите строку: ");
            y = inputCoord("Введите столбец: ");
            if(isFieldFree(x, y)){
                changeMapModel(x, y, humanModel);
                checkInput = true;
            }else{
                System.out.println("Поле занято. Пвторите ввод.");
            }
        }while(!checkInput);
    }

    /**
     * Определение занятости поля
     */
    private static Boolean isFieldFree(int x, int y){
        return mapModel[x - 1][y - 1] == 0;
    }

    /**
     * Изменение модели данных
     */
    private static void changeMapModel(int x, int y, int value) throws Exception{
        if( mapModel[x - 1][y - 1] != 0 && value != 0){
            throw new Exception("Попытка перезаписать занятое полде в модели");
        }
        mapModel[x - 1][y - 1] = value;
    }

    /**
     * Ввод координат хода человеком
     */
    private static int inputCoord(String title){
        System.out.println(title);
        Boolean checkInput;
        int input;

        do {
            checkInput = true;
            input = scanner.nextInt();
            if (input < 1 || input > mapDimension) {
                System.out.println("Неверной значение. Повторите ввод");
                checkInput = false;
            }
        }while(!checkInput);

        return input;
    }

    /**
     * Отрисовка игрового поля
     */
    private static void showMap(){
        System.out.printf("   ");
        for(int i=0; i< mapDimension; i++) {
            System.out.printf(" %s ", i + 1);
        }
        System.out.println();
        for(int i=0; i < mapDimension; i++){
            System.out.printf(" %s ", i + 1);
            for(int j=0; j < mapDimension; j++) {
                System.out.printf(" %s ", getFieldChar( mapModel[i][j] ) );
            }
            System.out.println();
        }
    }

    /**
     * Получение символа для отображения данных на поле
     */
    private static char getFieldChar(int value){
        switch (value){
            case humanModel:
                return humanValue;
            case aiModel:
                return aiValue;
            default:
                return pureValue;
        }
    }

    /**
     * Инициализация игрового поля (модели данных)
     */
    private static void initMapModel(){
        mapModel = new int[mapDimension][mapDimension];
        for(int i=0; i < mapDimension; i++){
            for(int j=0; j < mapDimension; j++) {
                mapModel[i][j] = 0;
            }
        }
    }

    /**
     * Проверка на выигрыш для человека или компа
     */
    private static Boolean checkWin(int value){
        for(int startCol = 0; startCol < mapDimension - lengthForWin + 1; startCol++){
            for(int startRow = 0; startRow < mapDimension - lengthForWin + 1; startRow++) {
                int[][] frame = getFrame(startCol, startRow);
                if (checkRowsColsForWin(frame, value) || checkDiagsForWin(frame, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка строк и столбцов на выигрыш
     */
    private static Boolean checkRowsColsForWin( int[][] frame, int value) {
        Boolean checkX, checkY;
        for (int i = 0; i < frame.length; i++){
            checkX = true;
            checkY = true;
            for(int j = 0; j < frame.length; j++){
                checkX = checkX && (frame[i][j] == value);
                checkY = checkY && (frame[j][i] == value);
            }
            if(checkX || checkY){
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка диагоналей на выигрыш
     */
    private static Boolean checkDiagsForWin( int[][] frame, int value) {
        Boolean checkDiag1 = true, checkDiag2 = true;
        for (int i = 0; i < frame.length; i++){
            checkDiag1 = checkDiag1 && (frame[i][i] == value);
            checkDiag2 = checkDiag2 && (frame[frame.length - i - 1][i] == value);
        }
        return checkDiag1 || checkDiag2;
    }

    /**
     * Поиск хода компом
     */
    private static void findBestTurnForAi()throws Exception{
        // Если не найден и заблокирован выигрышный ход человека
        if(!blockHumansWinTurns()) {
            //Тыкнем наугад в незанятое поле
            int x, y;
            do {
                x = (int) (Math.random() * (mapDimension - 1)) + 1;
                y = (int) (Math.random() * (mapDimension - 1)) + 1;
            } while (!isFieldFree(x, y));
            changeMapModel(x, y, aiModel);
        }
    }

    /**
     * Кусок поля по количеству фишек подряд для победы
     */
    private static int[][] getFrame(int startCol, int startRow){
        int[][] frame = new int[lengthForWin][lengthForWin];
        for(int row = startRow; row < startRow + lengthForWin; row ++){
            frame[row - startRow] = Arrays.copyOfRange(mapModel[row], startCol, startCol + lengthForWin);
        }
        return frame;
    }

    /**
     * Проверка компом ходов человека и поиск первого выигрышного
     * Достаточно тупая
     * Только один уровень, без расчета весов потенциально выигрышных ходов,
     * которые впоследствии могут привести к выигрышу
     */
    static private Boolean blockHumansWinTurns() throws Exception{
        for(int x=1; x <= mapDimension; x++){
            for (int y=1; y <= mapDimension; y++){
                if(isFieldFree(x, y)){
                    //сходим за человека
                    changeMapModel(x, y, humanModel);
                    //Проверим на выигрыш
                    if( checkWin(humanModel) ){
                        //вернем модель назад
                        changeMapModel(x, y, 0);
                        //походим туда сами, раз ход выигрышный
                        changeMapModel(x, y, aiModel);
                        //ход был сделан
                        return true;
                    }else{
                        //вернем модель назад
                        changeMapModel(x, y, 0);
                    }
                }
            }
        }
        return false;
    }
}
