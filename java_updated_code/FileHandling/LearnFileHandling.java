package FileHandling;

import java.io.*;
import java.util.Scanner;


public class LearnFileHandling {
    public static void main(String[] args) throws FileNotFoundException {

//        reading inputs

//        try (InputStreamReader num = new InputStreamReader(System.in)) {
//            System.out.print("Enter some letters :: ");  // 123
//            int letters = num.read();
//            while (num.ready()) {
//                System.out.println((char) letters);  // converts and prints each letter in a char - 1, 2, 3
//                letters = num.read();
//            }
//            num.close();
//            // if we are handling files inside a try-catch block, .close() will be done by default
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }



//        reading files

//        try (FileReader file = new FileReader("./src/main/java/FileHandling/note.txt")) {
//            int letters = file.read();
//            // taking letters as an int as .read() reads the file contents as ASCII value
//            // since every character in the file has an ASCII value, that is getting stored inside letter.
//            // if we had taken letter as a char type, it will be throwing error since .read() is
//            // reading the contents as an ASCII value.
//
//            while (file.ready()) {
//                System.out.println((char) letters);
//                // converting those int ASCII values in char to print
//                // if we don't convert, then directly those ASCII values will be printed
//                letters = file.read();
//            }
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//      buffered reader

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            // converting byte stream to char and reading that as a char stream.
//
//            System.out.print("Type something :: ");
//            System.out.println("You typed " + br.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        try (BufferedReader br2 = new BufferedReader(new FileReader("./src/main/java/FileHandling/note.txt"))) {
//            // converting file stream to char and reading that as a char stream.
//
//            while (br2.ready()) {
//                System.out.println(br2.readLine());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//      Output stream
        OutputStream os = System.out;
        // os.write(🤔);
        // it will throw error, since output stream writes byte data, but an emoji is of character

//        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
//            osw.write("hello there..");
//            osw.write(97);  // 97 means 'a'
//            osw.write(10);  // 10 is a new line, so 10 == \n
//            osw.write('A');
//            osw.write("  --  ");
//            osw.write('\n');
//
//            char[] arr = "hello hello".toCharArray();
//            osw.write(arr);
//
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        try (FileWriter fw = new FileWriter("./src/main/java/FileHandling/note.txt", true)) {
//            // if we add true after file name, then also we can append to the existing file using .write()
//
//            fw.write("changed again!");  // overwrite the existing text, if true wasn't added with file name
//            fw.append("and this is appended.");  // this also we can use to append at the end of the existing text
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/FileHandling/note.txt"))) {
//            // if we add true after file name, then also we can append to the existing file using .write()
//
//            bw.write("changed again twice ");  // overwrite the existing text, if true wasn't added with file name
//            bw.append("and this is appended again.");  // this also we can use to append at the end of the existing text
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }



        // creating a new file
        try {
            File fo = new File("./src/main/java/FileHandling/new-file.txt");
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // write in the new file
        try {
            FileWriter fw = new FileWriter("./src/main/java/FileHandling/new-file.txt");
            fw.write("it is done.");
            fw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // read that file
        try (BufferedReader br2 = new BufferedReader(new FileReader("./src/main/java/FileHandling/new-file.txt"))) {
            while (br2.ready()) {
                System.out.println(br2.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // delete that file
        try {
            File fo = new File("./src/main/java/FileHandling/new-random-file.txt");
            fo.createNewFile();
            if (fo.delete()) {
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}

/*

Streams --

It is a sequence of data (data of byte value or unicode/ character value). Java performs input output
through these streams.
This is actually an abstraction that java provides, basically it hides all the complexity within itself.

The stream is connected with the keyboard for getting the user inputs.

Java implements these within the class hierarchies defined in java.io package.
To take inputs this is the code for taking user inputs:
Scanner sc = new Scanner(System.in)

Scanner is the constructor of the Scanner class.

In the System.in, the "in" is a reference variable of type InputStream, the "in" is a pre-defined variable
for taking inputs from keyboard. There is also a type OutputStream.

Streams are like abstract classes which have some predefined rules like what kind if data we want to read or write.
In java 2 types of stream is there: byte stream and character stream.

Byte stream is used to handle input and output of bytes of data, like reading/ writing an image or a document -
files which contain binary data.
Byte stream is extended by 2 child classes - InputStream and OutputStream.

Character stream is used to handle input - output of unicode characters, which means it handle multiple
languages like hindi, japanese etc.
Character stream is extended by 2 child classes - Reader and Writer.


The input stream has a method - read() to read any data.
The output stream has a method - write() to write an data.

----------------------------------------------------------------------------

IOException --

Anytime we are trying to fetch files and some error occurred like file not found, or file is corrupted or
file is unable to read, that time we can use this IOException to handle these errors.

----------------------------------------------------------------------------

Predefined streams --

System.out -- standard output stream - to console  -- print stream type
System.in -- standard input stream - from keyboard -- input stream type
System.err -- standard error stream - to console -- print stream type

Example::
System.out.print / System.out.println -- are actually these output stream only.

----------------------------------------------------------------------------

When ever we are starting to take input with the input streams, we need to close them as well. Closing
these streams releases any resources that are associated with it.

What do we mean by releasing any resource ?

In class which is implementing the AutoClosable we can consider that class as a resource. We should close
these, as these objects will hold those resources (like a file) until it is closed.

----------------------------------------------------------------------------

Buffered reader -- reads text from a character-input stream, it has both the input stream reader and
file reader. It also has a method, readLine() - it reads a line of text.

If we take public BufferedReader(Reader in) -- it takes a character input stream.
So within BufferedReader we cannot take (System.in), as System.in takes byte input and
Reader takes character input.

So how to take byte input while using Buffered reader -- with Input stream reader. So system.in will
take the input as byte, then we can convert it into character type and then on that data, we can
use buffered reader.

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
InputStreamReader(System.in) -- takes input in byte and converts it into char.
then, br is reading the character based string which we gave as an input from keyboard.


*/