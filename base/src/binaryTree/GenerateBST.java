package binaryTree;
//生成二叉排序树
public class GenerateBST {
private BiNode root;
private BiNode root1;

//java的引用本身相当于指针，引用本身在传递时是以值传递的方式进行
    public   BiNode createBST(int[] arr){
         root=new BiNode(arr[0]);
         root1=root;
        for(int i=1;i<arr.length;i++){
            InsertToBST(arr[i]);
            }
    return root1;
        }
    public  void InsertToBST(int data){
       if(data>root.data){
           if(root.right==null){
               root.right=new BiNode(data);
               root=root1;
               return;
           }else
           {
               root=root.right;
               InsertToBST(data);
           }
       }else{
           if(root.left==null){
               root.left=new BiNode(data);
               root=root1;
               return;
           }else
           {
               root=root.left;
               InsertToBST(data);
           }
       }


    }
}
