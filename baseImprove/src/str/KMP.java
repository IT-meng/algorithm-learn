package str;


public class KMP {

    public static int kmp(String str, String model){
        int[] next=getNextArray(model);
        int i=0,k=0;//i:str下标 k:model下标
        while(i<str.length()&&k<model.length()){//两个下标都不越界时
            if(str.charAt(i)==model.charAt(k)){//i位置和k位置能匹配上，两个都往后跳
                i++;
                k++;
            }else if(k==0){//当k来到0位置，i++,k往前跳已经跳到不能再跳了，麻烦str换个开头
                i++;
            }else{
                k=next[k];//匹配失败，且k!=0,k往前跳
            }
        }
        //跳出while循环后如果是k越界则说明匹配成功，i越界则匹配失败
        return k>=model.length()?i-model.length():-1;
    }

    public static int[] getNextArray(String model){
      int[] next=new int[model.length()];
      if(model.length()==1){
          next[0]=-1;
          return next;
      }
      //人为规定
       next[0]=-1;
       next[1]=0;
       int i=2;//从2位置开始求next[i]的值
       int k=next[i-1];//k表示：k位置的字符和i-1位置的字符进行比较
       while(i<model.length()){
           if(model.charAt(i-1)==model.charAt(k)){
               next[i++]=++k;
//               next[i]=k+1;匹配成功：next[i]=next[i-1]+1
//               i++;求下一个位置的next值
//               k=next[i-1];维持k的意义不变,相当于：k++
           }else if(k>0){
               //匹配失败了，但k还能往前跳
               k=next[k];
           }else{
               //匹配失败且k不能够再往前跳
               next[i++]=0;
               //next[i]=0;i++;
           }
       }
        return next;
    }

    public static void main(String[] args) {
        String str="googlgoogegooglegggoooggle";
        String model="google";
        System.out.println(kmp(str,model));
    }


}
