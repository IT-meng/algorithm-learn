package printTable;

//打表法的特征：输入参数和输出参数比较简单
//牛羊吃草，先吃完的获胜
public class EatGrassWinner {

    /*
    *有N份草，谁先吃完谁获胜，返回先手或后手
    * */
    public static String winner1(int N){
        if(N<5){
            if(N==0 || N==2){
                return "后手";
            }else {
                return "先手";
            }
        }
        //N>=5
        //先手尝试自己以怎样的顺序吃草能赢，如果都不能赢则后手赢
        int base = 1;
        while (base<=N){
            //先手吃掉base份草，N-base 份后手吃
            //在母过程里的 先手 在 winner(N-base) 过程里是后手
            if (winner1(N-base).equals("后手")){
                //如果子过程返回的是后手，相当于是主过程里的先手
                    return "先手";
            }
            if(base> N/4){
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    //打表观察规律后
    public static String winner2(int N){
        if(N%5==0 || N%5==2){
            return "后手";
        }else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if(!winner1(i).equals(winner2(i))){
                System.out.println(i);
                System.out.println("err");
                break;
            }
        }
    }
}
