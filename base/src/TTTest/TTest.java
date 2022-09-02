package TTTest;

public class TTest {
    private String name;
    private String email;
    private int age;

    public TTest(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
   public String emailType(){
        String regex="\\w+@\\w+\\.(com|cn)";
        if(this.email.matches(regex)){
            if(this.email.endsWith("qq.com")){
                return "QQ邮箱";
            }else if(this.email.endsWith("163.com")||this.email.endsWith("126.com")){
                return "网易邮箱";
            }else if(this.email.endsWith("sohu.com")){
                return "搜狐邮箱";
            }else{
                return null;
            }
        }
        return null;
   }

    public static void main(String[] args) {
        TTest stu=new TTest("zhangsan","sdhbs@aliyun.com",19);
        System.out.println(stu.emailType());
    }
}
