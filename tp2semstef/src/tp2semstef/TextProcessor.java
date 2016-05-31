package tp2semstef;

import java.io.*;   //Импорт библиотек
import java.util.ArrayList;
import java.util.Arrays;


public class TextProcessor {
    private BufferedReader reader; //Переменная читалки.
    private BufferedWriter writer1; //Переменная писалки в первый файл.
    private BufferedWriter writer2; //Переменная писалки во второй файл.
    public TextProcessor (){
        reader =null;   //Присвоение переменным "пустоты"
        writer1 =null;  //Вроде может работать и без этого, но мне  не посебе
        writer2 = null; //Ибо без них было пару косяков.
    }
    //Метод - открывашка потоков
    public TextProcessor (String sourceFilePath, String resultFilePath1, String resultFilePath2) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(sourceFilePath); //Открывает поток к файлу
        reader = new BufferedReader(fr);    //Присваем поток к читалке
        FileWriter fw = new FileWriter(resultFilePath1);
        writer1 = new BufferedWriter(fw);
        FileWriter fw2 = new FileWriter(resultFilePath2);
        writer2 = new BufferedWriter(fw2);
    }
    //Метод переустановки путей чтения
    public void SetSourceFilePath(String sourceFilePathString) throws IOException{
        reader.close();
        FileReader fr = new FileReader(sourceFilePathString);
        reader = new BufferedReader(fr);
    }
    //Метод переустановки путей записи
    public void SetResultFilePath(String resutFilePath1, String resultFilePath2) throws IOException{
        writer1.close();
        FileWriter fw = new FileWriter(resutFilePath1);
        writer1 = new BufferedWriter(fw);
        writer2.close();
        FileWriter fw2 = new FileWriter(resultFilePath2);
        writer2 = new BufferedWriter(fw2);
    }
    //Метод-закрывашка потока читалки
    public void CloseReader() throws IOException{
        reader.close();
    }
    //Метод-закрывашка потока писалки
    public void CloseWriter() throws IOException{
        writer1.close();
        writer2.close();
    }
    //Метод - читалка потока. Возвращает строку.
    public String ReadLine() throws IOException{
       if(reader.readLine()==null)
           return null;
       else
           return reader.readLine();
    }
    //Метод - крутая читалка. Читает все и возвращает аж целый лист!
    public ArrayList<String> ReadAll() throws IOException{
        ArrayList<String> list = new ArrayList<>();
        while(reader.ready()){
            list.add(reader.readLine());
        }
        return list;
    }
    //Метод писалка
    public boolean WriteLine(String line, int i){
        try{
            if(i==1){
                writer1.write(line);
                return true;
            }else{
                writer2.write(line);
                return true;
            }
        } catch (Exception ex){
            return false;
        }
    }
    //Метод писалка которая пишет сразу из листа.
    public int WriteLines(ArrayList<String> list, int i){
        if(i ==1){
            int WrLnOk = 0;
            try {
               for (String item : list){
                   writer1.write(item);
                   WrLnOk++;
               } 
               return WrLnOk;
            } catch (Exception ex) {
                return WrLnOk;
            }
        }else{
            int WrLnOk = 0;
            try {
               for (String item : list){
                   writer2.write(item);
                   WrLnOk++;
               } 
               return WrLnOk;
            } catch (Exception ex) {
                return WrLnOk;
            }
        }
    }
    //Пожалуй самое важное. Метод с индивидуальным заданием (его выполнением)
    public void MakeTask() throws IOException{
        String line;
        ArrayList<String> linesNotZero = new ArrayList<>();
        ArrayList<String> stringCount = new ArrayList<>();
        ArrayList<String> out = new ArrayList<>();
        int i;
        while(reader.ready()) {            
          line = reader.readLine();
          String[] arr = line.split("#");
          if(Integer.parseInt(arr[2])==0){
              WriteLine(line+"\n", 2);
          }else{
              stringCount.add(arr[2]);
              linesNotZero.add(line);
          }
        }
        i = linesNotZero.size();
        Integer[] countInt = new Integer[i];
        for (int k=0; k < i; k++) {
            countInt[k] = Integer.parseInt(stringCount.get(k));
        }
         Arrays.sort(countInt);
        for(int k = 0;k<i;k++){
           for(int j = 0;j<i;j++){
              if(countInt[k]==Integer.parseInt(stringCount.get(j))){
                 out.add(linesNotZero.get(j)+"\n");
              }
            }
        }
        WriteLines(out, 1);
        writer2.flush();    //Принужнаем писалку записать!
        writer1.flush();    //И эту тоже! >:3   
    }
}
//Сомневаюсь, что кто-то до сюда дойдет, но все равно, привет!