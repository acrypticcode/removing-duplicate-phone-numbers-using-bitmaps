import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Project3_flanders {
    public static void main(String[] args) throws FileNotFoundException {
        //sets up input and output files based on file names provided in the command line arguments
        Scanner inFile = new Scanner(new FileReader(args[0]));
        PrintWriter outFile = new PrintWriter(args[1]);
        //defines other variables
        byte bitmap[] = new byte[1000000];
        int pn, bit, bite, hex;
        /*creates a bitmap containing all numbers from the input file
        (repeated numbers from the input file appear only once in the bitmap)*/
        while (inFile.hasNext()){
            pn = inFile.nextInt();
            bite = (pn-2000000)/8;
            bit = (pn-2000000)%8;
            hex = 0x80>>>bit;
            bitmap[bite] = (byte)(bitmap[bite]|hex);
        }
        /*prints the numbers in the bitmap into the output file.
        the numbers are now sorted and there are no duplicate numbers*/
        for (bite=0;bite<1000000;bite++){
            for (bit=0;bit<8;bit++){
                hex = 0x80>>>bit;
                if ((bitmap[bite] & hex) != 0){
                    outFile.println(2000000+bit+8*bite);
                }
            }
        }
        //closes files
        outFile.close();
        inFile.close();
    }
}