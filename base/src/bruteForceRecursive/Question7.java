package bruteForceRecursive;

public class Question7 {


    //int[] weights :weights[i]表示第i号货物的重量
    // int[] values：values[i]表示第i号货物的价值
    // int i:表示当前来到第i号货物的位置
    // int alreadyWeight:表示之前的选择所达到的重量
    // int bag:表示背包的容量
    //返回值表示i...及其往后的位置的货物所能形成的最大价值
    public static int process(int[] weights,int[] values,
                              int i,int alreadyWeight,int bag){
        //这种尝试有问题
        if(alreadyWeight>=bag){
            return 0;//之前的选择无效
        }

        if(i==values.length){
            return 0;//已经没有货物了返回零
        }
        return Math.max(
                //要当前货物
               values[i]+ process(weights,values,i+1,
                        alreadyWeight+weights[i],bag),
                //不要当前货物
                process(weights,values,i+1,
                        alreadyWeight,bag)
        );

    }
    public static int process2(int[] weights,int[] values,
                              int i,int alreadyWeight,
                               int alreadyValue,int bag){
//
//        if(alreadyWeight>bag){
//            return 0;
//        }
        if(i==weights.length || alreadyWeight>=bag) {
            return alreadyValue;
        }
        return Math.max(
                process2(weights,values,i+1,alreadyWeight+weights[i],
                        alreadyValue+values[i],
                        bag),
                process2(weights,values,i+1,alreadyValue,
                        alreadyValue,bag)
        );
    }

    //只有process3是对的
public static int process3(int[] weights,int[] values,
                           int i,int alreadyWeight,
                           int alreadyValue,int bag){
        if(i==weights.length)return alreadyValue;
        if((alreadyWeight<bag && alreadyWeight+weights[i]>bag)||alreadyWeight==bag){
            return process3(weights,values,i+1,
                    alreadyWeight,alreadyValue,bag);
        }else if(alreadyWeight>bag){
            return 0;
        }
        else {
            return Math.max(
                    process3(weights,values,i+1,alreadyWeight+weights[i],
                            alreadyValue+values[i],
                            bag),
                    process3(weights,values,i+1,alreadyValue,
                            alreadyValue,bag)
            );
        }

}
    public static void main(String[] args) {
        int[] weights={1,2,3,4};
        int[] values={4,3,2,10};
        int bag=9;
        System.out.println(process(weights,values,
       0,0,bag ));
        System.out.println("============");
        System.out.println(process2(weights,values,
       0,0,0,bag ));
        System.out.println("============");
        System.out.println(process3(weights,values,
                0,0,0,bag ));
    }
}
