package TextFileSplitter;

import javax.xml.soap.Text;

public class FileSplitterDemo {
    public static void main(String[] args) throws InterruptedException {

        FileSplitter fs = new FileSplitter();
        fs.load(".\\data\\demotext.txt");

        System.out.println(fs.getEvenLines().size());
        System.out.println(fs.getOddLines().size());

        TextAnalyzer ta1 = new TextAnalyzer(fs.getEvenLines());
        TextAnalyzer ta2 = new TextAnalyzer(fs.getOddLines());
        
        Thread th1 = new Thread(ta1);
        Thread th2 = new Thread(ta2);
        
        th1.start();th2.start();
        th1.join();th2.join();

        System.out.println("TextAnalyzer.countCharacters = " + TextAnalyzer.countCharacters);
        System.out.println("TextAnalyzer.countByCharacter = " + TextAnalyzer.countByCharacter);
        /*8322413*/
    }
}
