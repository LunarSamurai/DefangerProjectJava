/* What we need
*---------------*
  Javadocs
  Inheritance
  Arraylist [Done]
  InputValidation (Try/Catch) [Done]
  File IO (Output Defanged URL) [Done]
  Test Case
  *---------------*


Input --- http://malwarwe.com

into arraylist --- malwarwe[.]com

Output -- file(defangedURLs.txt)

URL (Obj) -> DefangedUrl(URL)


*/
import java.util.*;
import java.io.*;
class URL {
  protected String urls;
  protected int indexOf;
  public URL(){
  urls = "";
  indexOf = 0;
  }
  public URL(String initurls, int initIndexOf){
    this.urls = initurls;
    this.indexOf = initIndexOf;
  }
  public int getIndexOf(){
    return indexOf;
  }
  public String getURL(){
    return urls;
  }
  public void setIndexOf(int indexOf){
    this.indexOf = indexOf;
  }
  public void setURL(String urls){
    this.urls = urls;
  }
  public String toString(){
    return "";
  }
}
class outputURL extends URL{
  public outputURL(){
  urls = "";
  indexOf = 0;
  }
  public outputURL(String initurls, int initIndexOf){
    this.urls = initurls;
    this.indexOf = initIndexOf;
  }

  @Override
  public String toString(){
    return "Your defang URL is: " + getURL();
  }
}
class defangDriver {
  public static void main(String[] args){
    String urls = "";
    Scanner sc = new Scanner(System.in);
    ArrayList<URL> urlList = new ArrayList<URL>();
    while(true){
      System.out.println(
      "   Hello and welcome to the Virus Total Bois LLC URL defanger application. Please select from the below options\n" +
      "   Remember to handle possible malicious domains with care, One click could compromise your machine! \n" +
      "   1) Enter a URL to defang \n" +
      "   2) Store your defanged Urls in a txt document \n" +
      "   3) View File Contents from the txt documents \n" +
      "   4) Exit the Program");
      int UserInput = sc.nextInt();
        switch(UserInput){
          case 1:
          try{
            System.out.println("You entered: 1");
            System.out.print("Please input a URL: ");
            urls = sc.next();
            outputURL nextTester = new outputURL();
            nextTester.setURL(urls);
            urlList.add(nextTester);
          }catch(Exception e){
             e.printStackTrace();
          }
            break;
          case 2:
            System.out.println("You entered: 2");
            System.out.println("defangURL.txt has your Defanged URLs");
            try {
                    FileWriter writer = new FileWriter("defangURL.txt");
                    writer.write("The following are your defanged URLs\n");
                    writer.write(urlList.toString().replace(".","[.]").replace("http://","hxxp[:]//") + System.lineSeparator());
                    writer.close();
              }catch(Exception e){
                e.printStackTrace();
              }
            break;
          case 3:
            System.out.println("You entered: 4\nYour file contents are as follows: ");
            File file = new File("defangURL.txt");
            if (file.exists()) {
              try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                  String line = null;
                  while ((line = br.readLine()) != null) {
                      System.out.println(line);
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          else {
              System.out.println("file doesn't exist");
          }
            break;
          case 4:
            System.out.println("You entered: 4\nNow exiting program......");
            System.exit(0);
            break;
          default:
            System.out.println("System Error Please Try Again.");
            break;
        }

      }
  }
}
