package TTTest;

abstract class Book{
    int pages;
    int price;

     public Book(int pages, int price) {
         this.pages = pages;
         this.price = price;
     }

     public void setPages(int pages) {
         this.pages = pages;
     }

     public void setPrice(int price) {
         this.price = price;
     }

     public int getPages() {
         return pages;
     }

     public int getPrice() {
         return price;
     }

     public abstract void show();

 }

 class Magzine extends Book
 {

     int cycle;
     public Magzine(int pages, int price,int cycle) {
         super(pages, price);
         this.cycle=cycle;
     }

     @Override
     public void show() {
         System.out.println("Magzine's price is "+this.price);
         System.out.println("Magzine's page is "+this.pages);
         System.out.println("Magzine's cycle is "+this.cycle+"周");
         System.out.println("==================================");

     }
 }
 class TextBook extends Book{

    String suitableObj;
     public TextBook(int pages, int price,String suitableObj) {
         super(pages, price);
         this.suitableObj=suitableObj;
     }

     @Override
     public void show() {
         System.out.println("TextBook's price is "+this.price);
         System.out.println("TextBook's page is "+this.pages);
         System.out.println("TextBook's suitable object is "+this.suitableObj);
         System.out.println("=====================================");
     }
 }
public class Testmain {


    /*设计一个程序，表达各种读物、如小说、杂志、期刊、课本等，
    每种读物有相同的属性，如页数、价格等，
    也有不同的属性，如杂志和期刊都有出版周期，而课本有适合对象（读者）。
    写一个测试类的main()来产生一些列随机的读物，并输出它们的信息。
    （不需要使用Scanner输入，直接在代码中对各属性进行赋值）*/
    public static void main(String[] args) {
        Magzine mgz1=new Magzine(100,25,5);
        Magzine mgz2=new Magzine(35,30,2);
        Magzine mgz3=new Magzine(40,27,3);
        Magzine mgz4=new Magzine(46,35,4);
        TextBook txtb1=new TextBook(500,15,"中学生");
        TextBook txtb2=new TextBook(600,12,"大学生");
        TextBook txtb3=new TextBook(650,20,"小学生");
        mgz1.show();
        mgz2.show();
        mgz3.show();
        mgz4.show();
        txtb1.show();
        txtb2.show();
        txtb3.show();


    }


}
